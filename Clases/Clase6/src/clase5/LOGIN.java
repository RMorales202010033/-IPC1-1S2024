package clase5;

//Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author jrodo
 */
public class LOGIN extends JFrame implements ActionListener, FocusListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JCheckBox cb1;

    public LOGIN() {
        initComponents();
    }

    private void initComponents() {
        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20)); // Establece el tipo de letra y el tamaño
        titleLabel.setBounds(200, 10, 100, 30); //pos x, pos y, ancho, alto
        this.add(titleLabel);

        // Carga la imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("./Images/login.png"));
        // Ajusta el tamaño de la imagen (puedes cambiar los valores según tus necesidades)
        Image imageDimension = imageIcon.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
        // Crea un nuevo ImageIcon con la imagen ajustada
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
        // Crea un JLabel para mostrar la imagen
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(190, 30, 120, 110); // (x, y, width, height) aqui el ancho y la altura deben ser las mismas que cuando redimensionamos
        this.add(imageLabel);

        // Etiqueta de texto para el nombre de usuario
        JLabel usernameLabel = new JLabel("Codigo:");
        usernameLabel.setFont(new Font("Kristen ITC", Font.BOLD, 12)); // Establece el tipo de letra y el tamaño
        usernameLabel.setBounds(70, 140, 80, 25);
        this.add(usernameLabel);

        // Campo de texto para el nombre de usuario
        usernameField = new JTextField("Code");
        usernameField.setBounds(130, 140, 260, 25);
        usernameField.addFocusListener(this);
        this.add(usernameField);

        // Etiqueta para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Kristen ITC", Font.BOLD, 12)); // Establece el tipo de letra y el tamaño
        passwordLabel.setBounds(43, 180, 80, 25);
        this.add(passwordLabel);

        //Campo de texto para la contraseña
        passwordField = new JPasswordField("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(130, 180, 260, 25);
        passwordField.addFocusListener(this);
        this.add(passwordField);

        // Botón de inicio de sesión
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(275, 260, 150, 25); //Ajuste de posición
        loginButton.setForeground(Color.WHITE); // Ajuste de color de letra
        loginButton.setBackground(new Color(75, 193, 31)); // Ajuste de color de boton, con color en RGB
        loginButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(loginButton);

        // Botón de Registro
        registerButton = new JButton("Registrarse");
        registerButton.setBounds(75, 260, 150, 25); //Ajuste de posición
        registerButton.setBackground(new Color(214, 225, 50)); // Ajuste de color de boton, con color en RGB
        registerButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(registerButton);

        //SEE PASSWORD
        cb1 = new JCheckBox("Ver Password");
        cb1.setFont(new Font("Kristen ITC", Font.BOLD, 12)); // Establece el tipo de letra y el tamaño
        cb1.setBounds(130, 220, 150, 25);
        cb1.setVisible(true);
        cb1.addActionListener(this);
        this.add(cb1);

        //Creación de la ventana iniciar sesión
        this.setTitle("Login");  // Título de la ventana
        this.setLocationRelativeTo(null);
//        this.setBounds(0, 0, 500, 350); // Posición y tamaño de la ventana (x, y, width, height)
        this.setSize(500, 350);
        setLocationRelativeTo(null);
        /*
        x: La posición horizontal de la esquina superior izquierda de la ventana en píxeles desde el borde izquierdo de la pantalla.
        y: La posición vertical de la esquina superior izquierda de la ventana en píxeles desde la parte superior de la pantalla.
        width: El ancho de la ventana en píxeles.
        height: La altura de la ventana en píxeles.
         */
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Ver password
        if (ae.getSource() == cb1) {
            if (cb1.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('\u25CF');
            }
        } else if (ae.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String pwd = new String(password);

            System.out.println("Usuario: " + username);
            System.out.println("Password: " + pwd);
            
            if (username.equals("admin") && pwd.equals("admin")) {
                ESTUDIANTE student = new ESTUDIANTE();
                System.out.println("Welcome admin");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User and/or password incorrect.", "Error con el LOGIN", 0);
            }
        } else if (ae.getSource() == registerButton) {
            System.out.println("Abrir la ventana para el registro");
        }
        System.out.println("================================================");
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == usernameField) {
            usernameField.setText("");
        } else if (fe.getSource() == passwordField) {
            if (cb1.isSelected()) {
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('\u25CF');
            }
            passwordField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
