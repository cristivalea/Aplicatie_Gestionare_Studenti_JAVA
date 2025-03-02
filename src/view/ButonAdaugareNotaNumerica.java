package view;

import main.Comand;
<<<<<<< HEAD
import model.Data;
import model.NotaNumerica;
=======
>>>>>>> origin/master
import model.TipNota;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;

<<<<<<< HEAD
public class ButonAdaugareNotaNumerica extends JButton implements Comand {
=======
public class ButonAdaugareNotaNumerica implements Comand {
>>>>>>> origin/master
    private JComboBox<TipNota> tipNota;
    private ButonCautare butonStudent;
    private ButonCautareDiscipline butonDisciplina;
    private JTextField txtNotaExamen;
    private JTextField txtNotaLaborator;
    private JTextField txtNotaSeminar;
    private JTextField txtNotaProiect;
    private JTextField txtCoefPrezentaCurs;
    private JTextField txtCoefPrezentaLab;
    private JTextField txtCoefPrezentaSeminar;
    private JTextField txtCoefPrezentaProiect;
    private JDatePickerImpl dataExamen;
<<<<<<< HEAD

    public ButonAdaugareNotaNumerica(JComboBox<TipNota> tipNota, ButonCautare butonStudent, ButonCautareDiscipline butonDisciplina, JTextField txtNotaExamen, JTextField txtNotaLaborator, JTextField txtNotaSeminar, JTextField txtNotaProiect, JTextField txtCoefPrezentaCurs, JTextField txtCoefPrezentaLab, JTextField txtCoefPrezentaSeminar, JTextField txtCoefPrezentaProiect, JDatePickerImpl dataExamen) {
        super("Adauga Nota Numerica");
        this.tipNota = tipNota;
        this.butonStudent = butonStudent;
        this.butonDisciplina = butonDisciplina;
        this.txtNotaExamen = txtNotaExamen;
        this.txtNotaLaborator = txtNotaLaborator;
        this.txtNotaSeminar = txtNotaSeminar;
        this.txtNotaProiect = txtNotaProiect;
        this.txtCoefPrezentaCurs = txtCoefPrezentaCurs;
        this.txtCoefPrezentaLab = txtCoefPrezentaLab;
        this.txtCoefPrezentaSeminar = txtCoefPrezentaSeminar;
        this.txtCoefPrezentaProiect = txtCoefPrezentaProiect;
        this.dataExamen = dataExamen;
    }

    public void execute(){
        String tipDisciplina = tipNota.getSelectedItem().toString();
        String codStudent = butonStudent.getText();
        int codDisciplina = Integer.parseInt(butonDisciplina.getText());
        int notaE = Integer.parseInt(txtNotaExamen.getText().trim());
        int notaL = Integer.parseInt(txtNotaLaborator.getText().trim());
        int notaS = Integer.parseInt(txtNotaSeminar.getText().trim());
        int notaP = Integer.parseInt(txtNotaProiect.getText().trim());
        double coefPC = Double.parseDouble(txtCoefPrezentaCurs.getText().trim());
        double coefPL = Double.parseDouble(txtCoefPrezentaLab.getText().trim());
        double coefPS = Double.parseDouble(txtCoefPrezentaSeminar.getText().trim());
        double coefPP = Double.parseDouble(txtCoefPrezentaProiect.getText().trim());
        String dataEx = dataExamen.toString();
        Data dataE = null;
        try {
            dataE = new Data(dataEx);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            NotaNumerica notaNumerica = new NotaNumerica(codDisciplina, codStudent, notaE, notaL, notaS, notaP, dataE);
        }catch (Exception e){
            e.printStackTrace();
        }
=======
    public void execute(){

>>>>>>> origin/master
    }
}
