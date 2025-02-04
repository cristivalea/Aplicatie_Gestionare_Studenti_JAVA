package teste;

import model.Disciplina;

public class TestDisciplina {
    public static void main(String[] args){
        Disciplina d = new Disciplina("100;Analiza matematica;0,6;0,4;0;0;0;0;0;5");
        System.out.println(d);
    }
}
