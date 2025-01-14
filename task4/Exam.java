import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {
    private JFrame examFrame;
    private Timer examTimer;
    private int timeRemaining;

    public Exam() {
        timeRemaining = 60; // 60 seconds timer for the exam
        examFrame = new JFrame("Online Exam");
        examFrame.setSize(400, 300);
        examFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Exam Question Example
        JLabel questionLabel = new JLabel("Question 1: What is 2 + 2?");
        panel.add(questionLabel);

        JRadioButton option1 = new JRadioButton("3");
        JRadioButton option2 = new JRadioButton("4");
        JRadioButton option3 = new JRadioButton("5");
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        panel.add(option1);
        panel.add(option2);
        panel.add(option3);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Timer Display
        JLabel timerLabel = new JLabel("Time remaining: " + timeRemaining + " seconds");
        panel.add(timerLabel);

        // Set up timer task to update the time left
        examTimer = new Timer();
        examTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    timerLabel.setText("Time remaining: " + timeRemaining + " seconds");
                } else {
                    JOptionPane.showMessageDialog(null, "Time is up! The exam has been submitted.");
                    submitExam();
                }
            }
        }, 1000, 1000); // Update every second

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitExam();
            }
        });

        examFrame.add(panel);
        examFrame.setVisible(true);
    }

    private void submitExam() {
        // Here we would collect the answers and submit them to the system
        JOptionPane.showMessageDialog(examFrame, "Your answers have been submitted.");
        examTimer.cancel();
        examFrame.dispose(); // Close the exam window
    }
}
