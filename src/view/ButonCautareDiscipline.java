package view;

import model.Disciplina;
import model.Repository;

import javax.swing.*;
import java.awt.*;

public class ButonCautareDiscipline extends JButton implements Comand {
    private JTextField txtNumeButon;
    private JLabel labelAfisareDiscipline;
    private JComboBox<String> comboBox;

    public ButonCautareDiscipline(JTextField nume, JLabel afisare){
        super("Cautare disiciplina");
        this.txtNumeButon = nume;
        this.labelAfisareDiscipline = afisare;
        this.comboBox = new JComboBox<>();
        this.comboBox.setVisible(false);
    }

    public void execute(){
        try {
            String numeDisciplina = this.txtNumeButon.getText();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            boolean disciplinaGasit = false;
            for (Disciplina d : Repository.getInstance().getDiscipline()) {
                if (numeDisciplina.equals(d.getNumeDisciplina())) {
                    String linie = d.getNumeDisciplina() + " " + d.getCodDisciplina();
                    model.addElement(linie);
                    disciplinaGasit = true;
                }
            }
            if (!disciplinaGasit) {
                this.labelAfisareDiscipline.setText("Nu au fost găsite discipline cu acest nume.");
                this.comboBox.setVisible(false);
                return;
            }

            this.comboBox.setModel(model);
            this.comboBox.setVisible(true);

            this.comboBox.addActionListener(e -> {
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem != null) {
                    this.labelAfisareDiscipline.setText("Disciplina selectata: " + selectedItem);
                }
            });

            if (this.comboBox.getParent() == null) {
                JPanel comboPanel = new JPanel();
                comboPanel.add(this.comboBox);
                this.labelAfisareDiscipline.getParent().add(comboPanel, BorderLayout.SOUTH);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
