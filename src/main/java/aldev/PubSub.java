package aldev;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * PubSub
 */
public class PubSub {

  private Map<String, Set<AbstractSubscriber>> topicSubscriberMap = new HashMap<>();
  private Queue<Message> messagesQueue = new LinkedList<>();

  public void addMessage(Message message) {
    messagesQueue.add(message);
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
}