package main;

import model.RegularExpresion;
import model.Repository;

import java.util.Scanner;


public class CautareDupaNume implements Comand{
    /**
     *
     */
    public void execute(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti numele de familie");
            String numeFam = scanner.next();
            if(RegularExpresion.RegularExpresionNumePrenume(numeFam) == false){
                System.err.println("Formatul numelui de familie este gresit!");
                return;
            }
            for (int i = 0; i < Repository.getInstance().getStudenti().size(); i++) {
                if(numeFam.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie())){
                    System.out.println(Repository.getInstance().getStudenti().get(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    } // end function execute
}
