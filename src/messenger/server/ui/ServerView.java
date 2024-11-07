package messenger.server.ui;

import messenger.server.domain.ServerController;

public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}