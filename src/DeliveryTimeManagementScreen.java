import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class DeliveryTimeManagementScreen extends JFrame {
    private DefaultTableModel tableModel;
    private JTable orderTable;

    public DeliveryTimeManagementScreen() {
        setTitle("Gestión de Tiempos de Entrega");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un modelo de tabla para los tiempos de entrega
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Fecha de Entrega");
        tableModel.addColumn("Trabajo Solicitado"); // Nuevo campo para el trabajo solicitado

        // Crear la tabla de tiempos de entrega con el modelo
        orderTable = new JTable(tableModel);

        // Agregar ejemplos de tiempos de entrega (puedes cargar estos datos desde tu base de datos)
        addSampleDeliveryTimes();

        // Crear un panel para la tabla
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);

        // Agregar todo al JFrame
        add(mainPanel);
        setVisible(true);
    }

    // Método para agregar ejemplos de tiempos de entrega
    private void addSampleDeliveryTimes() {
        // Puedes cargar tiempos de entrega desde tu base de datos o sistema
        // Aquí, agregamos algunos ejemplos ficticios.
        Vector<String> order1 = new Vector<>();
        order1.add("1");
        order1.add("Cliente 1");
        order1.add("2023-10-20");
        order1.add("Ajuste de bastilla, cambio de cierre, bordado en encaje");

        Vector<String> order2 = new Vector<>();
        order2.add("2");
        order2.add("Cliente 2");
        order2.add("2023-10-25");
        order2.add("Ajuste de bastilla, cambio de botones");

        tableModel.addRow(order1);
        tableModel.addRow(order2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DeliveryTimeManagementScreen();
            }
        });
    }
}
