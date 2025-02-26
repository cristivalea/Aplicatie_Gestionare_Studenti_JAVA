package view;

import model.Data;
import model.NotaCalificativ;
import model.TipNota;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;

public class ButonAdaugareNota extends JButton implements Comand {
    private JComboBox<TipNota> tipNota;
    private ButonCautare butonStudent;
    private ButonCautareDiscipline butonDisciplina;
    private JComboBox<String> calificativ;
    private JDatePickerImpl dataExamen;

    public ButonAdaugareNota(JComboBox<TipNota> tipNota, ButonCautare butonStudent, ButonCautareDiscipline butonDisciplina, JComboBox<String> calificativ, JDatePickerImpl dataExamen) {
        super("Adaugare Calificativ");
        this.tipNota = tipNota;
        this.butonStudent = butonStudent;
        this.butonDisciplina = butonDisciplina;
        this.calificativ = calificativ;
        this.dataExamen = dataExamen;
    }

    public void execute(){
        String tipDisciplina = tipNota.getSelectedItem().toString();
        String codStudent = butonStudent.getText();
        String codDisciplina = butonDisciplina.getText();
        Short codDisciplia_corect = Short.valueOf(codDisciplina);
        String calificativ_corect = calificativ.getSelectedItem().toString();
        String dataEx = dataExamen.toString();
        Data dataE = null;
        try {
            dataE = new Data(dataEx);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            NotaCalificativ notaCalificativ = new NotaCalificativ(codStudent, codDisciplia_corect, dataE, calificativ_corect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
