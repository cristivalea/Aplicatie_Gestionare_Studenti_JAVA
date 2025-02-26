package view;

import model.TipNota;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class FrameAdaugareNotaCalificativAR extends JFrame implements ActionListener {

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

    // camp pentru calificativ
    private JPanel panelCalificativ;
    private JComboBox<String> txtCalificativ;
    private JLabel labelCalificativ;

    // camp data Examen
    private JPanel panelDataExamen;
    private JLabel labelDataExamen;
    private UtilDateModel modelDataExame;
    private JDatePickerImpl dataExamen;

    // main panel
    private JPanel mainPanel;

    // panel buton adaugareNota;
    private JPanel panelButonAdaugare;
    private ButonAdaugareNota butonAdaugareNota;

    private JDatePickerImpl createDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Astăzi");
        p.put("text.month", "Lună");
        p.put("text.year", "An");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public FrameAdaugareNotaCalificativAR(){
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

        //panel calificativ
        this.panelCalificativ = new JPanel();
        String calificative[] = {"ADMIS", "RESPINS"};
        this.txtCalificativ = new JComboBox<>(calificative);
        this.labelCalificativ = new JLabel("Calificative");
        this.panelCalificativ.add(this.labelCalificativ);
        this.panelCalificativ.add(this.txtCalificativ);

        this.mainPanel.add(this.panelCalificativ);

        //data examen
        this.panelDataExamen = new JPanel();
        this.dataExamen = createDatePicker();
        this.labelDataExamen = new JLabel("Data Examen");
        this.panelDataExamen.add(this.labelDataExamen);
        this.panelDataExamen.add(this.dataExamen);

        this.mainPanel.add(this.panelDataExamen);

        // buton adaugare Nota
        this.panelButonAdaugare = new JPanel();
        this.butonAdaugareNota = new ButonAdaugareNota(this.butonTipNota, this.butonCautareStudent, this.butonCautareDisciplina, this.txtCalificativ, this.dataExamen);
        this.butonAdaugareNota.addActionListener(this);
        this.panelButonAdaugare.add(this.butonAdaugareNota);
        this.mainPanel.add(this.panelButonAdaugare);



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
        new FrameAdaugareNotaCalificativAR();
    }
}


