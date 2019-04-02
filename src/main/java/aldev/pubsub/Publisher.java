package aldev.pubsub;

/**
 * Publisher
 */
public interface Publisher {

  public default void publish(Message message, PubSub service) {
    service.sendMessage(message);
  };
}