package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StergereStudentFrame extends JFrame implements ActionListener {
    private JPanel panelCautare;
    private JPanel panel1;
    private JTextField textNumeText;
    private JLabel labelNumeText;
    private JPanel panel2;
    private ButonCautare butonCautare;
    private JLabel labelAfisareStudentCautare;

    //buton stergere
    private JPanel panelButonStergere;
    private ButonStergere butonStergere;


    private JPanel mainPanel;
    private JComboBox<String> comboBoxStudenti;

    public StergereStudentFrame() {
        this.panelCautare = new JPanel();
        BoxLayout layout = new BoxLayout(this.panelCautare, BoxLayout.Y_AXIS);
        this.panelCautare.setLayout(layout);
        this.panelCautare.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK), // Tipul de bordură
                "Căutarea Studentului după nume",                   // Textul titlului
                TitledBorder.CENTER,                         // Alinierea titlului
                TitledBorder.TOP,                            // Poziția titlului
                new Font("Arial", Font.BOLD, 14),            // Fontul titlului
                Color.BLUE                                   // Culoarea textului
        ));
        this.panel1 = new JPanel();
        this.labelNumeText = new JLabel("Introduceți numele studentului ");
        this.panel1.add(this.labelNumeText);
        this.textNumeText = new JTextField(50);
        this.panel1.add(this.textNumeText);
        this.panelCautare.add(this.panel1);


        this.comboBoxStudenti = new JComboBox<>();
        this.comboBoxStudenti.setVisible(false);
        this.comboBoxStudenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedStudent = (String) comboBoxStudenti.getSelectedItem();
                labelAfisareStudentCautare.setText("Detalii: " + selectedStudent);
            }
        });
        this.panelCautare.add(this.comboBoxStudenti);

        this.panel2 = new JPanel();
        this.labelAfisareStudentCautare = new JLabel("                                                   ");
        this.panel2.add(this.labelAfisareStudentCautare);


        this.butonCautare = new ButonCautare(this.textNumeText, this.labelAfisareStudentCautare);
        this.butonCautare.addActionListener(this);
        this.panel2.add(this.butonCautare);
        this.panelCautare.add(this.panel2);

        this.butonStergere = new ButonStergere(this.labelAfisareStudentCautare);
        this.butonStergere.addActionListener(this);
        this.panelButonStergere = new JPanel();
        this.panelButonStergere.add(this.butonStergere);

        this.mainPanel = new JPanel();
        BoxLayout layoutMainPanel = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
        this.mainPanel.setLayout(layoutMainPanel);
        this.mainPanel.add(this.panelCautare);
        this.mainPanel.add(this.panelButonStergere);

        this.add(mainPanel);
        this.setVisible(true);
        this.pack();
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Comand) actionEvent.getSource()).execute();
    }

    public static void main(String[] argc) {
        new StergereStudentFrame();
    }
}
