package Front.GUI;

import javax.swing.*;
import java.awt.*;

public class dependency {

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE); // Set panel background color
        JFrame frame = new JFrame();
        frame.setTitle("Job Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480,480);

        JLabel label = new JLabel("Job ID");
        label.setBounds(20, 30, 120, 40);
        label.setFont(new Font("Arial", Font.PLAIN, 20)); // Set label font size
        label.setForeground(Color.BLACK); // Set label foreground color
        panel.add(label);

        JTextField IDText = new JTextField(20);
        IDText.setBounds(150, 30, 80, 40);
        IDText.setFont(new Font("Arial", Font.PLAIN, 20)); // Set text field font size
        panel.add(IDText);

        // Add first dropdown
        JLabel label1 = new JLabel("Current Task");
        label1.setBounds(20, 100, 120, 40);
        label1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set label font size
        label1.setForeground(Color.BLACK); // Set label foreground color
        panel.add(label1);

        String[] options1 = {"Option A", "Option B", "Option C"};
        JComboBox<String> dropdown1 = new JComboBox<>(options1);
        dropdown1.setBounds(150, 100, 200, 40);
        dropdown1.setFont(new Font("Arial", Font.PLAIN, 20)); // Set dropdown font size
        panel.add(dropdown1);

        // Add second dropdown
        JLabel label2 = new JLabel("Dependent Task");
        label2.setBounds(20, 170, 120, 40);
        label2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set label font size
        label2.setForeground(Color.BLACK); // Set label foreground color
        panel.add(label2);

        String[] options2 = {"Option X", "Option Y", "Option Z"};
        JComboBox<String> dropdown2 = new JComboBox<>(options2);
        dropdown2.setBounds(150, 170, 200, 40);
        dropdown2.setFont(new Font("Arial", Font.PLAIN, 20)); // Set dropdown font size
        panel.add(dropdown2);

        JButton button = new JButton("Select");
        button.setBounds(200, 250, 100, 40);
        button.setBackground(new Color(135, 206, 235)); // Set button background color
        button.setForeground(Color.BLACK); // Set button foreground color
        button.setFont(new Font("Arial", Font.PLAIN, 20)); // Set button font size
        panel.add(button);

        panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
    }
}