package aldev.company;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Ticket
 */
public class Ticket {
  public static Queue<Ticket> waitingTickets = new PriorityQueue<>();
  public static Queue<Ticket> attendedTickets = new PriorityQueue<>();

  private String servAcronym;
  private int number;
  private int dock;
  private int clerkRegistry;

  public Ticket(String servAcronym) {
    this.servAcronym = servAcronym;
    this.number = Service.services.get(servAcronym).generatePassword();
    Ticket.waitingTickets.add(this);
  }

  /**
   * @param clerkRegistry the clerkRegistry to set
   */
  public void setClerkRegistry(int clerkRegistry) {
    this.clerkRegistry = clerkRegistry;
  }

  /**
   * @param dock the dock to set
   */
  public void setDock(int dock) {
    this.dock = dock;
  }

  /**
   * @return the servAcronym
   */
  public String getServAcronym() {
    return servAcronym;
  }

  /**
   * @return the number
   */
  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return this.servAcronym + "-" + this.number;
  }
}