package aldev.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import aldev.pubsub.Publisher;

/**
 * Admin
 */
public class Admin extends Employee implements Publisher {

  public Admin(String name, int registry) {
    super(name, registry);
  }

  public Service addService(String name) {
    return new Service(name);
  }

  public Clerk addClerk(String name, int registry, int dock) {
    return new Clerk(name, registry, dock);
  }

  public String brief() {

    HashMap<Integer, Clerk> clerks = Clerk.clerks;
    HashMap<String, Service> services = Service.services;

    StringBuilder builder = new StringBuilder();
    builder.append("Brief:\n----------------------\n");
    builder.append("Services: \n");
    for (Service service : services.values()) {

      builder.append(service.toString() + "\n");
    }

    builder.append("------------------\n");
    builder.append("Clerks: \n");
    for (Clerk clerk : clerks.values()) {
      builder.append(clerk.toString() + "\n");
    }

    return builder.toString();
  }

  public List<Ticket> ticketsNotAttended() {

    return new ArrayList<Ticket>(Ticket.waitingTickets);
  }

  public List<Ticket> clerkTickets(int clerkRegistry) {

    return Clerk.clerks.get(clerkRegistry).getAttendedTickets();
  }

  public Ticket deleteTicket(String servAcronym, int number) {

    ArrayList<Ticket> ticketsList = new ArrayList<>(Ticket.waitingTickets);
    PriorityQueue<Ticket> ticketsQueue = new PriorityQueue<>();
    Ticket deleted = null;

    for (Ticket ticket : ticketsList) {
      if (ticket.getServAcronym().equalsIgnoreCase(servAcronym) && ticket.getNumber() == number) {
        deleted = ticket;
      } else {
        ticketsQueue.add(ticket);
      }
    }

    Ticket.waitingTickets = ticketsQueue;

    if (deleted == null) {
      throw new NullPointerException("This ticket do not exist");
    } else {
      return deleted;
    }

  }

  public List<Ticket> clerkAttendedTickets(int clerkRegistry) {

    Clerk clerk = Clerk.clerks.get(clerkRegistry);
    return clerk.getAttendedTickets();
  }
}