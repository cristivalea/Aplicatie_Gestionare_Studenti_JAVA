package main;

import model.*;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ModificareNota implements Comand{
    public void execute() throws Exception{
        Scanner scaner = new Scanner(System.in);
        System.out.println("Introduceti numarul matricol al studentului: ");
        String nrMatricol = scaner.next();
        System.out.println("Introduceti codul disciplinei: ");
        Short codDisciplina = scaner.nextShort();
        System.out.println("Introduceti tipul notei ce va fi modificata: ");
        System.out.println("1. Numerica");
        System.out.println("2. Calificativ");
        System.out.println("3. Calificativ A/R");
        System.out.println("Introduceti optiunea: ");
        int optiune = scaner.nextInt();
        Nota nota = null;
        for(int i = 0; i < Repository.getInstance().getNote().size(); i++){
            boolean c1 = nrMatricol.equals(Repository.getInstance().getNote().get(i).getStudent().getNrMatricol());
            boolean c2 = codDisciplina == Repository.getInstance().getNote().get(i).getCodDisciplina();
            if(c1 && c2){
                nota = Repository.getInstance().getNote().get(i);
                break;
            }
        }
        File f = new File(Files.FILE_NOTE);
        switch (optiune){
            case 1:
            {
                if(nota instanceof NotaNumerica) {
                    NotaNumerica nota_numerica = (NotaNumerica) nota;
                    System.out.println("Care nota se va modifica?");
                    System.out.println("1. Nota examen");
                    System.out.println("2. Nota laborator");
                    System.out.println("3. Nota Seminar");
                    System.out.println("4. Nota Proiect");
                    System.out.println("5. Toate notele");
                    System.out.println("Introduceti optiunea dorita: ");
                    int optiune_nota_numerica = scaner.nextInt();
                    switch (optiune_nota_numerica) {
                        case 1: {
                            System.out.println("Introduceti nota de la examen: ");
                            int notaExamen = scaner.nextInt();
                            nota_numerica.setNotaExamen(notaExamen);
                            if (f.canWrite()) {
                                FileWriter f2 = new FileWriter(f);
                                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                                for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                                    String linie = "N;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                            + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + notaExamen + nota_numerica.getNotaSeminar()
                                            + ";" + nota_numerica.getNotalaborator() + ";" + nota_numerica.getNotaProiect() + ";" + nota_numerica.getDisciplina().getCoefPrezentaCurs()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaLab() + ";" + nota_numerica.getDisciplina().getCoefPrezentaSeminar()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaProiect() + ";" + nota_numerica.getDataExamen()
                                            + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                                    f2.write(linie);
                                }
                                f2.close();
                            }
                            break;
                        } // end case 1 nota examen
                        case 2: {
                            System.out.println("Introduceti nota de la laborator: ");
                            int notaLaborator = scaner.nextInt();
                            nota_numerica.setNotalaborator(notaLaborator);
                            if (f.canWrite()) {
                                FileWriter f2 = new FileWriter(f);
                                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                                for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                                    String linie = "N;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                            + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + nota_numerica.getNotaExamen() + nota_numerica.getNotaSeminar()
                                            + ";" + notaLaborator + ";" + nota_numerica.getNotaProiect() + ";" + nota_numerica.getDisciplina().getCoefPrezentaCurs()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaLab() + ";" + nota_numerica.getDisciplina().getCoefPrezentaSeminar()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaProiect() + ";" + nota_numerica.getDataExamen()
                                            + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                                    f2.write(linie);
                                }
                                f2.close();
                            }
                            break;
                        } // end case 2 nota laborator
                        case 3: {
                            System.out.println("Introduceti nota de la seminar: ");
                            int notaSeminar = scaner.nextInt();
                            nota_numerica.setNotaSeminar(notaSeminar);
                            if (f.canWrite()) {
                                FileWriter f2 = new FileWriter(f);
                                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                                for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                                    String linie = "N;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                            + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + nota_numerica.getNotaExamen() + ";" + notaSeminar
                                            + ";" + nota_numerica.getNotalaborator() + ";" + nota_numerica.getNotaProiect() + ";" + nota_numerica.getDisciplina().getCoefPrezentaCurs()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaLab() + ";" + nota_numerica.getDisciplina().getCoefPrezentaSeminar()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaProiect() + ";" + nota_numerica.getDataExamen()
                                            + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                                    f2.write(linie);
                                }
                                f2.close();
                            }
                            break;
                        }//end case 3 nota seminar
                        case 4: {
                            System.out.println("Introduceti nota de la proiect: ");
                            int notaProiect = scaner.nextInt();
                            nota_numerica.setNotaProiect(notaProiect);
                            if (f.canWrite()) {
                                FileWriter f2 = new FileWriter(f);
                                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                                for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                                    String linie = "N;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                            + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + nota_numerica.getNotaExamen() + nota_numerica.getNotaSeminar()
                                            + ";" + nota_numerica.getNotalaborator() + ";" + notaProiect + ";" + nota_numerica.getDisciplina().getCoefPrezentaCurs()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaLab() + ";" + nota_numerica.getDisciplina().getCoefPrezentaSeminar()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaProiect() + ";" + nota_numerica.getDataExamen()
                                            + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                                    f2.write(linie);
                                }
                                f2.close();
                            }
                            break;
                        } // end case 4 nota proiect
                        case 5: {
                            System.out.println("Introduceti nota de la examen: ");
                            int notaE = scaner.nextInt();
                            nota_numerica.setNotaExamen(notaE);
                            System.out.println("Introduceti nota de la laborator: ");
                            int notaL = scaner.nextInt();
                            nota_numerica.setNotalaborator(notaL);
                            System.out.println("Introduceti nota de la seminar: ");
                            int notaS = scaner.nextInt();
                            nota_numerica.setNotaSeminar(notaS);
                            System.out.println("Introduceti nota de la proiect: ");
                            int notaP = scaner.nextInt();
                            nota_numerica.setNotaProiect(notaP);
                            if (f.canWrite()) {
                                FileWriter f2 = new FileWriter(f);
                                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                                for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                                    String linie = "N;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                            + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + notaE + notaS
                                            + ";" + notaL + ";" + notaP + ";" + nota_numerica.getDisciplina().getCoefPrezentaCurs()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaLab() + ";" + nota_numerica.getDisciplina().getCoefPrezentaSeminar()
                                            + ";" + nota_numerica.getDisciplina().getCoefPrezentaProiect() + ";" + nota_numerica.getDataExamen()
                                            + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                                    f2.write(linie);
                                }
                                f2.close();
                            }
                            break;
                        } // end case 5 modificarea tuturor notelor
                    }
                }
                break;
            } //end case oprtiune nota nuemrica
            case 2:
            {
                if(nota instanceof NotaCalificativ) {
                    NotaCalificativ nota_calificativ = (NotaCalificativ) nota;
                    System.out.println("Introduceti calificativul: ");
                    String calificativ = scaner.next();
                    if (f.canWrite()) {
                        FileWriter f2 = new FileWriter(f);
                        //C;CTI022105;100;FOARTE BINE;26/6/2024
                        for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                            String linie = "C;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                    + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + calificativ + ";" + nota_calificativ.getDataExamen()
                                    + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                            f2.write(linie);
                        }
                        f2.close();
                    }
                }
                    break;
            } // end case nota calificativ
            case 3:
            {
                if(nota instanceof NotaAR) {
                    NotaAR nota_calificativ = (NotaAR) nota;
                    System.out.println("Introduceti calificativul (ADMIS/RESPINS): ");
                    String calificativ = scaner.next();
                    if (f.canWrite()) {
                        FileWriter f2 = new FileWriter(f);
                        //A;CTI022105;100;ADMIS;26/6/2024
                        for (int i = 0; i < Repository.getInstance().getNote().size(); i++) {
                            String linie = "C;" + Repository.getInstance().getNote().get(i).getStudent().getNrMatricol() + ";"
                                    + Repository.getInstance().getNote().get(i).getCodDisciplina() + ";" + calificativ + ";" + nota_calificativ.getDataExamen()
                                    + ((i == Repository.getInstance().getNote().size() - 1) ? "" : "\n");
                            f2.write(linie);
                        }
                        f2.close();
                    }
                }
                break;
            } //end case calificativ ADMIS/RESPINS
        } // end switch
    } //end execute
} // end class
