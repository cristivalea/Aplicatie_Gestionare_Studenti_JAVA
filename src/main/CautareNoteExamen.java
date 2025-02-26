package main;

import model.Data;
import model.Repository;

import java.util.Scanner;

public class CautareNoteExamen implements Comand{
    public void execute() throws Exception{
        Scanner scaner = new Scanner(System.in);
        System.out.println("Introduceti codul disciplinei: ");
        Short codDisciplina = scaner.nextShort();
        System.out.println("Introduceti data examenului: ");
        System.out.println("Zi: ");
        int zi = scaner.nextInt();
        System.out.println("Luna: ");
        int luna = scaner.nextInt();
        System.out.println("An: ");
        int an = scaner.nextInt();
        Data dataExamen = new Data(zi, luna, an);
        for(int i = 0; i < Repository.getInstance().getNote().size(); i++){
            boolean c1 = codDisciplina == Repository.getInstance().getNote().get(i).getCodDisciplina();
            boolean c2 = dataExamen.equals(Repository.getInstance().getNote().get(i).getDataExamen());
            if(c1 && c2){
                System.out.println(Repository.getInstance().getNote().get(i).repr());
                break;
            }
        }
    }
}
