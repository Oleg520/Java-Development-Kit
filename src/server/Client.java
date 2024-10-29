package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    private final JPanel authorizationPanel = new JPanel(new GridLayout(2, 3));
    private final JTextField ipField = new JTextField("192.167.0.1");
    private final JTextField portField = new JTextField("port");
    private final JTextField loginField = new JTextField("login");
    private final JPasswordField passwordField = new JPasswordField("password");
    private final JButton loginButton = new JButton("Login");

    private final JPanel messagePanel = new JPanel(new BorderLayout());
    private final JTextField messageField = new JTextField();
    private final JButton sendButton = new JButton("Send");
    private static final JTextArea messageArea = new JTextArea();

    private final JList<String> userList;
    private final String[] users = {"Игорь", "Настя", "Костя", "Сергей", "Антон"};

    Client() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat server");

        authorizationPanel.add(ipField);
        authorizationPanel.add(portField);
        authorizationPanel.add(loginField);
        authorizationPanel.add(passwordField);
        passwordField.setEchoChar('*');
        authorizationPanel.add(loginButton);
        add(authorizationPanel, BorderLayout.NORTH);

        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);
        JScrollPane textAreaScrollPane = new JScrollPane(messageArea);
        add(textAreaScrollPane);
        userList = new JList<>(users);
        JScrollPane usersScrollpane = new JScrollPane(userList);
        add(usersScrollpane, BorderLayout.EAST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ServerWindow.getServerStatus()) {
                    SendMessage(messageField.getText());
                }
            }
        });

        setVisible(true);
    }

    protected static void fillMessageArea() {
        messageArea.setText(ServerWindow.readLog());
    }

    protected static void clearMessageArea() {
        messageArea.setText("");
    }

    private void SendMessage(String message) {
        String text = message.concat("\n");
        messageArea.append(text);
        messageField.setText("");
        ServerWindow.saveMessageToLog(text);
    }

    public static void main(String[] args) {
        new Client();
    }
}
