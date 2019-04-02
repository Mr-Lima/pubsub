package aldev.company;

/**
 * Employee
 */
public abstract class Employee {
  protected String name;
  protected int registry;

  public Employee(String name, int registry) {
    this.name = name;
    this.registry = registry;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the registry
   */
  public int getRegistry() {
    return registry;
  }
}