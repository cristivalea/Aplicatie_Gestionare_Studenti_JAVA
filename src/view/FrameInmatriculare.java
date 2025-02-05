package view;

import model.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameInmatriculare extends JFrame implements ActionListener {
    private JPanel panelNrMatricol;
    private JTextField txtNrMatricol;
    private JLabel labelNrMatricol;


    private JPanel panelNume;
    private JTextField txtNume;
    private JLabel labeNume;

    private JPanel panelPrenume;
    private JTextField txtPrenume;
    private JLabel labelPrenume;


    private JPanel panelDataNastere;
    private JTextField txtDataNastere;
    private JLabel labelDataNastere;



    private JPanel panelDataInmatriculare;
    private JTextField txtDataInmatriculare;
    private JLabel labelDataInmatriculare;


    private JPanel panelVarsta;
    private JTextField txtVarsta;
    private JLabel labelVarsta;


    private ButonInmatriculare butonInmatriculare;
    private JPanel panelButon;
    private JPanel mainPanel;

    public FrameInmatriculare(){
        this.mainPanel = new JPanel();
        BoxLayout layout = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
        this.mainPanel.setLayout(layout);

        this.panelNrMatricol = new JPanel();
        this.txtNrMatricol = new JTextField(50);
        this.txtNrMatricol.setEditable(false);
        this.labelNrMatricol = new JLabel("Numar matricol");
        this.panelNrMatricol.add(this.labelNrMatricol);
        this.panelNrMatricol.add(this.txtNrMatricol);
        this.mainPanel.add(this.panelNrMatricol);

        this.panelNume = new JPanel();
        this.txtNume = new JTextField(50);
        this.labeNume = new JLabel("Nume");
        this.panelNume.add(this.labeNume);
        this.panelNume.add(this.txtNume);
        this.mainPanel.add(this.panelNume);

        this.panelPrenume = new JPanel();
        this.txtPrenume = new JTextField(50);
        this.labelPrenume = new JLabel("Prenume");
        this.panelPrenume.add(this.labelPrenume);
        this.panelPrenume.add(this.txtPrenume);
        this.mainPanel.add(this.panelPrenume);

        this.panelDataNastere = new JPanel();
        this.txtDataNastere = new JTextField(50);
        this.labelDataNastere =new JLabel("Data Naștere");
        this.panelDataNastere.add(this.labelDataNastere);
        this.panelDataNastere.add(this.txtDataNastere);
        this.mainPanel.add(this.panelDataNastere);

        this.panelDataInmatriculare = new JPanel();
        this.txtDataInmatriculare = new JTextField(50);
        this.labelDataInmatriculare = new JLabel("Data Înmatriculare");
        this.panelDataInmatriculare.add(this.labelDataInmatriculare);
        this.panelDataInmatriculare.add(this.txtDataInmatriculare);
        this.mainPanel.add(this.panelDataInmatriculare);

        this.panelVarsta = new JPanel();
        this.txtVarsta = new JTextField(50);
        this.txtVarsta.setEditable(false);
        this.labelVarsta = new JLabel("Vârsta");
        this.panelVarsta.add(this.labelVarsta);
        this.panelVarsta.add(this.txtVarsta);
        this.mainPanel.add(this.panelVarsta);

        this.butonInmatriculare = new ButonInmatriculare(txtNrMatricol, txtNume, txtPrenume, txtDataNastere, txtDataInmatriculare, txtVarsta);
        this.butonInmatriculare.addActionListener(this);
        this.panelButon = new JPanel();
        this.panelButon.add(this.butonInmatriculare);
        this.mainPanel.add(this.panelButon);


        this.add(mainPanel);
        this.setVisible(true);
        this.pack();
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception{

        Repository.getInstance();
        FrameInmatriculare frame1 = new FrameInmatriculare();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Comand)actionEvent.getSource()).execute();
    }
}
