import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJFrame_Example extends JFrame {
    
    // Δημιουργία στοιχείων του GUI
    private JButton myButton;
    private JTextField myTextField;
    private JLabel myLabel;
    
    public NewJFrame_Example() {
        // Αρχικοποίηση στοιχείων και ρυθμίσεις του παραθύρου
        initComponents();
    }

    private void initComponents() {
        // Ρυθμίσεις για το παράθυρο
        setTitle("My GUI Application");
        setSize(400, 300); // Μέγεθος του παραθύρου
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Κεντράρισμα παραθύρου στην οθόνη
        
        // Δημιουργία του κουμπιού
        myButton = new JButton("Click Me!");
        myButton.setBounds(150, 100, 100, 30); // Θέση και μέγεθος
        
        // Δημιουργία του πεδίου κειμένου
        myTextField = new JTextField();
        myTextField.setBounds(150, 50, 100, 30);
        
        // Δημιουργία της ετικέτας
        myLabel = new JLabel("Enter text:");
        myLabel.setBounds(50, 50, 100, 30);
        
        // Προσθήκη των στοιχείων στο παράθυρο
        setLayout(null); // Χωρίς layout manager
        add(myButton);
        add(myTextField);
        add(myLabel);
        
        // Προσθήκη λειτουργικότητας στο κουμπί
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = myTextField.getText();
                JOptionPane.showMessageDialog(null, "You entered: " + inputText);
            }
        });
    }

    public static void main(String args[]) {
        // Εκτέλεση του GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true); // Εμφάνιση του παραθύρου
            }
        });
    }
}

