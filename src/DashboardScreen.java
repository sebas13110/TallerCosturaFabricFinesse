import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class DashboardScreen extends JFrame {
    private DefaultTableModel tableModel;
    private JTable orderTable;

    public DashboardScreen() {
        setTitle("Panel de Control");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un modelo de tabla para resúmenes de pedidos
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Detalles del Pedido");
        tableModel.addColumn("Trabajo Solicitado");

        // Crear la tabla de resúmenes de pedidos con el modelo
        orderTable = new JTable(tableModel);

        // Agregar ejemplos de resúmenes de pedidos (puedes cargar estos datos desde tu base de datos)
        addSampleOrders();

        // Crear un panel para la tabla
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);

        // Agregar todo al JFrame
        add(mainPanel);
        setVisible(true);
    }

    // Método para agregar ejemplos de resúmenes de pedidos
    private void addSampleOrders() {
        // Aquí puedes cargar resúmenes de pedidos desde tu base de datos o sistema
        // Por ahora, agregaremos algunos ejemplos ficticios.
        Vector<String> order1 = new Vector<>();
        order1.add("1");
        order1.add("Cliente 1");
        order1.add("En Proceso");
        order1.add("Vestido de novia");
        order1.add("Ajuste de bastilla, cambio de cierre, bordado en encaje");

        Vector<String> order2 = new Vector<>();
        order2.add("2");
        order2.add("Cliente 2");
        order2.add("Pendiente");
        order2.add("Traje de gala");
        order2.add("Ajuste de bastilla, cambio de botones");

        tableModel.addRow(order1);
        tableModel.addRow(order2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DashboardScreen();
            }
        });
    }
}
