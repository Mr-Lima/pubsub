package aldev.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clerk
 */
public class Clerk extends Employee {
  public static HashMap<Integer, Clerk> clerks = new HashMap<>();
  private Ticket currentTicket;
  private int dock;
  private List<Ticket> attendedTickets;

  public Clerk(String name, int registry, int dock) {
    super(name, registry);
    this.dock = dock;
    this.attendedTickets = new ArrayList<>();
    Clerk.clerks.put(this.registry, this);
  }

  public void avoidTicket() {
    this.currentTicket = null;
  }

  public Ticket callNext() {

    if (this.currentTicket != null) {

      Ticket.attendedTickets.add(this.currentTicket);
      this.attendedTickets.add(this.currentTicket);
    }

    this.currentTicket = Ticket.waitingTickets.poll();
    this.currentTicket.setDock(this.dock);
    this.currentTicket.setClerkRegistry(this.registry);
    return this.currentTicket;
  }

  @Override
  public String toString() {
    // TODO: adicionar lista de tickets atendidos
    return "{" + "Name: " + this.name + "; Dock: " + this.dock + "; In Process: " + this.currentTicket + "}";
  }

  /**
   * @return the currentTicket
   */
  public Ticket getCurrentTicket() {
    return currentTicket;
  }

  /**
   * @return the attendedTickets
   */
  public List<Ticket> getAttendedTickets() {
    return attendedTickets;
  }
}