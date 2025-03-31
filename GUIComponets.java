import javax.swing.*;

public class GUIComponets {
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

    public static JPanel createButtonPanel(JButton addBtn, JButton updateBtn, JButton deleteBtn, JButton resetBtn, JButton printBtn, JButton exitBtn) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        panel.add(resetBtn);
        panel.add(printBtn);
        panel.add(exitBtn);

        return panel;
    }

    public static JScrollPane createTableScroll(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
}
