import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TallerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen();
                new DashboardScreen();
                new InvoiceGenerationScreen();
                new DeliveryTimeManagementScreen();
                new OrderManagementScreen();
                new CustomerManagementScreen();


            }
        });
    }
}
