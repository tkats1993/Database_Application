import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.List;

public class NewJFrame extends JFrame {

    // GUI Components
    public JTextField jtxtID, jtxtTitle, jtxtAuthor, jtxtPrice, jtxtQty;
    public JButton jbtnAddNew, jbtnUpdate, jbtnDelete, jbtnReset, jbtnPrint, jbtnExit;
    public JTable jTable1;

    // DAO & State
    private BookDAO bookDAO = new BookDAO();
    private int selectedId = -1;

    public NewJFrame() {
        // Constructor does not call updateTable() yet, because components not built
    }

    // ===== CRUD =====
    public void updateTable() throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Book> books = bookDAO.getAllBooks();
        for (Book b : books) {
            model.addRow(new Object[]{b.getId(), b.getIdBook(), b.getTitle(), b.getAuthor(), b.getPrice(), b.getQty()});
        }
    }

    private void clearFields() {
        jtxtID.setText("");
        jtxtTitle.setText("");
        jtxtAuthor.setText("");
        jtxtPrice.setText("");
        jtxtQty.setText("");
        selectedId = -1;
    }

    public void jbtnAddNewActionPerformed(ActionEvent evt) {
        try {
            Book book = new Book(0, jtxtID.getText(), jtxtTitle.getText(), jtxtAuthor.getText(),
                    Double.parseDouble(jtxtPrice.getText()), Integer.parseInt(jtxtQty.getText()));
            bookDAO.addBook(book);
            updateTable();
            clearFields();
            JOptionPane.showMessageDialog(this, "Book added");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void jbtnUpdateActionPerformed(ActionEvent evt) {
        if (selectedId == -1) return;
        try {
            Book book = new Book(selectedId, jtxtID.getText(), jtxtTitle.getText(), jtxtAuthor.getText(),
                    Double.parseDouble(jtxtPrice.getText()), Integer.parseInt(jtxtQty.getText()));
            bookDAO.updateBook(book);
            updateTable();
            clearFields();
            JOptionPane.showMessageDialog(this, "Book updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void jbtnDeleteActionPerformed(ActionEvent evt) {
        if (selectedId == -1) return;
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this book?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                bookDAO.deleteBook(selectedId);
                updateTable();
                clearFields();
                JOptionPane.showMessageDialog(this, "Book deleted");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void jbtnResetActionPerformed(ActionEvent evt) {
        clearFields();
    }

    public void jbtnPrintActionPerformed(ActionEvent evt) {
        try {
            jTable1.print(JTable.PrintMode.NORMAL,
                    new MessageFormat("Printing in progress"),
                    new MessageFormat("Page {0}"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Printer error");
        }
    }

    public void jbtnExitActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(this, "Exit the app?", "Confirm", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        selectedId = Integer.parseInt(model.getValueAt(row, 0).toString());
        jtxtID.setText(model.getValueAt(row, 1).toString());
        jtxtTitle.setText(model.getValueAt(row, 2).toString());
        jtxtAuthor.setText(model.getValueAt(row, 3).toString());
        jtxtPrice.setText(model.getValueAt(row, 4).toString());
        jtxtQty.setText(model.getValueAt(row, 5).toString());
    }

    // ===== main() =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NewJFrame frame = new NewJFrame();

            // Instantiate components
            frame.jtxtID = new JTextField(20);
            frame.jtxtTitle = new JTextField(20);
            frame.jtxtAuthor = new JTextField(20);
            frame.jtxtPrice = new JTextField(20);
            frame.jtxtQty = new JTextField(20);

            frame.jbtnAddNew = new JButton("Add New");
            frame.jbtnUpdate = new JButton("Update");
            frame.jbtnDelete = new JButton("Delete");
            frame.jbtnReset = new JButton("Reset");
            frame.jbtnPrint = new JButton("Print");
            frame.jbtnExit = new JButton("Exit");

            frame.jTable1 = new JTable(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"ID", "ID Book", "Title", "Author", "Price", "Quantity"}
            ));
            frame.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    frame.jTable1MouseClicked(evt);
                }
            });

            // Actions
            frame.jbtnAddNew.addActionListener(frame::jbtnAddNewActionPerformed);
            frame.jbtnUpdate.addActionListener(frame::jbtnUpdateActionPerformed);
            frame.jbtnDelete.addActionListener(frame::jbtnDeleteActionPerformed);
            frame.jbtnReset.addActionListener(frame::jbtnResetActionPerformed);
            frame.jbtnPrint.addActionListener(frame::jbtnPrintActionPerformed);
            frame.jbtnExit.addActionListener(frame::jbtnExitActionPerformed);

            // Layout with GUIComponents
            JPanel formPanel = GUIComponents.createFormPanel(
                    frame.jtxtID, frame.jtxtTitle, frame.jtxtAuthor, frame.jtxtPrice, frame.jtxtQty);
            JPanel buttonPanel = GUIComponents.createButtonPanel(
                    frame.jbtnAddNew, frame.jbtnUpdate, frame.jbtnDelete, frame.jbtnReset, frame.jbtnPrint, frame.jbtnExit);
            JScrollPane tableScroll = GUIComponents.createTableScroll(frame.jTable1);

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
            centerPanel.add(formPanel);
            centerPanel.add(buttonPanel);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(centerPanel);
            mainPanel.add(tableScroll);

            frame.setContentPane(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            try {
                frame.updateTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error loading data: " + e.getMessage());
            }
        });
    }
}
