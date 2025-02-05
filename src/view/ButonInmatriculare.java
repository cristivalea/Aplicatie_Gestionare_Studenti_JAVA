package view;

import model.Data;
import model.Repository;
import model.Student;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ButonInmatriculare extends JButton implements Comand {
    private JTextField txtNrMatricol;
    private JTextField txtNume;
    private JTextField txtPrenume;
    private JDatePickerImpl txtDataNastere;
    private JDatePickerImpl txtDataInmatriculare;
    private JTextField txtVarsta;

    public ButonInmatriculare(JTextField txtNrMatricol, JTextField txtNume, JTextField txtPrenume, JDatePickerImpl txtDataNastere, JDatePickerImpl txtDataInmatriculare, JTextField txtVarsta) {
        super("Înmatriculare");
        this.txtNrMatricol = txtNrMatricol;
        this.txtNume = txtNume;
        this.txtPrenume = txtPrenume;
        this.txtDataNastere = txtDataNastere;
        this.txtDataInmatriculare = txtDataInmatriculare;
        this.txtVarsta = txtVarsta;
    }

    public void execute() {
        String strNume = this.txtNume.getText();
        String strPrenume = this.txtPrenume.getText();

        if (this.txtDataNastere.getModel().getValue() == null || this.txtDataInmatriculare.getModel().getValue() == null) {
            System.err.println("Eroare: Trebuie să selectezi ambele date!");
            return;
        }

        Date selectedDateNastere = (Date) this.txtDataNastere.getModel().getValue();
        Date selectedDateInmatriculare = (Date) this.txtDataInmatriculare.getModel().getValue();

        if (selectedDateNastere == null || selectedDateInmatriculare == null) {
            System.err.println("Eroare: Datele selectate nu sunt valide.");
            return;
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");

        String strDataNastere = dateFormat.format(selectedDateNastere);
        String strDataInmatriculare = dateFormat.format(selectedDateInmatriculare);

        // Debugging: Afișează datele formatate pentru a verifica dacă sunt corect
        System.out.println("Data naștere formatată: " + strDataNastere);
        System.out.println("Data înmatriculare formatată: " + strDataInmatriculare);

        // Încearcă să creezi obiectele de data
        Data dataNastere;
        try {
            dataNastere = new Data(strDataNastere.trim()); // Acum constructorul Data va procesa corect data
        } catch (Exception e) {
            System.err.println("Eroare procesare data nastere: " + e.getMessage());
            return;
        }

        Data dataInmatriculare;
        try {
            dataInmatriculare = new Data(strDataInmatriculare.trim()); // La fel și pentru data de înmatriculare
        } catch (Exception e) {
            System.err.println("Eroare procesare data inmatriculare: " + e.getMessage());
            return;
        }

        // Procesează prenumele
        int nr_spatii = 0;
        for (int i = 0; i < strPrenume.length(); i++) {
            if (strPrenume.charAt(i) == ' ') {
                nr_spatii++;
            }
        }

        String[] vector_prenume = new String[nr_spatii + 1];
        vector_prenume = strPrenume.split(" ");

        // Creează studentul
        Student student;
        try {
            student = new Student(strNume, dataNastere, dataInmatriculare, vector_prenume);
        } catch (Exception e) {
            System.err.println("Eroare creare student: " + e.getMessage());
            return;
        }

        // Afișează și actualizează câmpurile
        System.out.println(student);
        this.txtNrMatricol.setText(student.getNrMatricol());
        this.txtVarsta.setText(String.valueOf(student.getVarta()));

        // Adaugă studentul la repository
        try {
            Repository.getInstance().adaugaStudent(student);
        } catch (Exception e) {
            System.err.println("Eroare student repository: " + e.getMessage());
            return;
        }
    }



}
