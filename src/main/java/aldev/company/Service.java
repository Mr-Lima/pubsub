package aldev.company;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import aldev.utils.StringUtils;

/**
 * Service
 */
public class Service {
  public static HashMap<String, Service> services = new HashMap<String, Service>();
  // private Queue<Ticket> waitingPasswords;
  
  private String name;
  private String acronym;
  private int passwordCounter = 1;

  public Service(String name) {
    this.name = name;
    this.acronym = StringUtils.formAcronym(this.name);
    services.put(this.acronym, this);
  }

  public int generatePassword() {
    return this.passwordCounter++;
  }

  // public Ticket nextPassword() {
  //   Ticket ticket = this.waitingPasswords.poll();
  //   this.attendedPasswords.add(ticket);
  //   return ticket;
  // }

  // public void addAttendedPassword(Ticket ticket) {
  //   if (ticket.getServAcronym().equalsIgnoreCase(this.acronym)) {
  //     throw new AssertionError("The ticket is not from this service");
  //   } else {
  //     this.attendedPasswords.add(ticket);
  //   }
  // }

  /**
   * @return the passwordCounter
   */
  public int getPasswordCounter() {
    return passwordCounter;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the acronym
   */
  public String getAcronym() {
    return acronym;
  }

  //FIXME
  // @Override
  // public String toString() {
  //   return "{" + "Name: " + this.name + "; Acronym: " + this.acronym + "; Waiting: " + this.waitingPasswords.toString()
  //       + "; Attended: " + this.attendedPasswords.toString() + "}";
  // }
}