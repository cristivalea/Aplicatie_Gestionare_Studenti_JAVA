package view;

import model.RegularExpresion;
import model.Repository;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class ButonCautare extends JButton implements Comand {
    private JTextField textNumeText;
    private JLabel labelAfisareStudentCautare;
    private JComboBox<String> comboBox;

    public ButonCautare(JTextField textNumeText, JLabel labelAfisareStudentCautare) {
        super("Cautare Student");
        this.textNumeText = textNumeText;
        this.labelAfisareStudentCautare = labelAfisareStudentCautare;

        // Inițializăm comboBox-ul
        this.comboBox = new JComboBox<>();
        this.comboBox.setVisible(false); // Inițial nu este vizibil
    }

    public void execute(){
        try {
            String numeFamilie = this.textNumeText.getText();


            if (RegularExpresion.RegularExpresionNumePrenume(numeFamilie) == false) {
                System.err.println("Formatul numelui de familie este gresit!");
                return;
            }


            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            boolean studentGasit = false;


            for (Student student : Repository.getInstance().getStudenti()) {
                if (student.getNumeFamilie().equalsIgnoreCase(numeFamilie)) {
                    String numeComplet = student.getNumeFamilie() + " " + String.join(" ", student.getPrenume()) + " " + student.getNrMatricol();
                    model.addElement(numeComplet);
                    studentGasit = true;
                }
            }


            if (!studentGasit) {
                this.labelAfisareStudentCautare.setText("Nu au fost găsiți studenți cu acest nume.");
                this.comboBox.setVisible(false);  // Ascundem ComboBox-ul
                return;
            }


            this.comboBox.setModel(model);
            this.comboBox.setVisible(true);


            this.comboBox.addActionListener(e -> {
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem != null) {
                    this.labelAfisareStudentCautare.setText("Student selectat: " + selectedItem);
                }
            });


            if (this.comboBox.getParent() == null) {
                JPanel comboPanel = new JPanel();
                comboPanel.add(this.comboBox);
                this.labelAfisareStudentCautare.getParent().add(comboPanel, BorderLayout.SOUTH);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
