import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// if we dont do this then program wont terminate when we click close button
        
		frame.setLayout(null);
		// we dont want any default layout managers

        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(50, 30, 80, 25); // x, y, width, height
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

            System.out.println("username: " + username);
            System.out.println("password: " + password);

            if (username.equals("yashwant") && password.equals("$weetHome")) {
                messageLabel.setText("Login Successful!");
            } else {
                messageLabel.setText("Invalid Credentials");
            }
        });

        frame.setVisible(true);
    }
}

