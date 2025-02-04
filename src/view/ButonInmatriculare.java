package view;

import model.Data;
import model.Repository;
import model.Student;

import javax.swing.*;

public class ButonInmatriculare extends JButton implements Comand {
    private JTextField txtNrMatricol;
    private JTextField txtNume;
    private JTextField txtPrenume;
    private JTextField txtDataNastere;
    private JTextField txtDataInmatriculare;
    private JTextField txtVarsta;

    public ButonInmatriculare(JTextField txtNrMatricol, JTextField txtNume, JTextField txtPrenume, JTextField txtDataNastere, JTextField txtDataInmatriculare, JTextField txtVarsta) {
        super("Înmatriculare");
        this.txtNrMatricol = txtNrMatricol;
        this.txtNume = txtNume;
        this.txtPrenume = txtPrenume;
        this.txtDataNastere = txtDataNastere;
        this.txtDataInmatriculare = txtDataInmatriculare;
        this.txtVarsta = txtVarsta;
    }

    public void execute(){
        String strNume = this.txtNume.getText();
        String strPrenume = this.txtPrenume.getText();
        String strDataNastere = this.txtDataNastere.getText();
        Data dataNastere;
        try {
            dataNastere = new Data(strDataNastere.trim());
        }catch (Exception e){
            System.err.println("Eroare procesare data nastere");
            return;
        }
        if(dataNastere == null){
            System.exit(1);
        }
        String strDataInmatriculare = this.txtDataInmatriculare.getText();
        Data dataInmatriculare;
        try {
            dataInmatriculare = new Data(strDataInmatriculare.trim());
        }catch (Exception e){
            System.err.println("Eroare procesare data inmatriculare");
            return;
        }
        if(dataInmatriculare == null){
            System.exit(1);
        }
        int nr_spatii = 0;
        for(int i = 0; i < strPrenume.length(); i++){
            if(strPrenume.charAt(i) == ' '){
                nr_spatii++;
            }
        }
        String[] vector_prenume = new String[nr_spatii + 1];
        vector_prenume = strPrenume.split(" ");
        Student student;
        try {
            student = new Student(strNume, dataNastere, dataInmatriculare, vector_prenume);
        }catch (Exception e){
            System.err.println("Eroare creare student");
            return;
        }
        System.out.println(student);
        this.txtNrMatricol.setText(student.getNrMatricol());
        this.txtVarsta.setText(String.valueOf(student.getVarta()));
        try {
            Repository.getInstance().adaugaStudent(student);
        }catch(Exception e) {
            System.err.println("Eroare student repository");
            return;
        }
    }
}
