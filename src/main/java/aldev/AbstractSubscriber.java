package aldev;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubscriber {

  private List<Message> subscriberMessages = new ArrayList<>();

  /**
   * @return the subscriberMessages
   */
  public List<Message> getSubscriberMessages() {
    return subscriberMessages;
  }

  /**
   * @param subscriberMessages the subscriberMessages to set
   */
  public void setSubscriberMessages(List<Message> subscriberMessages) {
    this.subscriberMessages = subscriberMessages;
  }

  public abstract void addSubscriber(String topic, PubSub service);

  public abstract void unSubscribe(String topic, PubSub service);

  public abstract void getMessagesForSubscriberOfTopic(String topic, PubSub service);

  public void printMessages() {
    subscriberMessages.forEach(message -> message.toString());
  }
}