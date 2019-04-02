package aldev.company;

/**
 * Client
 */
public class Client {
  private Ticket ticket;

  public Client() {

  }

  public Ticket generateTicket(String serviceAcronym) {
    if (!Service.services.containsKey(serviceAcronym)) {
      throw new NullPointerException("This service do not exist");
    } else {

      Ticket ticket = new Ticket(serviceAcronym);
      this.ticket = ticket;
      return this.ticket;
    }
  }
}