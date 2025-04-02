import javax.swing.*;

public class Main {
    
    // method to show a new window after successful login
    public static void showDetails(String username) {
        JFrame detailsFrame = new JFrame("Welcome");
        detailsFrame.setSize(400, 300);
        detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailsFrame.setLayout(null);

        JLabel welcomeLabel = new JLabel("Hello! " + username + " welcome to your dashboard!");
        welcomeLabel.setBounds(100, 50, 400, 45);
        detailsFrame.add(welcomeLabel);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(140, 120, 100, 30);
        detailsFrame.add(logoutButton);

        logoutButton.addActionListener(e -> {
            detailsFrame.dispose(); // close the dashboard
        });

        detailsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(50, 30, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(140, 30, 150, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("password:");
        passLabel.setBounds(50, 70, 80, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(140, 70, 150, 25);
        frame.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 120, 100, 30);
        frame.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(50, 160, 250, 25);
        frame.add(messageLabel);


        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passText.getPassword());

            if (username.equals("yashwant") && password.equals("$weetHome")) {
                messageLabel.setText("Login Successful!");
                frame.dispose(); // close login window
                showDetails(username); // open dashboard
            } else {
                messageLabel.setText("Invalid Credentials");
            }
        });

        frame.setVisible(true);
    }
}
