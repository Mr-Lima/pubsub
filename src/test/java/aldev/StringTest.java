package aldev;

import org.json.JSONObject;

public class StringTest {

  public static void main(String[] args) {
    Pessoa pessoa = new Pessoa("Andre");

    JSONObject object = new JSONObject(pessoa);
    System.out.println(object.toString());
  }
}