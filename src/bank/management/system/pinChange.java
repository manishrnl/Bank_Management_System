package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;

public class pinChange extends JFrame implements ActionListener {
    static String pin;
    JButton backButton, changeButton;
    JPasswordField new_pin, reenter_pin;

    pinChange(String pin) {
        pinChange.pin = pin;

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("Change Your PIN");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(490, 170, 500, 35);
        bank.add(label1);

        JLabel pin1 = new JLabel("New PIN :");
        pin1.setFont(new Font("Arial", Font.BOLD, 15));
        pin1.setForeground(Color.WHITE);
        pin1.setBounds(400, 210, 150, 35);
        bank.add(pin1);

        // Use the class-level new_pin variable
        new_pin = new JPasswordField(20);
        new_pin.setBounds(550, 210, 250, 25);
        bank.add(new_pin);

        JLabel pin2 = new JLabel("Re-Enter new PIN");
        pin2.setFont(new Font("Arial", Font.BOLD, 15));
        pin2.setForeground(Color.WHITE);
        pin2.setBounds(400, 240, 150, 35);
        bank.add(pin2);

        // Use the class-level reenter_pin variable
        reenter_pin = new JPasswordField(20);
        reenter_pin.setBounds(550, 240, 250, 25);
        bank.add(reenter_pin);

        changeButton = new JButton("CHANGE");
        changeButton.setFont(new Font("Arial", Font.BOLD, 13));
        changeButton.setBackground(new Color(112, 222, 197));
        changeButton.setForeground(Color.WHITE);
        changeButton.setBounds(653, 350, 165, 35);
        changeButton.addActionListener(this);
        bank.add(changeButton);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setBackground(new Color(112, 222, 197));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(653, 395, 165, 35);
        backButton.addActionListener(this);
        this.add(backButton);
        bank.add(backButton);

        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Check if Enter key is pressed
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    backButton.doClick();  // Simulate a button click
                }
            }
        });
    }

    public static void main(String[] args) {
        new pinChange(""); // Launch the Deposit window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pin1 = new String(new_pin.getPassword());
        String pin2 = new String(reenter_pin.getPassword());

        if (e.getSource().equals(backButton)) {
            new Main_class(pin);
            setVisible(false);
        } else if (e.getSource().equals(changeButton)) {
            if (pin1.equals(pin2) && pin1.length() == 4) {
                try {
                    connect_wit_database con = new connect_wit_database();
                    // Update the PIN in the 'balance' table
                    String updateBalancePin = "UPDATE balance SET Pin = ? WHERE Pin = ?";
                    PreparedStatement updateBalanceStmt = con.connections.prepareStatement(updateBalancePin);
                    updateBalanceStmt.setString(1, pin1); // New PIN
                    updateBalanceStmt.setString(2, pin); // Current PIN
                    int balanceUpdated = updateBalanceStmt.executeUpdate();

                    // Update the PIN in the 'login' table
                    String updateLoginPin = "UPDATE login SET Pin = ? WHERE Pin = ?";
                    PreparedStatement updateLoginStmt = con.connections.prepareStatement(updateLoginPin);
                    updateLoginStmt.setString(1, pin1); // New PIN
                    updateLoginStmt.setString(2, pin); // Current PIN
                    int loginUpdated = updateLoginStmt.executeUpdate();

                    // Update the PIN in the 'signup3' table
                    String updateSignup3Pin = "UPDATE signup3 SET PIN = ? WHERE PIN = ?";
                    PreparedStatement updateSignup3Stmt = con.connections.prepareStatement(updateSignup3Pin);
                    updateSignup3Stmt.setString(1, pin1); // New PIN
                    updateSignup3Stmt.setString(2, pin); // Current PIN
                    int Signup3Updated = updateSignup3Stmt.executeUpdate();

                    if (balanceUpdated > 0 || loginUpdated > 0 || Signup3Updated > 0) {
                        JOptionPane.showMessageDialog(null, "Since you have changed the pin so you need to login again to access for security purposes");

                    } else {
                        JOptionPane.showMessageDialog(null, "No records found with the current PIN. Update failed.");
                    }
                    pin = pin1; // Update the current PIN to the new PIN
                    setVisible(false);
                    dispose();
                    new Login();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while updating the PIN.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password must be 4 digit long");
                new_pin.setText("");
                reenter_pin.setText("");
            }
        }

    }
}
