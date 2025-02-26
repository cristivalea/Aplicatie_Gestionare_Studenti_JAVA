package view;

import main.Comand;
import model.TipNota;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;

public class ButonAdaugareNotaNumerica implements Comand {
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
    public void execute(){

    }
}
