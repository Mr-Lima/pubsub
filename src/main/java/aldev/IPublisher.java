package aldev;

/**
 * Publisher
 */
public interface IPublisher {

  public boolean publish(Message message, PubSub service);
}