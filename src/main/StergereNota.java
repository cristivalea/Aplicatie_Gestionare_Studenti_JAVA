package main;

import model.Nota;
import model.Repository;

import java.util.Scanner;

public class StergereNota implements Comand{
    public void execute() throws Exception{
        Scanner scaner = new Scanner(System.in);
        System.out.println("Introduceti codul disciplinei: ");
        Short codDisciplina = scaner.nextShort();
        System.out.println("Introduceti numarul matricol: ");
        String numar_matricol = scaner.next();
        int index = -1;
        Nota nota = null;
        for(int i = 0; i < Repository.getInstance().getNote().size(); i++){
            if(Repository.getInstance().getNote().get(i).getCodDisciplina() == codDisciplina && Repository.getInstance().getNote().get(i).getStudent().getNrMatricol().equals(numar_matricol)){
                index = i;
                nota = Repository.getInstance().getNote().get(i);
                break;
            }
        }
        if(nota == null){
            System.err.println("Nu s-a gasit nota");
            return;
        }
        Repository.getInstance().stergeNota(nota);
    }
}
