package main;

import exceptii.FormatException;
import model.Data;
import model.RegularExpresion;
import model.Repository;

import java.util.Scanner;

public class CautareNoteStudent implements Comand{
    public void execute() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele studentului: ");
        String nume = scanner.next();
        if(!RegularExpresion.RegularExpresionNumePrenume(nume)){
            FormatException e = new FormatException("Format nume gresit", 3);
            throw e;
        }
        System.out.println("Introduceti numarul de prenume: ");
        int nr_prenume = scanner.nextInt();
        String prenume = null;
        for(int i = 0; i < nr_prenume; i++) {
            System.out.println("Introduceti prenumele ");
            prenume += scanner.next();
            if(!RegularExpresion.RegularExpresionNumePrenume(nume)){
                FormatException e = new FormatException("Format prenume gresit", 3);
                throw e;
            }
        }
        System.out.println("Introducetii data nasterii:");
        System.out.println("Zi: ");
        int zi = scanner.nextInt();
        System.out.println("Luna: ");
        int luna = scanner.nextInt();
        System.out.println("An: ");
        int an = scanner.nextInt();
        Data data_nastere = new Data(zi, luna, an);
        for(int i = 0; i < Repository.getInstance().getStudenti().size(); i++){
            boolean c1 = nume.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie());
            boolean c2 = prenume.equals(Repository.getInstance().getStudenti().get(i).getPrenume());
            boolean c3 = data_nastere.equals(Repository.getInstance().getStudenti().get(i).getDataNAstere());
            if(c1 && c2 && c3){
                System.out.println(nume + " " + prenume + " " + Repository.getInstance().getStudenti().get(i).getNote());
                break;
            }
        }
    }
}
