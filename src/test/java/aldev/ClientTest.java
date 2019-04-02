package aldev;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClientTest
 */
public class ClientTest {
  private Socket client;
  private String textRequest;
  private String textResponse;

  public ClientTest(Socket client) {

  }

  public void run() {

  }

  public static void main(String[] args) {

    final int PORT = 3000;
    final String host = "127.0.0.1";

    Socket client;
    try {

      client = new Socket(host, PORT);
      OutputStream out = client.getOutputStream();
      // JSONObject pessoaJson = new JSONObject(new Pessoa("Andre"));
      String nome = "algo aqui";
      byte buf[] = nome.getBytes();
      out.write(buf);
      client.close();

    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}