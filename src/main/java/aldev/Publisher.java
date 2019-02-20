package aldev;

/**
 * Publisher
 */
public interface Publisher {

  public boolean publish(Message message, PubSub service);
}