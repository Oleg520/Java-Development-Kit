package server;

import server.writer.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ServerWindow extends JFrame {
    private static FileHandler fileHandler = new FileHandler();
    private static final String pathProject = System.getProperty("user.dir");
    private static final String pathFile = pathProject.concat("/src/server/log.txt");
    private static final File logFIle = new File(pathFile);

    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private static boolean isServerWorking;

    private JTextArea textArea;

    public ServerWindow() {
        fileHandler.setPath(logFIle);
        isServerWorking = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat server");
        setResizable(false);
        setAlwaysOnTop(true);
        textArea = new JTextArea();
        textArea.setFont(new Font("TimesNewRoman",Font.BOLD,35 ));
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
        setLayout(new GridLayout(2,1));
        add(textArea);
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        add(btnPanel);
        setVisible(true);
    }

    private void stopServer() {
        if (!isServerWorking){
            textArea.setText("Сервер не запущен");
        }else {
            isServerWorking = false;
            Client.clearMessageArea();
            textArea.setText("Сервер остановлен");
        }
    }

    private void startServer() {
        if (isServerWorking){
            textArea.setText("Сервер уже работает");
        }else {
            isServerWorking = true;
            Client.fillMessageArea();
            textArea.setText("Сервер запущен");
        }
    }

    public static boolean getServerStatus(){
        return isServerWorking;
    }
    public static String readLog(){
        return fileHandler.read();
    }
    public static void saveMessageToLog(String text){
        fileHandler.save(text);
    }
}
