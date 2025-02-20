package teste;

import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Main2 {
    public static final Logger logger = Logger.getAnonymousLogger();

    public static void adaugareNota2(Student s, Nota nota) throws IOException {
        File f = new File(Files.FILE_NOTE);
        FileWriter f2 = new FileWriter(f, true);
        if (f.canWrite()) {
            if (nota instanceof NotaNumerica) {
                //N;CTI022106;101;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024
                NotaNumerica n = (NotaNumerica) nota;
                String str = "N;" + s.getNrMatricol() + ";" + n.getCodDisciplina() + ";" + n.getNotaExamen() + ";"
                        + n.getNotalaborator() + ";" + n.getNotaProiect() + ";" + n.getNotaSeminar()
                        + n.getDisciplina().getCoefExamne() + ";" + n.getDisciplina().getCoefLab() + ";"
                        + n.getDisciplina().getCoefProiect() + ";" + n.getDisciplina().getCoefSeminar() + ";"
                        + n.getDataExamen().getZi() + "/" + n.getDataExamen().getLuna() + "/" + n.getDataExamen().getAn();
                f2.write(str);
                f2.close();
            }
            if(nota instanceof NotaCalificativ){
                NotaCalificativ n = (NotaCalificativ)nota;
                //C;CTI022105;100;FOARTE BINE;26/6/2024
                String str = "C;" + s.getNrMatricol() + ";" + n.getCodDisciplina() + ";" + n.valoarea + ";"
                        + n.getDataExamen().getZi() + "/" + n.getDataExamen().getLuna() + "/" + n.getDataExamen().getAn();
                f2.write(str);
                f2.close();
            }

            if(nota instanceof NotaAR){
                NotaAR n = (NotaAR) nota;
                //A;CTI022107;102;ADMIS;26/6/2024
                String str = "\nC;" + s.getNrMatricol() + ";" + n.getCodDisciplina() + ";" + n.valoare + ";"
                        + n.getDataExamen().getZi() + "/" + n.getDataExamen().getLuna() + "/" + n.getDataExamen().getAn();
                f2.write(str);
                f2.close();
            }
        }
    }
    public static void main(String[] args) throws Exception {
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

//       try {
//            for(Disciplina d:Repository.getInstance().getDiscipline())
//                System.out.println(d);
//            System.out.println("--------------------------");
//            for(Student student:Repository.getInstance().getStudenti())
//                System.out.println(student);
//            System.out.println("--------------------------");
//            for(Nota n: Repository.getInstance().getNote())
//                System.out.println(n);
//        } catch (IOException e) {
//             e.printStackTrace();
//        }
        //System.out.println(Repository.getInstance().getStudenti());
        //Student s2 = new Student("CTI022345;Mihai;Ion Nicu;21/3/1978;23/7/2021");
        // Repository.getInstance().adaugaStudent(s2);
        Disciplina d = new Disciplina("104;Programarea calculatoarelor;0,5;0,5;0;0;0;0;0;0;6");
        NotaAR n = new NotaAR("A;CTI023137;104;ADMIS;21/6/2024");
        n.setDisciplina(d);
        Student s = new Student("CTI023137;Stan;Ramona;5/11/1993;21/7/2023");
        adaugareNota2(s, n);
    }

}