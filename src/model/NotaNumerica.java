package model;

import teste.Main2;

import java.util.Optional;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class NotaNumerica extends Nota {
    private int notaExamen;
    private int notalaborator;
    private int notaProiect;
    private int notaSeminar;
    private int notaFinala;

    public NotaNumerica(int codDisciplina, String codStudent, int notaE, int notaL, int notaP, int notaS, Data data) throws Exception{
        super(codStudent, codDisciplina, data);
        this.notaExamen = notaE;
        this.notalaborator = notaL;
        this.notaProiect = notaP;
        this.notaSeminar = notaS;
        this.notaFinala = (int)(this.notaExamen * this.disciplina.getCoefExamne() + this.notalaborator * this.disciplina.getCoefLab() + this.notaProiect * this.disciplina.getCoefProiect() + this.notaSeminar * this.disciplina.getCoefSeminar());
        this.promovat = isPromovat();
    }

    public NotaNumerica(Disciplina disciplina, Student student, int notaE, int notaL, int notaP, int notaS, Data data){
        super(student, disciplina, data);
        this.notaExamen = notaE;
        this.notalaborator = notaL;
        this.notaProiect = notaP;
        this.notaSeminar = notaS;
        this.notaFinala = (int)(this.notaExamen * this.disciplina.getCoefExamne() + this.notalaborator * this.disciplina.getCoefLab() + this.notaProiect * this.disciplina.getCoefProiect() + this.notaSeminar * this.disciplina.getCoefSeminar());
        this.promovat = isPromovat();
    }

    public NotaNumerica(String linie) throws Exception{
        super();
//        if(!RegularExpresion.RegularExpresionLinieNotaCalificativ(linie)){
//            FormatInadecvatLinieNotaCalificativ inadecvat = new FormatInadecvatLinieNotaCalificativ(linie, "[N]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2}\\;([1-9][0]?\\;){4}([0](\\,\\d)\\;?){4}[1-3]?\\d\\/[1-9]?[1-2]?\\/\\d{4}");
//            throw inadecvat;
//        }
        Scanner scanner =  new Scanner(linie);
        scanner.useDelimiter(";");
        scanner.next();
        String codStudent = scanner.next().trim();
        int cod_Disciplina = scanner.nextInt();
        int notaExamen = scanner.nextInt();
        int notaLaborator = scanner.nextInt();
        int notaProiect = scanner.nextInt();
        int notaSeminar = scanner.nextInt();
        double coefExamen = scanner.nextDouble();
        double coefLab = scanner.nextDouble();
        double coefProiect = scanner.nextDouble();
        double coefSeminar = scanner.nextDouble();
        String data = scanner.next().trim();
        scanner.close();
        if(!RegularExpresion.RegularExpresionData(data)){
            DataFormatException dataex = new DataFormatException(data);
            throw dataex;
        }
        Data d= new Data(data);
        this.codStudent = codStudent;
//        ArrayList<Student> listaStudenti = Repository.getInstance().getStudenti();
//        for(Student s : listaStudenti){
//            if(s.getNrMatricol().equals(codStudent)){
//                this.student = s;
//                break;
//            }
//        }
        this.codDisciplina = cod_Disciplina;
//        ArrayList<Disciplina> listaDiscipline = Repository.getInstance().getDiscipline();
//        for(Disciplina disc : listaDiscipline){
//            if(disc.getCodDisciplina() == cod_Disciplina){
//                this.disciplina = disc;
//                break;
//            }
//        }
        this.notaExamen = notaExamen;
        this.notalaborator = notaLaborator;
        this.notaProiect = notaProiect;
        this.notaSeminar = notaSeminar;
        this.dataExamen = d;
        //this.notaFinala = (int)(this.notaExamen * this.disciplina.getCoefExamne() + this.notalaborator * this.disciplina.getCoefLab() + this.notaProiect * this.disciplina.getCoefProiect() + this.notaSeminar * this.disciplina.getCoefSeminar());
        this.promovat = isPromovat();
    }

    public boolean isPromovat(){
        boolean c1 = this.notaExamen != 0 && this.notaExamen < 5;
        boolean c2 = this.notalaborator != 0 && this.notalaborator < 5;
        boolean c3 = this.notaProiect != 0 && this.notaProiect < 5;
        boolean c4 = this.notaSeminar != 0 && this.notaSeminar < 5;
        Main2.logger.info("Return isPromovat: " + this.notaExamen + " " + this.notalaborator + " " + this.notaProiect + " " + this.notaSeminar);
        if(c1 || c2 || c3 || c4){
            this.promovat = false;
            return false;
        }
        if(this.notaFinala > 5){
            this.promovat = true;
            return true;
        }
        return false;
    } // end function isPromovat

    public Optional getNotaFinala(){
        Optional<Integer> obj = Optional.of(this.notaFinala);
        return obj;
    } // end Optional

    public String toString(){
        return "Nota Numerica ["
                + (this.notaFinala != 0 ? "valoare= " + this.notaFinala +",":"")
                + (codStudent != null ? "codul studentului= " + this.codStudent + ",":"")
                + (codDisciplina != 0 ? "codul disciplinei= " + this.codDisciplina + ",":"")
                + (dataExamen != null ? "data examen= " + this.dataExamen + ",":"")
                + "promovat= " + this.promovat + " "
                + " ]";
    }

    public void setNotaFinala(){
        this.notaFinala = (int)(this.notaExamen * this.disciplina.getCoefExamne() + this.notalaborator * this.disciplina.getCoefLab() + this.notaProiect * this.disciplina.getCoefProiect() + this.notaSeminar * this.disciplina.getCoefSeminar());
    }

    public int getNotaExamen() {
        return notaExamen;
    }

    public int getNotalaborator() {
        return notalaborator;
    }

    public int getNotaProiect() {
        return notaProiect;
    }

    public int getNotaSeminar() {
        return notaSeminar;
    }

    public void setNotaExamen(int notaExamen) {
        this.notaExamen = notaExamen;
    }

    public void setNotalaborator(int notalaborator) {
        this.notalaborator = notalaborator;
    }

    public void setNotaProiect(int notaProiect) {
        this.notaProiect = notaProiect;
    }

    public void setNotaSeminar(int notaSeminar) {
        this.notaSeminar = notaSeminar;
    }
}
