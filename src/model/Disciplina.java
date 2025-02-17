package model;

import teste.Main2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Disciplina {
    private short codDisciplina;
    private String numeDisciplina;
    private double coefExamne;
    private double coefLab;

    private double coefSeminar;
    private double coefProiect;
    private double coefPrezentaCurs;
    private double coefPrezentaLab;
    private double coefPrezentaSeminar;
    private double coefPrezentaProiect;
    private short nrCredite;
    private FisaDisciplinei fisaDisciplinei;
    private static ArrayList<Short> coduriExistente = new ArrayList<Short>();

    public Disciplina(short codD, String numeD, double coefE, double coefL, double coefP, double coefS, double coefPC, double coefPL, double coefPS, double coefPP, short nrC) {
        this.codDisciplina = codD;
        this.numeDisciplina = numeD;
        this.coefExamne = coefE;
        this.coefLab = coefL;
        this.coefProiect = coefP;
        this.coefSeminar = coefS;
        this.coefPrezentaCurs = coefPC;
        this.coefPrezentaLab = coefPL;
        this.coefPrezentaSeminar = coefPS;
        this.coefPrezentaProiect = coefPS;
        this.nrCredite = nrC;
    }

    public Disciplina(String linie) {
        Scanner scanner = new Scanner(linie);
        scanner.useDelimiter(";");
        short codD = scanner.nextShort();
        this.codDisciplina = codD;
        this.numeDisciplina = scanner.next();
        double coefEx = scanner.nextDouble();
        this.coefExamne = coefEx;
        double coefL = scanner.nextDouble();
        this.coefLab = coefL;
        double coefSeminar = scanner.nextDouble();
        this.coefSeminar = coefSeminar;
        double coefP = scanner.nextDouble();
        this.coefProiect = coefP;
        double coefPrezC = scanner.nextDouble();
        this.coefPrezentaCurs = coefPrezC;
        double coefPrezL = scanner.nextDouble();
        this.coefPrezentaLab = coefPrezL;
        double coefPrezS = scanner.nextDouble();
        this.coefPrezentaSeminar = coefPrezS;
        double coefPrezP = scanner.nextDouble();
        this.coefPrezentaProiect = coefPrezP;
        this.nrCredite = scanner.nextShort();
        scanner.close();
        Main2.logger.info("S-a incarcat disciplina" + this.codDisciplina + ";" + this.numeDisciplina + ";" + this.coefExamne + ";" + this.coefExamne + ";" + this.coefLab + ";" + this.nrCredite);
    }

    public Disciplina(){
        Random random = new Random();
        short auxCod = (short)(100 + random.nextInt(9899));
        if(coduriExistente.size() == 0){
            this.codDisciplina = auxCod;
            addCoduri(auxCod);
        }
        else{
            while (verificareExistenta(auxCod)){
                auxCod = (short)(100 + random.nextInt(9899));
            }
            this.codDisciplina = auxCod;
            addCoduri(auxCod);
        }
        this.numeDisciplina = " ";
        this.coefExamne = 0.5;
        this.coefLab = 0.5;
        this.nrCredite = 5;
    }

    public Disciplina(String numeD, double coefE, double coefL, double coefP, double coefPC, double coefPL, double coefPS, double coefPP, short nrC){
        Random random = new Random();
        short auxCod = (short)(100 + random.nextInt(9899));
        if(coduriExistente.size() == 0){
            this.codDisciplina = auxCod;
            addCoduri(auxCod);
        }
        else{
            while (verificareExistenta(auxCod)){
                auxCod = (short)(100 + random.nextInt(9899));
            }
            this.codDisciplina = auxCod;
            addCoduri(auxCod);
        }
        this.numeDisciplina = numeD;
        this.coefExamne = coefE;
        this.coefLab = coefL;
        this.coefProiect = coefP;
        this.coefPrezentaCurs = coefPC;
        this.coefPrezentaLab = coefPL;
        this.coefPrezentaSeminar = coefPS;
        this.coefPrezentaProiect = coefPS;
        this.nrCredite = nrC;
    }

    public double getCoefSeminar() {
        return coefSeminar;
    }

    public static void addCoduri(short nouCod){

        coduriExistente.add(nouCod);
    }

    private static boolean verificareExistenta(short codNou){
        for(int i = 0; i < coduriExistente.size(); i++){
            if(coduriExistente.get(i) == codNou){
                return true;
            }
        }
        return false;
    }

    public short getCodDisciplina(){

        return this.codDisciplina;
    }

    public String getNumeDisciplina(){
        return this.numeDisciplina;
    }

    public double getCoefExamne(){
        return this.coefExamne;
    }

    public double getCoefLab() {
        return coefLab;
    }

    public double getCoefProiect() {
        return coefProiect;
    }

    public double getCoefPrezentaCurs() {
        return coefPrezentaCurs;
    }

    public double getCoefPrezentaLab() {
        return coefPrezentaLab;
    }

    public double getCoefPrezentaSeminar() {
        return coefPrezentaSeminar;
    }

    public double getCoefPrezentaProiect() {
        return coefPrezentaProiect;
    }

    public short getNrCredite() {
        return nrCredite;
    }

    public FisaDisciplinei getFisaDisciplinei() {
        return fisaDisciplinei;
    }

    public void setNumeDisciplina(String numeDisciplina) {
        this.numeDisciplina = numeDisciplina;
    }

    public void setCoefExamne(double coefExamne) {
        this.coefExamne = coefExamne;
    }

    public void setCoefLab(double coefParcurs) {
        this.coefLab = coefParcurs;
    }

    public void setCoefProiect(double coefProiect) {
        this.coefProiect = coefProiect;
    }

    public void setCoefPrezentaCurs(double coefPrezentaCurs) {
        this.coefPrezentaCurs = coefPrezentaCurs;
    }

    public void setCoefPrezentaLab(double coefPrezentaLab) {
        this.coefPrezentaLab = coefPrezentaLab;
    }

    public void setCoefPrezentaSeminar(double coefPrezentaSeminar) {
        this.coefPrezentaSeminar = coefPrezentaSeminar;
    }

    public void setCoefPrezentaProiect(double coefPrezentaProiect) {
        this.coefPrezentaProiect = coefPrezentaProiect;
    }
    public void setNrCredite(short nrCredite) {
        this.nrCredite = nrCredite;
    }

    public void setFisaDisciplinei(FisaDisciplinei fisaDisciplinei) {
        System.out.println("S-a setat disciplina");
        this.fisaDisciplinei = fisaDisciplinei;
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Disciplina){
            Disciplina d = (Disciplina) obj;
            if(d.codDisciplina == this.codDisciplina){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "Cod disciplina: " + this.codDisciplina + " "
                + ((this.numeDisciplina != null) ? ("Nume disciplina: " + this.numeDisciplina) : "Didciplina fara nume!") + " "
                + "Coeficiente examne: " + this.coefExamne + "\n"
                + "Coeficient laborator: " + this.coefLab + "\n"
                + "Coeficient proiect: " + this.coefProiect + "\n"
                + "Coeficient prezenta curs: " + this.coefPrezentaCurs + "\n"
                + "Coeficient prezenta laboerator: " + this.coefPrezentaLab + "\n"
                + "Coeficient prezenta seminar: " + this.coefPrezentaSeminar + "\n"
                + "Coeficient prezenta proiect: " + this.coefPrezentaProiect + "\n"
                + "Numar de credite: " + this.nrCredite + "\n";
    }
}

