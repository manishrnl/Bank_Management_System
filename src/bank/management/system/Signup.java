package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dateChooser;
    Random ran = new Random();
    long fourDigit = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(fourDigit);

    JLabel formNumber, pageNumber, presonaldetails, name, Fname, Gender, DOB, Email, Maritial, address, city, state, pincode;
    JTextField nameField, FnameField, emailField, addressField, cityField, stateField, pincodeField;
    ButtonGroup buttongroup;

    public Signup() {
        super("APPLICATION FORM");

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(25, 10, 100, 100);
        add(bank);

        formNumber = new JLabel("APPLICATION FORM NUMBER : " + first);
        formNumber.setBounds(260, 20, 600, 40);
        formNumber.setFont(new Font("Arial", Font.BOLD, 20));
        add(formNumber);

        pageNumber = new JLabel("PAGE 1");
        pageNumber.setBounds(420, 50, 80, 40);
        pageNumber.setFont(new Font("Arial", Font.BOLD, 20));
        add(pageNumber);

        presonaldetails = new JLabel("Personal details");
        presonaldetails.setBounds(380, 80, 180, 40);
        presonaldetails.setFont(new Font("Arial", Font.BOLD, 20));
        add(presonaldetails);

        name = new JLabel("Name :");
        name.setBounds(70, 130, 80, 30);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        add(name);

        nameField = new RoundedTextField(15);
        nameField.setBounds(270, 130, 380, 25);
        nameField.setFont(new Font("Arial", Font.BOLD, 18));
        add(nameField);

        Fname = new JLabel("Father's Name :");
        Fname.setBounds(70, 165, 150, 25);
        Fname.setFont(new Font("Arial", Font.BOLD, 18));
        add(Fname);

        FnameField = new RoundedTextField(15);
        FnameField.setBounds(270, 165, 380, 25);
        FnameField.setFont(new Font("Arial", Font.BOLD, 18));
        add(FnameField);

        Gender = new JLabel("Gender :");
        Gender.setBounds(70, 200, 150, 25);
        Gender.setFont(new Font("Arial", Font.BOLD, 18));
        add(Gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.BOLD, 18));
        male.setBounds(270, 200, 100, 25);
        male.setBackground(new Color(222, 255, 228));
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.BOLD, 18));
        female.setBounds(400, 200, 100, 25);
        female.setBackground(new Color(222, 255, 228));
        add(female);

        others = new JRadioButton("Others");
        others.setFont(new Font("Arial", Font.BOLD, 18));
        others.setBounds(510, 200, 100, 25);
        others.setBackground(new Color(222, 255, 228));
        add(others);

        buttongroup = new ButtonGroup();//Grouping buttons so as to select one button only among 2 at a time
        buttongroup.add(male);
        buttongroup.add(female);
        buttongroup.add(others);

        DOB = new JLabel("Date Of Birth :");
        DOB.setBounds(70, 235, 150, 25);
        DOB.setFont(new Font("Arial", Font.BOLD, 18));
        add(DOB);

        dateChooser = new JDateChooser();// dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(270, 235, 380, 25);
        add(dateChooser);

        Email = new JLabel("Email Address :");
        Email.setBounds(70, 270, 150, 25);
        Email.setFont(new Font("Arial", Font.BOLD, 18));
        add(Email);

        emailField = new RoundedTextField(15);
        emailField.setBounds(270, 270, 380, 25);
        emailField.setFont(new Font("Arial", Font.BOLD, 18));
        add(emailField);

        Maritial = new JLabel("Maritial Status :");
        Maritial.setBounds(70, 300, 150, 25);
        Maritial.setFont(new Font("Arial", Font.BOLD, 18));
        add(Maritial);

        married = new JRadioButton("Married");
        married.setFont(new Font("Arial", Font.BOLD, 18));
        married.setBounds(270, 300, 100, 25);
        married.setBackground(new Color(222, 255, 228));
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setFont(new Font("Arial", Font.BOLD, 18));
        unmarried.setBounds(450, 300, 120, 25);
        unmarried.setBackground(new Color(222, 255, 228));
        add(unmarried);

        ButtonGroup couple = new ButtonGroup();
        couple.add(married);
        couple.add(unmarried);

        address = new JLabel("Address :");
        address.setBounds(70, 330, 150, 25);
        address.setFont(new Font("Arial", Font.BOLD, 18));
        add(address);

        addressField = new RoundedTextField(15);
        addressField.setBounds(270, 330, 380, 25);
        addressField.setFont(new Font("Arial", Font.BOLD, 18));
        add(addressField);

        city = new JLabel("City :");
        city.setBounds(70, 360, 150, 25);
        city.setFont(new Font("Arial", Font.BOLD, 18));
        add(city);

        cityField = new RoundedTextField(15);
        cityField.setBounds(270, 360, 380, 25);
        cityField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cityField);

        state = new JLabel("State :");
        state.setBounds(70, 390, 150, 25);
        state.setFont(new Font("Arial", Font.BOLD, 18));
        add(state);

        stateField = new RoundedTextField(15);
        stateField.setBounds(270, 390, 380, 25);
        stateField.setFont(new Font("Arial", Font.BOLD, 18));
        add(stateField);

        pincode = new JLabel("Pin Code :");
        pincode.setBounds(70, 420, 150, 25);
        pincode.setFont(new Font("Arial", Font.BOLD, 18));
        add(pincode);

        pincodeField = new RoundedTextField(15);
        pincodeField.setBounds(270, 420, 380, 25);
        pincodeField.setFont(new Font("Arial", Font.BOLD, 18));
        add(pincodeField);

        JButton Next = new JButton("Next ");
        Next.setBounds(650, 650, 150, 35);
        Next.setFont(new Font("Arial", Font.BOLD, 18));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        this.add(Next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Next.doClick();  // Simulate a button click
                }
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events


    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String DOB1 = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender1 = "null";
        if (male.isSelected()) gender1 = "Male";
        else if (female.isSelected()) gender1 = "Female";
        else if (others.isSelected()) gender1 = "Others";

        String Maritial1 = "null";
        if (married.isSelected()) Maritial1 = "Married";
        else if (unmarried.isSelected()) Maritial1 = "Un-Married";

        try {
            // Validating required fields
            if (nameField.getText().equals("") || FnameField.getText().equals("") || emailField.getText().equals("") ||
                    addressField.getText().equals("") || cityField.getText().equals("") ||
                    pincodeField.getText().equals("") || stateField.getText().equals("") || DOB1.equals("")) {
                JOptionPane.showMessageDialog(null, "All Fields are Required");
                return;  // Stop further execution if fields are empty
            }

            // Validate email format
            if (!emailField.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                JOptionPane.showMessageDialog(null, "Invalid email format.");
                return;
            }

            // Validate pincode (only numeric and 6 digits)
            if (!pincodeField.getText().matches("\\d{6}")) {
                JOptionPane.showMessageDialog(null, "Pincode must be a 6-digit number.");
                return;
            }

            // Proceed with inserting the data into the database
            connect_wit_database connnection = new connect_wit_database();
            String q = "insert into signup values ('" + first + "', " +
                    "'" + nameField.getText() + "','" + FnameField.getText() + "'," +
                    "'" + DOB1 + "','" + gender1 + "','" + emailField.getText() + "'," +
                    "'" + Maritial1 + "','" + addressField.getText() + "','" + cityField.getText() + "'," +
                    "'" + pincodeField.getText() + "','" + stateField.getText() + "')";
            connnection.statement.executeUpdate(q);

            // Redirect to the next page
            new Signup2(first);
            setVisible(false);  // Closing current window
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + E.getMessage());
            E.printStackTrace();
        }
    }

}

//Class for rounded Border in JTextField
class RoundedTextField extends JTextField {
    private final int radius;

    public RoundedTextField(int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getForeground());
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}


