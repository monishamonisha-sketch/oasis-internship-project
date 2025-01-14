import javax.swing.*;
import java.awt.event.*;

public class Profile {
    public static void main(String[] args) {
        User currentUser = new User("user1", "pass1", "John Doe", "johndoe@example.com");

        JFrame profileFrame = new JFrame("Profile");
        profileFrame.setSize(300, 250);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        profileFrame.add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(currentUser.getFullName());
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(currentUser.getEmail());
        emailText.setBounds(100, 50, 165, 25);
        panel.add(emailText);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(10, 80, 80, 25);
        panel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.setFullName(nameText.getText());
                currentUser.setEmail(emailText.getText());
                JOptionPane.showMessageDialog(null, "Profile Updated!");
            }
        });

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(10, 110, 200, 25);
        panel.add(changePasswordButton);

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = JOptionPane.showInputDialog("Enter new password:");
                currentUser.setPassword(newPassword);
                JOptionPane.showMessageDialog(null, "Password Changed!");
            }
        });

        profileFrame.setVisible(true);
    }
}
