package aldev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * HashMapTest
 */
public class HashMapTest {

  @Test
  public void testGet() {
    HashMap<Integer, Pessoa> pessoas = new HashMap<>();
    pessoas.put(1, new Pessoa("Andre"));

    Pessoa andre = pessoas.get(1);
    andre.setName("Lima");
    System.out.println(andre.getName());
    System.out.println(pessoas.get(1).getName());
    assertEquals("Lima", andre.getName());
    assertEquals("Lima", pessoas.get(1).getName());
  }
}