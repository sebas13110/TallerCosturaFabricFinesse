import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class LoginScreen extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;

        public LoginScreen() {
            setTitle("Inicio de Sesión");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JLabel usernameLabel = new JLabel("Nombre de usuario:");
            JLabel passwordLabel = new JLabel("Contraseña:");
            usernameField = new JTextField(20);
            passwordField = new JPasswordField(20);

            JButton loginButton = new JButton("Iniciar sesión");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Agregar lógica de autenticación aquí.
                }
            });

            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(new JLabel()); // Espacio en blanco
            panel.add(loginButton);

            add(panel);
            setVisible(true);
        }
    }
