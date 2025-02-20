package teste;

import model.Disciplina;
import model.Nota;
import model.Repository;
import model.Student;

import java.io.IOException;
import java.util.logging.Logger;

public class Main2 {
    public static final Logger logger = Logger.getAnonymousLogger();
    public static void main(String[] args) throws Exception{
        /*model.Disciplina d1 = new model.Disciplina();
        model.Disciplina d2 = new model.Disciplina((short)123, "Programare", 0.5, 0.5, (short)6);
        model.Disciplina d3 = new model.Disciplina("133;Algoritmi;0,6;0,4;4");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        model.Data d = new model.Data("12/3/2024");
        System.out.println(d);
        model.Nota n1 = new model.Nota("CTI22105;100;7;8;3/6/2024");
        System.out.println(n1);
        model.Student s1= new model.Student("CTI22105;Popescu;Daniel Ionel Aurel Octavian;22/5/1982;17/7/2001");
        System.out.println(s1);*/

       try {
            for(Disciplina d:Repository.getInstance().getDiscipline())
                System.out.println(d);
            System.out.println("--------------------------");
            for(Student student:Repository.getInstance().getStudenti())
                System.out.println(student);
            System.out.println("--------------------------");
            for(Nota n: Repository.getInstance().getNote())
                System.out.println(n);
        } catch (IOException e) {
             e.printStackTrace();
        }
       //System.out.println(Repository.getInstance().getStudenti());
       //Student s2 = new Student("CTI022345;Mihai;Ion Nicu;21/3/1978;23/7/2021");
      // Repository.getInstance().adaugaStudent(s2);
    }
}