package aldev;

/**
 * Message
 */
public class Message {

  private String topic;
  private String payload;

  public Message(String topic, String payload) {
    this.topic = topic;
    this.payload = payload;
  }

  /**
   * @return the payload
   */
  public String getPayload() {
    return payload;
  }

  /**
   * @param payload the payload to set
   */
  public void setPayload(String payload) {
    this.payload = payload;
  }

  /**
   * @return the topic
   */
  public String getTopic() {
    return topic;
  }

  /**
   * @param topic the topic to set
   */
  public void setTopic(String topic) {
    this.topic = topic;
  }

  @Override
  public String toString() {
    return String.format("Topic: %s\nPayload: %s", this.topic, this.payload);
  }
}