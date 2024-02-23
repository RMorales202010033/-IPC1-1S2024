package clase5;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jrodo
 */
public class CREATE_STUDENT extends JFrame implements ActionListener {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JComboBox<String> genderComboBox;

    private JButton registerButton;

    public CREATE_STUDENT() {
        initComponents();
    }

    private void initComponents() {
        JLabel titleLabel = new JLabel("Registro");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(130, 50, 260, 25);
        this.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(70, 90, 80, 25);
        this.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(130, 90, 260, 25);
        this.add(lastNameField);

        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(80, 130, 80, 25);
        this.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 130, 260, 25);
        this.add(emailField);

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 170, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 170, 150, 25);
        this.add(genderComboBox);

        registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 220, 150, 25);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(214, 225, 50));
        registerButton.addActionListener(this);
        this.add(registerButton);

        this.setTitle("Registro");
        this.setBounds(650, 400, 500, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrarse")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String selectedGender = (String) genderComboBox.getSelectedItem();

            System.out.println("Nombre: " + firstName);
            System.out.println("Apellido: " + lastName);
            System.out.println("Correo: " + email);
            System.out.println("Género: " + selectedGender);
            
            String studentCode = Integer.toString(Clase5.code);
            String[] dataStudent = {studentCode,firstName, lastName, email, selectedGender};
            Clase5.addStudent(dataStudent);
            Clase5.code += 1;
            ESTUDIANTE student = new ESTUDIANTE();
            this.dispose();
        }
        System.out.println("===================================================");
    }

}
