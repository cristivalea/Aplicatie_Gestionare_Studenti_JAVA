package main;

import main.Comand;
import model.RegularExpresion;
import model.Repository;
import model.Student;

import java.util.Scanner;

public class StergereStudentDupaNrMatricol implements Comand {
     public void execute() {
          Student student = null;
          int index = -1;
          try {
               Scanner scanner = new Scanner(System.in);
               System.out.println("Introduceti numarul matricol al studentului: ");
               String input= scanner.next();
               if(RegularExpresion.RegularExpresionNrMatricol(input) == false){
                    System.err.println("Numar amtricol gresit");
                    return;
               }
               for (int i = 0; i < Repository.getInstance().getStudenti().size(); i++) {
                    if (Repository.getInstance().getStudenti().get(i).getNrMatricol().equals(input)) {
                         student = Repository.getInstance().getStudenti().get(i);
                         index = i;
                         break;
                    }
               }
               if(student == null){
                    System.err.println("Studentul nu a fost gasit");
                    return;
               }
               if (student.getNote().size() == 0) {
                    Repository.getInstance().stergeStudent(student);
               }
               else{
                    System.err.println("Studentul nu poate fi sters deoareca are note");
               }
          } catch (Exception e) {
               e.printStackTrace();
          } // end try - catch
     }//end function
}// end class
