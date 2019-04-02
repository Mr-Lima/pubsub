package aldev.pubsub;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * PubSub
 */
public class PubSub {

  private Map<String, Set<AbstractSubscriber>> topicSubscriberMap = new HashMap<>();
  private Queue<Message> messagesQueue = new LinkedList<>();
  private Thread workerQueue = new Thread(new Broadcaster());
  private Socket clientSocket;

  public PubSub() throws UnknownHostException, IOException {
    workerQueue.start();
    clientSocket = new Socket("127.0.0.1", 80);

  }

  public void sendMessage(Message message) {
    messagesQueue.add(message);
    workerQueue.notify();
  }

  public void addSubscriber(String topic, AbstractSubscriber subscriber) {

    if (topicSubscriberMap.containsKey(topic)) {
      Set<AbstractSubscriber> subscribers = topicSubscriberMap.get(topic);
      subscribers.add(subscriber);
    } else {
      Set<AbstractSubscriber> subscribers = new HashSet<>();
      subscribers.add(subscriber);
      topicSubscriberMap.put(topic, subscribers);
    }
  }

  public void removeSubscriber(String topic, AbstractSubscriber subscriber) {

    Set<AbstractSubscriber> subscribers = topicSubscriberMap.get(topic);
    subscribers.remove(subscriber);
  }

  public void getMessageForSubscriber(String topic, AbstractSubscriber subscriber) {
    Queue<Message> messages = messagesQueue;
    while (!messages.isEmpty()) {
      Message message = messages.remove();

      if (message.getTopic().equalsIgnoreCase(topic)) {
        Set<AbstractSubscriber> subscribers = topicSubscriberMap.get(topic);
        subscribers.forEach(_subscriber -> {
          if (_subscriber.equals(subscriber)) {
            List<Message> subscriberMessages = _subscriber.getSubscriberMessages();
            subscriberMessages.add(message);
            _subscriber.setSubscriberMessages(subscriberMessages);
          }
        });
      }
    }
  }

  public void broadcast() {
    while (!this.messagesQueue.isEmpty()) {
      Message message = messagesQueue.remove();

      Set<AbstractSubscriber> subscribers = topicSubscriberMap.get(message.getTopic());

      subscribers.forEach(subscriber -> {
        List<Message> messages = subscriber.getSubscriberMessages();
        messages.add(message);
        subscriber.setSubscriberMessages(messages);
      });
    }
  }

  private class Broadcaster implements Runnable {

    public void run() {

      while (true) {
        broadcast();
        try {
          workerQueue.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

    }
  }
}