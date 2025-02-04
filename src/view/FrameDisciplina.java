package view;

import model.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDisciplina extends JFrame implements ActionListener{
    private JPanel panelCodDsiciplina;
    private JTextField txtCodDisciplina;
    private JLabel labelCodDisciplina;

    private JPanel panleNumeDisciplina;
    private JTextField txtNumeDisciplina;
    private JLabel labelNumeDisciplina;

    private JPanel panelCoefExamen;
    private JTextField txtCoefExamen;
    private JLabel labelCoefExamen;

    private JPanel panelCoeflab;
    private JTextField txtCoefLab;
    private JLabel labelCoefLab;

    private JPanel panelCoefProiect;
    private JTextField txtCoefProiect;
    private JLabel labelCoefProiect;

    private JPanel panelCoefPrezentaCurs;
    private JTextField txtCoefPrezentaCurs;
    private JLabel labelCoefPrezentaCurs;

    private JPanel panelCoefPrezentaLab;
    private JTextField txtCoefPrezentaLab;
    private JLabel labelCoefPrezentaLab;

    private JPanel panelCoefPrezentaSeminar;
    private JTextField txtCoefPrezentaSeminar;
    private JLabel labelCoefPrezentaSeminar;

    private JPanel panelCoefPrezentaProiect;
    private JTextField txtCoefPrezentaProiect;
    private JLabel labelCoefPrezentaProiect;

    private JPanel panelNrCredite;
    private JComboBox<String> txtNrCredite;
    private JLabel labelNrCredite;

    private ButonAdaugaDisciplina adaugareDsiciplina;
    private JPanel panelAdaugareDisciplina;
    private JPanel mainPanel;

    public FrameDisciplina(){
        this.mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
        this.mainPanel.setLayout(boxLayout);

        this.panelCodDsiciplina = new JPanel();
        this.txtCodDisciplina = new JTextField(50);
        this.txtCodDisciplina.setEditable(false);
        this.labelCodDisciplina = new JLabel("Codul Disciplinei");
        this.panelCodDsiciplina.add(this.labelCodDisciplina);
        this.panelCodDsiciplina.add(this.txtCodDisciplina);
        this.mainPanel.add(this.panelCodDsiciplina);

        this.panleNumeDisciplina = new JPanel();
        this.txtNumeDisciplina = new JTextField(50);
        this.labelNumeDisciplina = new JLabel("Numele Disciplinei");
        this.panleNumeDisciplina.add(this.labelNumeDisciplina);
        this.panleNumeDisciplina.add(this.txtNumeDisciplina);
        this.mainPanel.add(this.panleNumeDisciplina);

        this.panelCoefExamen = new JPanel();
        this.txtCoefExamen = new JTextField(50);
        this.txtCoefExamen.setText("0.5");
        this.labelCoefExamen = new JLabel("Coeficientul Examenului");
        this.panelCoefExamen.add(this.labelCoefExamen);
        this.panelCoefExamen.add(this.txtCoefExamen);
        this.mainPanel.add(this.panelCoefExamen);

        this.panelCoeflab = new JPanel();
        this.txtCoefLab = new JTextField(50);
        this.txtCoefLab.setText("0.5");
        this.labelCoefLab = new JLabel("Coeficient Laborator");
        this.panelCoeflab.add(this.labelCoefLab);
        this.panelCoeflab.add(this.txtCoefLab);
        this.mainPanel.add(this.panelCoeflab);

        this.panelCoefProiect = new JPanel();
        this.txtCoefProiect = new JTextField(50);
        this.txtCoefProiect.setText("0");
        this.labelCoefProiect = new JLabel("Coeficientul Proiectului");
        this.panelCoefProiect.add(this.labelCoefProiect);
        this.panelCoefProiect.add(this.txtCoefProiect);
        this.mainPanel.add(this.panelCoefProiect);

        this.panelCoefPrezentaCurs = new JPanel();
        this.txtCoefPrezentaCurs = new JTextField(50);
        this.txtCoefPrezentaCurs.setText("0");
        this.labelCoefPrezentaCurs = new JLabel("Coeficient Prezenta Curs");
        this.panelCoefPrezentaCurs.add(this.labelCoefPrezentaCurs);
        this.panelCoefPrezentaCurs.add(this.txtCoefPrezentaCurs);
        this.mainPanel.add(panelCoefPrezentaCurs);

        this.panelCoefPrezentaLab = new JPanel();
        this.txtCoefPrezentaLab = new JTextField(50);
        this.txtCoefPrezentaLab.setText("0");
        this.labelCoefPrezentaLab = new JLabel("Coeficient Prezenta Laborator");
        this.panelCoefPrezentaLab.add(this.labelCoefPrezentaLab);
        this.panelCoefPrezentaLab.add(this.txtCoefPrezentaLab);
        this.mainPanel.add(this.panelCoefPrezentaLab);

        this.panelCoefPrezentaSeminar = new JPanel();
        this.txtCoefPrezentaSeminar = new JTextField(50);
        this.txtCoefPrezentaSeminar.setText("0");
        this.labelCoefPrezentaSeminar = new JLabel("Coeficient Prezenta Seminar");
        this.panelCoefPrezentaSeminar.add(this.labelCoefPrezentaSeminar);
        this.panelCoefPrezentaSeminar.add(this.txtCoefPrezentaSeminar);
        this.mainPanel.add(this.panelCoefPrezentaSeminar);

        this.panelCoefPrezentaProiect = new JPanel();
        this.txtCoefPrezentaProiect = new JTextField(50);
        this.txtCoefPrezentaProiect.setText("0");
        this.labelCoefPrezentaProiect = new JLabel("Coeficient Prezenta Proiect");
        this.panelCoefPrezentaProiect.add(this.labelCoefPrezentaProiect);
        this.panelCoefPrezentaProiect.add(this.txtCoefPrezentaProiect);
        this.mainPanel.add(this.panelCoefPrezentaProiect);

        this.panelNrCredite = new JPanel();
        String[] v = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        this.txtNrCredite = new JComboBox<String>(v);
        this.labelNrCredite = new JLabel("Numar Credite");
        this.panelNrCredite.add(this.labelNrCredite);
        this.panelNrCredite.add(this.txtNrCredite);
        this.mainPanel.add(this.panelNrCredite);

        this.panelAdaugareDisciplina = new JPanel();
        this.adaugareDsiciplina = new ButonAdaugaDisciplina(txtCodDisciplina, txtNumeDisciplina, txtCoefExamen, txtCoefLab, txtCoefProiect, txtCoefPrezentaCurs, txtCoefPrezentaLab, txtCoefPrezentaSeminar, txtCoefPrezentaProiect, txtNrCredite);
        this.adaugareDsiciplina.addActionListener(this);
        this.panelAdaugareDisciplina.add(this.adaugareDsiciplina);
        this.mainPanel.add(this.panelAdaugareDisciplina);

        this.add(this.mainPanel);
        this.setVisible(true);
        this.pack();
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws Exception{
        FrameDisciplina frame1 = new FrameDisciplina();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Comand)actionEvent.getSource()).execute();
    }
}
