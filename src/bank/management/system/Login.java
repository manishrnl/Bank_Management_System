package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel title_label, Card_no_Label, pin;
    JTextField card_field;
    JPasswordField password;
    JButton signin, signup, clear;

    Login() {
        super("Bank Management System ");//Title Bar

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(350, 10, 100, 100);
        add(bank);

        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image card2 = card1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon card3 = new ImageIcon(card2);
        JLabel card = new JLabel(card3);
        card.setBounds(630, 350, 100, 100);
        add(card);

        title_label = new JLabel("WELCOME TO ATM");
        title_label.setForeground(Color.white);
        title_label.setFont(new Font("AvantGrade", Font.BOLD, 38));
        title_label.setBounds(230, 125, 450, 40);
        add(title_label);

        Card_no_Label = new JLabel("Enter Card No.:");
        Card_no_Label.setForeground(Color.white);
        Card_no_Label.setFont(new Font("AvantGrade", Font.BOLD, 20));
        Card_no_Label.setBounds(150, 250, 450, 40);
        add(Card_no_Label);

        card_field = new JTextField("1403200067738804");
        card_field.setBounds(350, 250, 300, 40);
        card_field.setFont(new Font("Arial", Font.BOLD, 20));
        add(card_field);

        pin = new JLabel("Enter PIN:");
        pin.setForeground(Color.white);
        pin.setFont(new Font("AvantGrade", Font.BOLD, 20));
        pin.setBounds(203, 300, 450, 40);
        add(pin);

        password = new JPasswordField("2722");
        password.setBounds(350, 300, 300, 40);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(password);

        signin = new JButton("SIGN IN");
        signin.setBounds(120, 370, 140, 40);
        signin.setFont(new Font("Arial", Font.BOLD, 15));
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        this.add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(320, 370, 140, 40);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        this.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(500, 370, 140, 40);
        signup.setFont(new Font("Arial", Font.BOLD, 15));
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        ImageIcon backbg1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image backbg2 = backbg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon backbg3 = new ImageIcon(backbg2);
        JLabel backbg = new JLabel(backbg3);
        backbg.setBounds(0, 0, 850, 480);

        add(backbg);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);

        // Add KeyListener to allow Enter key press
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    signin.doClick();  // Simulate a button click
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    clear.doClick();  // Simulate a button click
                }
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events

    }


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == signin) {
                // Retrieve card number and PIN only when "Sign In" is clicked
                String cardNumber = card_field.getText().trim();
                String pinNumber = String.valueOf(password.getPassword()).trim();

                // Validate Card Number and PIN
                if (cardNumber.length() != 16) {
                    JOptionPane.showMessageDialog(null, "Card number must be 16 digits long.");
                    return;
                }

                if (!cardNumber.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Card number must contain only digits.");
                    return;
                }

                if (pinNumber.length() != 4) {
                    JOptionPane.showMessageDialog(null, "PIN must be 4 digits long.");
                    return;
                }

                if (!pinNumber.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "PIN must contain only digits.");
                    return;
                }

                // Database check
                connect_wit_database con = new connect_wit_database();
                String data5 = "SELECT * FROM login WHERE Card_Number= '" + cardNumber + "' and PIN='" + pinNumber + "'";
                ResultSet resultSet = con.statement.executeQuery(data5);

                if (resultSet.next()) {

                    setVisible(false);
                    new Main_class(pinNumber);

                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Credential! Try again....");
                    card_field.setText("");
                    password.setText("");
                }
            } else if (e.getSource() == signup) {
                new Signup(); // Open the signup page
            } else if (e.getSource() == clear) {
                card_field.setText("");  // Clear card field
                password.setText("");    // Clear PIN field
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

