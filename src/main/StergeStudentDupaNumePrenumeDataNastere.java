package main;

import main.Comand;
import model.Data;
import model.RegularExpresion;
import model.Repository;
import model.Student;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StergeStudentDupaNumePrenumeDataNastere implements Comand {

    public void execute(){
        Student student = null;
        boolean c1 = true;
        boolean c2 = true;
        boolean c3 = true;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti numele de familie: ");
            String numeFam = scanner.next();
            if(RegularExpresion.RegularExpresionNumePrenume(numeFam) == false){
                System.err.println("Formatul numelui de familie este gresit!");
                return;
            }
            System.out.println("Introduceti numarul de prenume: ");
            int nrPrenume = scanner.nextInt();
            Set<String> prenume1 = new TreeSet<String>();
            for(int i = 0; i < nrPrenume; i++){
                System.out.println("Introduceti prenumele " + i + ": ");
                String auxPren = scanner.next();
                if(RegularExpresion.RegularExpresionNumePrenume(auxPren) == false){
                    System.err.println("Formatul prenumelui este gresit!");
                    return;
                }
                prenume1.add(auxPren);
            }
            System.out.println("Introduceti data nasterii: ");
            System.out.println("Introduceti ziua nasterii: ");
            int ziNastere = scanner.nextInt();
            System.out.println("Introdceti luna nasterii: ");
            int lunaNasterii = scanner.nextInt();
            System.out.println("Introduceti anul nasterii");
            int anNastere = scanner.nextInt();
            Data data = new Data(ziNastere,lunaNasterii,anNastere);
            for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                if(numeFam.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie())){
                    c1 = true;
                }
                Set<String> prenume2 = new TreeSet<String>();
                prenume2.addAll(Repository.getInstance().getStudenti().get(i).getPrenume());
                c2 = prenume1.equals(prenume2);
                c3 = data.equals(Repository.getInstance().getStudenti().get(i).getDataNAstere());
                if(c1 && c2 && c3) {
                    student = Repository.getInstance().getStudenti().get(i);
                    break;
                }
            } // end for parcurgere lista studenti
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
