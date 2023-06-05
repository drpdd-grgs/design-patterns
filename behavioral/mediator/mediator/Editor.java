package behavioral.mediator.mediator;

import behavioral.mediator.component.*;
import behavioral.mediator.component.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Editor implements Mediator {

    private UserList userList;
    private AddButton addButton;
    private DeleteButton deleteButton;
    private SelectButton selectButton;
    private UserTitle userTitle;
    private MessageInput messageInput;
    private MessageBox messageBox;
    private SendButton sendButton;

    private final JLabel userTitleLabel;
    private final JLabel messageInputLabel;
    private final JLabel messagesLabel;

    public Editor() {
        userTitleLabel = new JLabel("User: ");
        messageInputLabel = new JLabel("Message: ");
        messagesLabel = new JLabel("Messages: ");
    }

    @Override
    public void addUser(User user) {
        userList.addUser(user);
    }

    @Override
    public boolean userExists(String userName) {
        return userList.userExists(userName);
    }

    @Override
    public void deleteUser() {
        User selected = getSelectedUser();
        userList.deleteUser();
        if (userTitle.getUser().equals(selected)) {
            userTitle.clearUser();
        }
    }

    @Override
    public User getSelectedUser() {
        return userList.getSelectedUser();
    }

    @Override
    public void sendUserToTitle(User user) {
        userTitle.setUser(user);
    }

    @Override
    public void sendMessage() {
        User sender = userTitle.getUser();
        String message = messageInput.getMessage();
        if (sender != null && message != null && message.length() > 0) {
            messageBox.getMessage(sender, message);
        }
    }

    @Override
    public void init() {
        JFrame frame = new JFrame("Mediator");
        frame.setSize(960, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        left.setBorder(new LineBorder(Color.BLACK));
        left.setSize(320, 600);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel userListPanel = new JPanel();
        userList.setFixedCellWidth(260);
        userListPanel.setSize(320, 470);
        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setPreferredSize(new Dimension(275, 410));
        userListPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        addButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(addButton);
        deleteButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(deleteButton);
        selectButton.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(selectButton);

        left.add(userListPanel);
        left.add(buttonPanel);

        JPanel right = new JPanel();
        right.setLayout(null);
        right.setSize(640, 600);
        right.setLocation(320, 0);
        right.setBorder(new LineBorder(Color.BLACK));

        userTitleLabel.setBounds(20, 4, 50, 20);
        userTitle.setBounds(60, 5, 555, 20);
        messageInputLabel.setBounds(20, -25, 100, 130);
        messageInput.setBorder(new LineBorder(Color.DARK_GRAY));
        messageInput.setBounds(20, 55, 500, 25);
        messagesLabel.setBounds(20, 45, 100, 130);
        messageBox.setBorder(new LineBorder(Color.DARK_GRAY));
        messageBox.setBounds(20, 120, 595, 410);
        messageBox.setEditable(false);
        sendButton.setBounds(530, 55, 85, 25);

        right.add(userTitleLabel);
        right.add(userTitle);
        right.add(messageInputLabel);
        right.add(messageInput);
        right.add(sendButton);
        right.add(messagesLabel);
        right.add(messageBox);

        frame.setLayout(null);
        frame.getContentPane().add(left);
        frame.getContentPane().add(right);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void addComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "UserList":
                userList = (UserList) component;
                break;
            case "AddButton":
                addButton = (AddButton) component;
                break;
            case "DeleteButton":
                deleteButton = (DeleteButton) component;
                break;
            case "SelectButton":
                selectButton = (SelectButton) component;
                break;
            case "UserTitle":
                userTitle = (UserTitle) component;
                break;
            case "MessageInput":
                messageInput = (MessageInput) component;
                break;
            case "MessageBox":
                messageBox = (MessageBox) component;
                break;
            case "SendButton":
                sendButton = (SendButton) component;
                break;
        }
    }

}
