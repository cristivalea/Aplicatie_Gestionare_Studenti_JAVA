package view;

import model.TipNota;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class FrameAdaugareNotaNumerica extends JFrame implements ActionListener {

    //tipul notei
    private JPanel panelTipNota;
    private JComboBox<TipNota> butonTipNota;
    private JLabel labelButonTipNota;

    //Cautarea studentului
    private JPanel panelCautareStudent;
    private JPanel panelCautareNumeStudent;
    private JTextField txtNumestudent;
    private JLabel labelNumeStudent;
    private JPanel panelButonCautareStudent;
    private ButonCautare butonCautareStudent;
    private JLabel afisareStudenti;

    //Cautarea disciplinei
    private JPanel panelCautareDisciplina;
    private JPanel panelCautareNumeDisciplina;
    private JTextField txtNumeDisciplina;
    private JLabel labelNumeDisciplina;
    private JPanel panleButonCautareDisciplina;
    private ButonCautareDiscipline butonCautareDisciplina;
    private JLabel afisareDiscipline;

    // nota examen
    private JPanel panelNotaExame;
    private JTextField txtNotaExamen;
    private JLabel labelNotaExamen;

    //nota laborator
    private JPanel panelNotaLaborator;
    private JTextField txtNotaLaborator;
    private JLabel labelNotaLaborator;

    //nota seminar
    private JPanel panelNotaSeminar;
    private JTextField txtNotaSeminar;
    private JLabel labelNotaSeminar;

    // nota proiect
    private JPanel panelNotaProiect;
    private JTextField txtNotaProiect;
    private JLabel labelNotaProiect;

    // camp data Examen
    private JPanel panelDataExamen;
    private JLabel labelDataExamen;
    private UtilDateModel modelDataExame;
    private JDatePickerImpl dataExamen;

    // coeficient prezenta curs
    private JPanel panelCoefPrezentaCurs;
    private JTextField txtCoefPrezentaCurs;
    private JLabel labelCoefPrezentaCurs;

    // coeficient prezenta laborator
    private JPanel panelCoefPrezentaLab;
    private JTextField txtCoefPRezentaLab;
    private JLabel labelCoefPrezentaLab;

    // coeficient prezenta seminar
    private JPanel panelCoefPrezentaSeminar;
    private JTextField txtCoefPrezentaSeminar;
    private JLabel labelCoefPrezentaSeminar;

    //coeficient prezenta Proiect
    private JPanel panelCoefPrezentaProiect;
    private JTextField txtCoefPrezentaProiect;
    private JLabel labelCoefPrezentaProiect;

    // main panel
    private JPanel mainPanel;

    // panel buton adaugareNota;
    private JPanel panelButonAdaugare;
    private ButonAdaugareNotaNumerica butonAdaugareNota;

    private JDatePickerImpl createDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Astăzi");
        p.put("text.month", "Lună");
        p.put("text.year", "An");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }
    public FrameAdaugareNotaNumerica(){
        this.mainPanel = new JPanel();
        BoxLayout layout = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
        this.mainPanel.setLayout(layout);

        //tip nota
        this.panelTipNota = new JPanel();
        TipNota tip[] = {TipNota.A, TipNota.N, TipNota.C};
        this.butonTipNota = new JComboBox<TipNota>(tip);
        this.labelButonTipNota = new JLabel("Selectare tip nota");
        this.panelTipNota.add(this.labelButonTipNota);
        this.panelTipNota.add(this.butonTipNota);
        this.mainPanel.add(this.panelTipNota);

        //Cautare student
        this.panelCautareStudent = new JPanel();

        this.panelCautareNumeStudent = new JPanel();
        this.labelNumeStudent = new JLabel("Numele Studentului");
        this.txtNumestudent = new JTextField(50);
        this.panelCautareNumeStudent.add(this.labelNumeStudent);
        this.panelCautareNumeStudent.add(this.txtNumestudent);

        this.panelButonCautareStudent = new JPanel();
        this.afisareStudenti = new JLabel("                                                           ");
        this.panelButonCautareStudent.add(afisareStudenti);
        this.butonCautareStudent = new ButonCautare(this.txtNumeDisciplina, this.afisareStudenti);
        this.butonCautareStudent.addActionListener(this);
        this.panelButonCautareStudent.add(this.butonCautareStudent);

        this.panelCautareStudent.add(this.panelCautareNumeStudent);
        this.panelCautareStudent.add(panelButonCautareStudent);
        this.mainPanel.add(this.panelCautareStudent);

        // Cautare disciplina
        this.panelCautareDisciplina = new JPanel();

        this.panelCautareNumeDisciplina = new JPanel();
        this.labelNumeDisciplina = new JLabel("Numele Disciplinei");
        this.panelCautareNumeDisciplina.add(this.labelNumeDisciplina);
        this.txtNumeDisciplina = new JTextField(50);
        this.panelCautareNumeDisciplina.add(this.txtNumeDisciplina);
        this.panelCautareDisciplina.add(this.panelCautareNumeDisciplina);

        this.panleButonCautareDisciplina = new JPanel();
        this.afisareDiscipline = new JLabel("                                                         ");
        this.panleButonCautareDisciplina.add(this.afisareDiscipline);
        this.butonCautareDisciplina = new ButonCautareDiscipline(this.txtNumeDisciplina, this.afisareDiscipline);
        this.butonCautareDisciplina.addActionListener(this);
        this.panelCautareDisciplina.add(this.butonCautareDisciplina);

        this.mainPanel.add(this.panelCautareDisciplina);

        //nota examen


        this.add(mainPanel);
        this.setVisible(true);
        this.pack();
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Comand) actionEvent.getSource()).execute();
    }

    public static void main(String[] args){
        new FrameAdaugareNotaNumerica();
    }
}
