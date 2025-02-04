package main;

import model.Files;
import model.RegularExpresion;
import model.Repository;
import model.Student;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class ModificareNume implements Comand{

    public void execute(){
        Student student = null;
        String numeNou = "";
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti noul nume de familie: ");
            numeNou = scanner.next();
            if(RegularExpresion.RegularExpresionNumePrenume(numeNou) == false){
                System.err.println("Formatul numelui introdus este gresit!");
                return;
            }
            System.out.println("Introduceti numarul matricol al studentului al carui nume va fi modificat: ");
            String nrMat = scanner.next();
            for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                if(nrMat.equals(Repository.getInstance().getStudenti().get(i).getNrMatricol())){
                    student = Repository.getInstance().getStudenti().get(i);
                    break;
                }
            }// end for parcurgere lista studenti din Repository
            if(student == null){
                System.err.println("Studentul nu a fost gasit!");
                return;
            }
            student.setNumeFamilie(numeNou);
            File f = new File(Files.FILE_STUDENTI);
            if(f.canWrite()){
                FileWriter f2 = new FileWriter(f);
                for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                    String pren = "";
                    for(int j = 0; j < Repository.getInstance().getStudenti().get(i).getPrenume().size(); j++){
                        pren = pren + Repository.getInstance().getStudenti().get(i).getPrenume().get(j) + " ";
                    }
                    pren = pren.trim();
                    String dataN = Repository.getInstance().getStudenti().get(i).getDataNAstere().getZi() + "/" + Repository.getInstance().getStudenti().get(i).getDataNAstere().getLuna().getNrOrdine() + "/" + Repository.getInstance().getStudenti().get(i).getDataNAstere().getAn();
                    String dataInmat = Repository.getInstance().getStudenti().get(i).getDataInmatriculare().getZi() + "/" + Repository.getInstance().getStudenti().get(i).getDataInmatriculare().getLuna().getNrOrdine() + "/" + Repository.getInstance().getStudenti().get(i).getDataInmatriculare().getAn();
                    String line = Repository.getInstance().getStudenti().get(i).getNrMatricol() + ";" + Repository.getInstance().getStudenti().get(i).getNumeFamilie() + ";" + pren + ";" + dataN + ";" + dataInmat + ((i == Repository.getInstance().getStudenti().size() - 1 ) ? "" : "\n");
                    f2.write(line);
                }
                f2.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }//end try - catch
    }// end function
}//end class
