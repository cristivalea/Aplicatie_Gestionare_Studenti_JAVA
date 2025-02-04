package main;

import main.Comand;
import model.RegularExpresion;
import model.Repository;
import model.Student;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StergereStudentDupaNumePrenume implements Comand {

    public void execute() {
        Student student = null;
        boolean c1 = false;
        boolean c2 = false;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introducerti numele: ");
            String nume1 = scanner.next();
            if(RegularExpresion.RegularExpresionNumePrenume(nume1) == false){
                System.err.println("Formatul numelui de familie este gresit!");
                return;
            }
            System.out.println("Introduceti numarul de prenume: ");
            int nrPrenume = scanner.nextInt();
            Set<String> prenume1 = new TreeSet<String>();
            for (int i = 0; i < nrPrenume; i++) {
                System.out.println("Introduceti prenumele " + i + ": ");
                String auxPren = scanner.next();
                if(RegularExpresion.RegularExpresionNumePrenume(auxPren) == false){
                    System.err.println("Formatul prenumelui " + i + " este gresit!");
                    return;
                }
                prenume1.add(auxPren);
            }// end for prenume

            for (int j = 0; j < Repository.getInstance().getStudenti().size(); j++) {
                if (nume1.equals(Repository.getInstance().getStudenti().get(j).getNumeFamilie())) {
                    c1 = true;
                }
                Set<String> prenume2 = new TreeSet<String>();
                prenume2.addAll(Repository.getInstance().getStudenti().get(j).getPrenume());
                c2 = prenume1.equals(prenume2);
                if(c1 && c2) {
                    student = Repository.getInstance().getStudenti().get(j);
                    break;
                }
            }//end for lista studenti
            if(student == null){
                System.err.println("Studentul nu a fost gasit");
                return;
            }
            if(student.getNote().size() == 0){
                Repository.getInstance().stergeStudent(student);
            }
            else{
                System.err.println("Studentul nu poate fi sters deoarece are note");
            }
        }catch (Exception e){
            e.printStackTrace();
        } // end try - catch
    } // end function execute
}// end class
