import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class InvoiceGenerationScreen extends JFrame {
    private DefaultTableModel tableModel;
    private JTable orderTable;
    private JButton generateInvoiceButton;
    private JTextField rfcField;
    private JTextField addressField;
    private JTextField fiscalStatusField;
    private JComboBox<String> paymentMethodComboBox;

    public InvoiceGenerationScreen() {
        setTitle("Generación de Facturas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un modelo de tabla para los pedidos
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Total");

        // Crear la tabla de pedidos con el modelo
        orderTable = new JTable(tableModel);

        // Crear un panel para los campos de entrada y el botón de generación de factura
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JLabel rfcLabel = new JLabel("RFC:");
        JLabel addressLabel = new JLabel("Dirección:");
        JLabel fiscalStatusLabel = new JLabel("Estatus Fiscal:");
        JLabel paymentMethodLabel = new JLabel("Forma de Pago:");

        rfcField = new JTextField(20);
        addressField = new JTextField(20);
        fiscalStatusField = new JTextField(20);

        String[] paymentMethods = {"Tarjeta de Crédito", "Transferencia Bancaria", "Efectivo"};
        paymentMethodComboBox = new JComboBox<>(paymentMethods);

        inputPanel.add(rfcLabel);
        inputPanel.add(rfcField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(fiscalStatusLabel);
        inputPanel.add(fiscalStatusField);
        inputPanel.add(paymentMethodLabel);
        inputPanel.add(paymentMethodComboBox);

        generateInvoiceButton = new JButton("Generar Factura");
        generateInvoiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateInvoice();
            }
        });

        // Crear un panel para la tabla y el panel de entrada
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(generateInvoiceButton, BorderLayout.SOUTH);

        // Agregar todo al JFrame
        add(mainPanel);
        setVisible(true);
    }

    // Método para generar la factura
    private void generateInvoice() {
        int[] selectedRows = orderTable.getSelectedRows();
        if (selectedRows.length > 0) {
            String rfc = rfcField.getText();
            String address = addressField.getText();
            String fiscalStatus = fiscalStatusField.getText();
            String paymentMethod = paymentMethodComboBox.getSelectedItem().toString();

            if (!rfc.isEmpty() && !address.isEmpty() && !fiscalStatus.isEmpty()) {
                // Implementa la lógica real de generación de facturas, como la creación de un archivo PDF.
                // Asegúrate de incluir todos los detalles necesarios en la factura.

                // Luego, puedes mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Factura generada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un pedido para generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InvoiceGenerationScreen();
            }
        });
    }
}
