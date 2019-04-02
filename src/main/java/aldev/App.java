package aldev;

import org.json.JSONObject;

import aldev.company.Admin;
import aldev.pubsub.Message;
import aldev.pubsub.PubSub;
import aldev.server.Server;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {

        // Server para receber mensagens
        Server server = new Server(3000);
        new Thread(server).start();



        PubSub pubSub = new PubSub();
        Admin gio = new Admin("Giovanni", 1);
        JSONObject adminJson = new JSONObject(gio);
        Message message = new Message("admins", adminJson.toString());
        System.out.println(adminJson.toString());
        pubSub.sendMessage(message);
    }
}
