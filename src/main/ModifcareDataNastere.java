package main;

import model.Data;
import model.Files;
import model.Repository;
import model.Student;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ModifcareDataNastere implements Comand{

    public void execute(){
        Student student = null;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti noua data de nastere: ");
            System.out.println("Introduceti ziua: ");
            int zi = scanner.nextInt();
            System.out.println("Introduceti luna: ");
            int luna = scanner.nextInt();
            System.out.println("Introduceti anul: ");
            int an = scanner.nextInt();
            Data data = new Data(zi, luna, an);
            System.out.println("Introduceti numarul matricol al carui student va fi schimbata data nasterii: ");
            String nrMat = scanner.next();
            for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
                if(nrMat.equals(Repository.getInstance().getStudenti().get(i).getNrMatricol())){
                    student = Repository.getInstance().getStudenti().get(i);
                    break;
                }
            }
            if(student == null){
                System.err.println("Studentul nu s fost gasit!");
                return;
            }
            if(data == null){
                System.err.println("Nu s-s creat noua data");
                return;
            }
            student.setDataNAstere(data);
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
