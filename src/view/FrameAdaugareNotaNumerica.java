package view;

import model.Disciplina;
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
        this.panelNotaExame = new JPanel();
        this.txtNotaExamen = new JTextField(5);
        this.labelNotaExamen = new JLabel("Nota examen");
        this.panelNotaExame.add(this.labelNotaExamen);
        this.panelNotaExame.add(this.txtNotaExamen);
        this.mainPanel.add(this.panelNotaExame);

        //nota laborator
        this.panelNotaLaborator = new JPanel();
        this.txtNotaLaborator = new JTextField(5);
        this.labelNotaLaborator = new JLabel("Nota Laborator");
        this.panelNotaLaborator.add(this.labelNotaLaborator);
        this.panelNotaLaborator.add(this.txtNotaLaborator);
        this.mainPanel.add(this.panelNotaLaborator);

        //Nota seminar
        this.panelNotaSeminar = new JPanel();
        this.txtNotaSeminar = new JTextField(5);
        this.labelNotaSeminar = new JLabel("Nota Seminar");
        this.panelNotaSeminar.add(this.labelNotaSeminar);
        this.panelNotaSeminar.add(this.txtNotaSeminar);
        this.mainPanel.add(this.panelNotaSeminar);

        //Nota proiect
        this.panelNotaProiect = new JPanel();
        this.txtNotaProiect = new JTextField(5);
        this.labelNotaProiect = new JLabel("Nota Proiect");
        this.panelNotaProiect.add(this.labelNotaProiect);
        this.panelNotaProiect.add(this.txtNotaProiect);
        this.mainPanel.add(this.panelNotaProiect);

        //extragere coeficeinti
        String coefPRezC = null;
        String coefPrezL = null;
        String coefPrezS = null;
        String coefPrezP = null;
        Disciplina disciplinaSelectata = butonCautareDisciplina.getDisciplinaSelectata();
        if (disciplinaSelectata != null) {
            coefPRezC = String.valueOf(disciplinaSelectata.getCoefPrezentaCurs());
            coefPrezL = String.valueOf(disciplinaSelectata.getCoefPrezentaLab());
            coefPrezS = String.valueOf(disciplinaSelectata.getCoefPrezentaSeminar());
            coefPrezP = String.valueOf(disciplinaSelectata.getCoefPrezentaProiect());
        }

        //coeficient prezenta curs
        this.panelCoefPrezentaCurs = new JPanel();
        this.txtCoefPrezentaCurs = new JTextField(5);
        this.txtCoefPrezentaCurs.setText(coefPRezC);
        this.txtCoefPrezentaCurs.setEditable(false);
        this.labelCoefPrezentaCurs = new JLabel("Coeficient prezenta curs");
        this.panelCoefPrezentaCurs.add(this.labelCoefPrezentaCurs);
        this.panelCoefPrezentaCurs.add(this.txtCoefPrezentaCurs);
        this.mainPanel.add(this.panelCoefPrezentaCurs);

        //coeficient prezenta laborator
        this.panelCoefPrezentaLab = new JPanel();
        this.txtCoefPRezentaLab = new JTextField(5);
        this.txtCoefPRezentaLab.setText(coefPrezL);
        this.txtCoefPRezentaLab.setEditable(false);
        this.labelCoefPrezentaLab = new JLabel("Coeficient prezenta laborator");
        this.panelCoefPrezentaLab.add(this.labelCoefPrezentaLab);
        this.panelCoefPrezentaLab.add(this.txtCoefPRezentaLab);
        this.mainPanel.add(this.panelCoefPrezentaLab);

        //coeficient prezenta seminar
        this.panelCoefPrezentaSeminar = new JPanel();
        this.txtCoefPrezentaSeminar = new JTextField(5);
        this.txtCoefPrezentaSeminar.setText(coefPrezS);
        this.txtCoefPrezentaSeminar.setEditable(false);
        this.labelCoefPrezentaSeminar = new JLabel("Coeficient prezenta seminar");
        this.panelCoefPrezentaSeminar.add(this.labelCoefPrezentaSeminar);
        this.panelCoefPrezentaSeminar.add(this.txtCoefPrezentaSeminar);
        this.mainPanel.add(this.panelCoefPrezentaSeminar);

        this.panelCoefPrezentaProiect = new JPanel();
        this.txtCoefPrezentaProiect = new JTextField(5);
        this.txtCoefPrezentaProiect.setText(coefPrezP);
        this.txtCoefPrezentaProiect.setEditable(false);
        this.labelCoefPrezentaProiect = new JLabel("Coeficient prezenta proiect");
        this.panelCoefPrezentaProiect.add(this.labelCoefPrezentaProiect);
        this.panelCoefPrezentaProiect.add(this.txtCoefPrezentaProiect);
        this.mainPanel.add(this.panelCoefPrezentaProiect);

        //data examen
        this.panelDataExamen = new JPanel();
        this.dataExamen = createDatePicker();
        this.labelDataExamen = new JLabel("Data Examen");
        this.panelDataExamen.add(this.labelDataExamen);
        this.panelDataExamen.add(this.dataExamen);
        this.mainPanel.add(this.panelDataExamen);

        this.panelButonAdaugare = new JPanel();
        this.butonAdaugareNota = new ButonAdaugareNotaNumerica(butonTipNota, );
//        this.adaugareDsiciplina.addActionListener(this);
//        this.panelAdaugareDisciplina.add(this.adaugareDsiciplina);
//        this.mainPanel.add(this.panelAdaugareDisciplina);


        this.add(mainPanel);
        this.setVisible(true);

        this.pack();
        this.setSize(700, 800);
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
