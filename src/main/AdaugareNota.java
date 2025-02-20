package main;

import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class AdaugareNota implements Comand{
    private Student student = null;
    private Disciplina disciplina = null;
    public void execute() throws Exception{
            LocalDate date_curent = LocalDate.now();
            Data data = new Data(date_curent.getDayOfMonth(), date_curent.getMonthValue(), date_curent.getYear());
            System.out.println("Introduceti numele: ");
            Scanner scanner = new Scanner(System.in);
            String nume = scanner.next();
            if(RegularExpresion.RegularExpresionNumePrenume(nume) == false){
                System.err.println("Formatul numelui de familie este gresit!");
                return;
            }
            System.out.println("Introduceti codul disciplinei la care se adauga nota: ");
            String disciplina = scanner.next();
            for (int i = 0; i < Repository.getInstance().getStudenti().size(); i++) {
                if(nume.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie())){
                    this.student = Repository.getInstance().getStudenti().get(i);
                    break;
                }
            }
            if(this.student == null){
                Exception e = new Exception("Studentul nu a fost gasit");
                throw e;
            }
            for (int j = 0; j < Repository.getInstance().getDiscipline().size(); j++){
                if(disciplina.equals(Repository.getInstance().getDiscipline().get(j).getCodDisciplina())){
                    this.disciplina = Repository.getInstance().getDiscipline().get(j);
                    break;
                }
            }
            if(this.disciplina == null){
                Exception e = new Exception("Disciplina nu a fost gasita");
                throw e;
            }
            System.out.println("Ce fel de nota doriti sa introduceti? ");
            System.out.println("1. Nota Numerica");
            System.out.println("2. Calificativ");
            System.out.println("3. Calificativ de tipul ADMIS/RESPINS");
            System.out.println("Introduceti optiunea: ");
            int optiune = scanner.nextInt();
            Nota nota = null;
            switch (optiune){
                case 1:
                {
                    System.out.println("Introduceti nota numeica astfel: ");
                    System.out.println("Introduceti nota din examen: ");
                    int notaE = scanner.nextInt();
                    System.out.println("Introduceti nota din laborator: ");
                    int notaL = scanner.nextInt();
                    System.out.println("Introduceti nota de la proiect: ");
                    int notaP = scanner.nextInt();
                    System.out.println("Introduceti nota de la seminar: ");
                    int notaS = scanner.nextInt();
                    nota = new NotaNumerica(this.disciplina, this.student, notaE, notaL, notaP, notaS, data);
                    break;
                }
                case 2:
                {
                    System.out.println("Introduceti calificativul: ");
                    String calificativ = scanner.next();
                    nota = new NotaCalificativ(this.student.getNrMatricol(), this.disciplina.getCodDisciplina(), data, calificativ);
                    break;
                }
                case 3:
                {
                    System.out.println("Introduceti calificativul (ADMIS/RESPINS): ");
                    String calificativ = scanner.next();
                    nota = new NotaAR(this.student.getNrMatricol(), this.disciplina.getCodDisciplina(), data, calificativ);
                    break;
                }
            } // end switch
        Repository.getInstance().adaugareNota(this.student, nota);
    } // end execute
}
