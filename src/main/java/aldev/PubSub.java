package aldev;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PubSub
 */
public class PubSub {

  private Map<String, Set<AbstractSubscriber>> topicSubscriberMap = new HashMap<>();

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
}