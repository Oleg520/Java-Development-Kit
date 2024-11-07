package messenger;

import messenger.client.ui.ClientGUI;
import messenger.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        new ServerWindow();
        new ClientGUI();
    }
}
