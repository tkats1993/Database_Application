import javax.swing.*;
import java.awt.Font;


public class GUIComponents {
    public static JPanel createFormPanel(JTextField idField, JTextField titleField, JTextField authorField, JTextField priceField, JTextField qtyField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ID Book"));
        panel.add(idField);
        panel.add(new JLabel("Title"));
        panel.add(titleField);
        panel.add(new JLabel("Author"));
        panel.add(authorField);
        panel.add(new JLabel("Price"));
        panel.add(priceField);
        panel.add(new JLabel("Quantity"));
        panel.add(qtyField);

        return panel;
    }

    private static void styleButton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 15));
        btn.setBackground(new java.awt.Color(58, 130, 255)); // Μοντέρνο μπλε
        btn.setForeground(java.awt.Color.WHITE);             // Λευκή γραμματοσειρά
        btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 90, 200), 2, true));
        btn.setPreferredSize(new java.awt.Dimension(150, 40));
    
        // Προαιρετικό hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new java.awt.Color(30, 100, 230));
            }
    
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new java.awt.Color(58, 130, 255));
            }
        });
    }

    public static JPanel createButtonPanel(JButton... buttons) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (JButton btn : buttons) {
            styleButton(btn);  // 👈 Στυλιζάρει κάθε κουμπί
            panel.add(Box.createVerticalStrut(10)); // Απόσταση μεταξύ τους
            panel.add(btn);
        }
        return panel;
    }

    public static JScrollPane createTableScroll(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
}
