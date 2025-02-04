package main;

import model.Files;
import model.RegularExpresion;
import model.Repository;
import model.Student;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ModificarePrenume implements Comand{

    public void execute(){
        Student student = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti numarul de prenume: ");
            int nrPren = scanner.nextInt();
            ArrayList<String> prenumeNoi = new ArrayList<String>();
            for(int i = 0; i < nrPren; i++){
                System.out.println("Introduceti prenumele " + i + " : ");
                String auxPren = scanner.next();
                if(RegularExpresion.RegularExpresionNumePrenume(auxPren) == false){
                    System.err.println("Formatul prenumelui introdus este gresit!");
                    return;
                }
                prenumeNoi.add(auxPren);
            }
            System.out.println("Introduceti numarul matricol al studentului al carui prenume va fi schimbat: ");
            String nrMat = scanner.next();
            if(RegularExpresion.RegularExpresionNrMatricol(nrMat) == false){
                System.err.println("Formatul numarului matricol este gresit!");
                return;
            }
            for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                if(nrMat.equals(Repository.getInstance().getStudenti().get(i).getNrMatricol())){
                    student = Repository.getInstance().getStudenti().get(i);
                    break;
                }
            }// end for parcuregere lista studenti Repository
            if(student == null){
                System.err.println("Studentul nu a fost gasit!");
                return;
            }
            student.setPrenume(prenumeNoi);
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
        }
    }// end function
}// end class
