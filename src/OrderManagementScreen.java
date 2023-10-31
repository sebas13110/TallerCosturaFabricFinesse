import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class OrderManagementScreen extends JFrame {
    private DefaultTableModel tableModel;
    private JTable orderTable;
    private JButton createOrderButton;
    private JButton updateOrderButton;
    private JTextField orderDetailsField;
    private JTextField workRequestedField;
    private JTextField garmentTypeField;
    private JTextField conditionsField;
    private JTextField customerPhoneField;
    private JTextField seamstressAssignedField;
    private JTextField receptionDateField;
    private JTextField deliveryDateField;
    private JTextField costField;

    public OrderManagementScreen() {
        setTitle("Gestión de Pedidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un modelo de tabla para los pedidos
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Detalles del Pedido");
        tableModel.addColumn("Trabajo Solicitado");
        tableModel.addColumn("Tipo de Prenda");
        tableModel.addColumn("Condiciones");
        tableModel.addColumn("Teléfono del Cliente");
        tableModel.addColumn("Costurero Asignado");
        tableModel.addColumn("Fecha de Recepción");
        tableModel.addColumn("Fecha de Entrega");
        tableModel.addColumn("Costo");

        // Crear la tabla de pedidos con el modelo
        orderTable = new JTable(tableModel);

        // Crear un panel para los botones de crear pedido y actualizar pedido
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        createOrderButton = new JButton("Crear Nuevo Pedido");
        createOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewOrder();
            }
        });

        updateOrderButton = new JButton("Actualizar Pedido");
        updateOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateOrder();
            }
        });

        buttonPanel.add(createOrderButton);
        buttonPanel.add(updateOrderButton);

        // Crear un panel para la tabla
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);

        // Agregar campos para detalles adicionales del pedido
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(12, 2));

        orderDetailsField = new JTextField(20);
        workRequestedField = new JTextField(20);
        garmentTypeField = new JTextField(20);
        conditionsField = new JTextField(20);
        customerPhoneField = new JTextField(20);
        seamstressAssignedField = new JTextField(20);
        receptionDateField = new JTextField(20);
        deliveryDateField = new JTextField(20);
        costField = new JTextField(20);

        inputPanel.add(new JLabel("Detalles del Pedido:"));
        inputPanel.add(orderDetailsField);
        inputPanel.add(new JLabel("Trabajo Solicitado:"));
        inputPanel.add(workRequestedField);
        inputPanel.add(new JLabel("Tipo de Prenda:"));
        inputPanel.add(garmentTypeField);
        inputPanel.add(new JLabel("Condiciones:"));
        inputPanel.add(conditionsField);
        inputPanel.add(new JLabel("Teléfono del Cliente:"));
        inputPanel.add(customerPhoneField);
        inputPanel.add(new JLabel("Costurero Asignado:"));
        inputPanel.add(seamstressAssignedField);
        inputPanel.add(new JLabel("Fecha de Recepción (dd/MM/yyyy HH:mm):"));
        inputPanel.add(receptionDateField);
        inputPanel.add(new JLabel("Fecha de Entrega (dd/MM/yyyy HH:mm):"));
        inputPanel.add(deliveryDateField);
        inputPanel.add(new JLabel("Costo:"));
        inputPanel.add(costField);

        // Agregar todo al JFrame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    // Método para crear un nuevo pedido y agregarlo a la tabla
    private void createNewOrder() {
        String orderDetails = orderDetailsField.getText();
        String workRequested = workRequestedField.getText();
        String garmentType = garmentTypeField.getText();
        String conditions = conditionsField.getText();
        String customerPhone = customerPhoneField.getText();
        String seamstressAssigned = seamstressAssignedField.getText();
        String receptionDate = receptionDateField.getText();
        String deliveryDate = deliveryDateField.getText();
        String cost = costField.getText();

        if (!orderDetails.isEmpty() && !workRequested.isEmpty() && !garmentType.isEmpty()
                && !conditions.isEmpty() && !customerPhone.isEmpty() && !seamstressAssigned.isEmpty()
                && !receptionDate.isEmpty() && !deliveryDate.isEmpty() && !cost.isEmpty()) {
            Vector<String> newRow = new Vector<>();
            newRow.add(String.valueOf(tableModel.getRowCount() + 1)); // ID Pedido
            newRow.add("Cliente"); // Nombre del cliente (puedes agregar un campo para ingresar el cliente)
            newRow.add("Pendiente"); // Estado inicial
            newRow.add(orderDetails); // Detalles del pedido
            newRow.add(workRequested); // Trabajo solicitado
            newRow.add(garmentType); // Tipo de prenda
            newRow.add(conditions); // Condiciones
            newRow.add(customerPhone); // Teléfono del cliente
            newRow.add(seamstressAssigned); // Costurero asignado
            newRow.add(receptionDate); // Fecha de recepción
            newRow.add(deliveryDate); // Fecha de entrega
            newRow.add(cost); // Costo
            tableModel.addRow(newRow);

            // Limpiar los campos después de agregar el pedido
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar el pedido seleccionado en la tabla
    private void updateOrder() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            String updatedDetails = orderDetailsField.getText();
            String updatedWorkRequested = workRequestedField.getText();
            String updatedGarmentType = garmentTypeField.getText();
            String updatedConditions = conditionsField.getText();
            String updatedCustomerPhone = customerPhoneField.getText();
            String updatedSeamstressAssigned = seamstressAssignedField.getText();
            String updatedReceptionDate = receptionDateField.getText();
            String updatedDeliveryDate = deliveryDateField.getText();
            String updatedCost = costField.getText();

            if (!updatedDetails.isEmpty()) {
                tableModel.setValueAt(updatedDetails, selectedRow, 3); // Actualiza los detalles del pedido
                tableModel.setValueAt(updatedWorkRequested, selectedRow, 4); // Actualiza el trabajo solicitado
                tableModel.setValueAt(updatedGarmentType, selectedRow, 5); // Actualiza el tipo de prenda
                tableModel.setValueAt(updatedConditions, selectedRow, 6); // Actualiza las condiciones
                tableModel.setValueAt(updatedCustomerPhone, selectedRow, 7); // Actualiza el teléfono del cliente
                tableModel.setValueAt(updatedSeamstressAssigned, selectedRow, 8); // Actualiza el costurero asignado
                tableModel.setValueAt(updatedReceptionDate, selectedRow, 9); // Actualiza la fecha de recepción
                tableModel.setValueAt(updatedDeliveryDate, selectedRow, 10); // Actualiza la fecha de entrega
                tableModel.setValueAt(updatedCost, selectedRow, 11); // Actualiza el costo

                // Limpia los campos después de la actualización
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese detalles actualizados del pedido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        orderDetailsField.setText("");
        workRequestedField.setText("");
        garmentTypeField.setText("");
        conditionsField.setText("");
        customerPhoneField.setText("");
        seamstressAssignedField.setText("");
        receptionDateField.setText("");
        deliveryDateField.setText("");
        costField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OrderManagementScreen();
            }
        });
    }
}