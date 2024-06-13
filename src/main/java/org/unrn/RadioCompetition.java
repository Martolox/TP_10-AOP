package org.unrn;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.lang.System.exit;

public class RadioCompetition implements ActionListener {
    private final JPanel contentPane;
    private final Modelo modelo;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    public RadioCompetition(Modelo modelo) {
        this.modelo = modelo;

        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(this);
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<>(new String[]{"Indicar concurso",
                Arrays.toString(modelo.cargarConcursos())});
    }

    public void actionPerformed(ActionEvent e) {
        btnOk.setEnabled(false);
        RadioCompetition.this.gaurdarInscripcion();
        btnOk.setEnabled(true);
    }

    private void gaurdarInscripcion() {
        if (camposValidos()) {
            modelo.guardarDatos(txtName.getText(), txtLastName.getText(), txtEmail.getText(),
                    txtPhone.getText(), comboBox.getSelectedItem().toString());
        }
        JOptionPane.showMessageDialog(this.contentPane, "Se registró la inscripción");
        exit(0);
    }

    private boolean camposValidos() {
        if ("".equals(txtName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "Nombre no puede ser vacio");
            return false;
        }
        if ("".equals(txtLastName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "apellido no puede ser vacio");
            return false;
        }
        if ("".equals(txtId.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "dni no puede ser vacio");
            return false;
        }
        if (!modelo.checkEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "email debe ser válido");
            return false;
        }
        if (!modelo.checkPhone(txtPhone.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return false;
        }
        if (this.comboBox.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
            return false;
        }
        return true;
    }

    private void layout() {
        GroupLayout gl = new GroupLayout(contentPane);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.LEADING).addGroup(gl.createSequentialGroup()
                .addContainerGap().addGroup(gl.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl.createSequentialGroup().addGroup(gl
                                        .createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblLastName).addComponent(lblId)
                                        .addComponent(lblPhone).addComponent(lblEmail)
                                        .addComponent(lblName).addComponent(lblCompetition))
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(gl
                                        .createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmail, Alignment.TRAILING)
                                        .addComponent(txtPhone, Alignment.TRAILING)
                                        .addComponent(txtId, Alignment.TRAILING)
                                        .addComponent(txtLastName, Alignment.TRAILING)
                                        .addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                                298, Short.MAX_VALUE)))
                        .addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
                                86, GroupLayout.PREFERRED_SIZE))
                .addContainerGap()));
        gl.setVerticalGroup(gl.createParallelGroup(Alignment.LEADING)
                .addGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblLastName).addComponent(txtLastName,
                                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblId).addComponent(
                                        txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl.createSequentialGroup().addComponent(lblPhone)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(lblEmail))
                                .addGroup(gl.createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addGroup(
                                                gl.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblCompetition))))
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl);
    }
}