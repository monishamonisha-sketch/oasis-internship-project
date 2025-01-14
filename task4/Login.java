import javax.swing.*;
import java.awt.event.*;

public class Login {
    @SuppressWarnings("unused")
    private static User user;

    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Hardcoded user for testing purposes
                if (username.equals("user1") && password.equals("pass1")) {
                    user = new User(username, password, "John Doe", "johndoe@example.com");
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    loginFrame.dispose();
                    new Exam();  // Proceed to Exam after login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials!");
                }
            }
        });

        loginFrame.setVisible(true);
    }
}
