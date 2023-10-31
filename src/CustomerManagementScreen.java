import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CustomerManagementScreen extends JFrame {
    private DefaultTableModel tableModel;
    private JTable customerTable;
    private JTextField nameField;
    private JTextField phoneField;
    private JButton addButton;

    public CustomerManagementScreen() {
        setTitle("Gestión de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un modelo de tabla para los clientes
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Número de Teléfono");

        // Crear la tabla de clientes con el modelo
        customerTable = new JTable(tableModel);

        // Crear un panel para los campos de entrada y el botón de agregar
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nombre:");
        JLabel phoneLabel = new JLabel("Número de Teléfono:");
        nameField = new JTextField(20);
        phoneField = new JTextField(20);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        addButton = new JButton("Agregar Cliente");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        inputPanel.add(addButton);

        // Crear un panel para la tabla y el panel de entrada
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(customerTable), BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Agregar todo al JFrame
        add(mainPanel);
        setVisible(true);
    }

    // Método para agregar un cliente a la tabla
    private void addCustomer() {
        String name = nameField.getText();
        String phone = phoneField.getText();

        if (!name.isEmpty() && !phone.isEmpty()) {
            Vector<String> row = new Vector<>();
            row.add(String.valueOf(tableModel.getRowCount() + 1)); // ID
            row.add(name);
            row.add(phone);
            tableModel.addRow(row);

            // Limpiar los campos después de agregar el cliente
            nameField.setText("");
            phoneField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre y un número de teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerManagementScreen();
            }
        });
    }
}
