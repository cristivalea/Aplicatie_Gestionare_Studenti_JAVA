package main;

import model.Repository;

import java.util.Scanner;

public class CautareNoteDisciplina implements Comand{
    public void execute() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti codul disciplinei: ");
        short codDisciplina = scanner.nextShort();
        for(int i = 0; i < Repository.getInstance().getDiscipline().size(); i++){
            if(codDisciplina == Repository.getInstance().getNote().get(i).getCodDisciplina()){
                System.out.println(codDisciplina + " " + Repository.getInstance().getNote().get(i).getNotaFinala());
            }
        }
    }
}
