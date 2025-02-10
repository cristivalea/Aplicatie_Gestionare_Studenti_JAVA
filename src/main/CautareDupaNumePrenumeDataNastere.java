package main;

import model.Data;
import model.RegularExpresion;
import model.Repository;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CautareDupaNumePrenumeDataNastere implements Comand{

    /**
     *
     */
    public void execute(){
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
            Set<String> prenume1 = new TreeSet<String>();
            System.out.println("Introduceti numarul de prenume");
            int nrPrenume = scanner.nextInt();
            for(int i = 0; i < nrPrenume; i++){
                System.out.println("Introduceti prenumele " + i + " : ");
                String auxPren = scanner.next();
                if(RegularExpresion.RegularExpresionNumePrenume(auxPren) == false){
                    System.err.println("Formatul prenumelui este gresit!");
                    return;
                }
                prenume1.add(auxPren);
            }// end for prenume
            System.out.println("Introduceti data nasterii: ");
            System.out.println("Introduceti ziua nasterii: ");
            int ziNastere = scanner.nextInt();
            System.out.println("Introduceti luna nastere: ");
            int lunaNastere = scanner.nextInt();
            System.out.println("Introduceti an nastere: ");
            int anNastere = scanner.nextInt();
            Data data = new Data(ziNastere, lunaNastere, anNastere);
            for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                c1 = numeFam.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie());
                Set<String> prenume2 = new TreeSet<String>();
                prenume2.addAll(Repository.getInstance().getStudenti().get(i).getPrenume());
                c2 = prenume2.equals(prenume1);
                c3 = data.equals(Repository.getInstance().getStudenti().get(i).getDataNAstere());
                if(c1 && c2 && c3){
                    System.out.println(Repository.getInstance().getStudenti().get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }// end function execute
}// end class
