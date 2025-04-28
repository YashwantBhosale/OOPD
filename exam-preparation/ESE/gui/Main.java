import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Login Window");
		frame.setSize(500, 500);
		frame.setLayout(null);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 150, 200, 40);
		frame.add(usernameLabel);

		JTextField usernameInput = new JTextField();
		usernameInput.setBounds(50, 180, 200, 40);
		frame.add(usernameInput);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 230, 200, 40);
		frame.add(passwordLabel);

		JPasswordField passwordInput = new JPasswordField();
		passwordInput.setBounds(50, 260, 200, 40);
		frame.add(passwordInput);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(50, 310, 100, 30);
		frame.add(loginButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		loginButton.addActionListener(e -> {
			JDialog successDialog = new JDialog(frame, "Login SuccessFul!", true); // true -> dialog blocks parent
			successDialog.setSize(250, 150);
			successDialog.setLayout(null);

			JLabel message = new JLabel("Welcome, User was successfully logged in!");
            message.setBounds(30, 30, 200, 30);
            successDialog.add(message);

			successDialog.setLocationRelativeTo(frame);
			successDialog.setVisible(true);
		});
	}
}
