package teste;

import main.CautareNoteStudent;
import model.*;

public class MainNota {
    public static void main2(String[] args) {
        try {
            NotaCalificativ nc1 = new NotaCalificativ("C;CTI022105;100;FOARTE BINE;26/6/2024");
            NotaCalificativ nc2 = new NotaCalificativ("C;CTI022106;101;BINE;26/6/2024");
            NotaCalificativ nc3 = new NotaCalificativ("C;CTI022107;102;SUFICIENT;26/6/2024");
            NotaCalificativ nc4 = new NotaCalificativ("C;CTI022108;103;INSUFICIENT;26/6/2024");
            NotaCalificativ nc5 = new NotaCalificativ("C;CTI022109;104;EXCELENT;26/6/2024");
            System.out.println(nc1);
            System.out.println(nc2);
            System.out.println(nc3);
            System.out.println(nc4);
            System.out.println(nc5);
            NotaAR nar1 = new NotaAR("A;CTI022105;100;ADMIS;26/6/2024");
            NotaAR nar2 = new NotaAR("A;CTI022115;110;RESPINS;26/6/2024");
            System.out.println(nar1);
            System.out.println(nar2);
            Disciplina d = new Disciplina("103;Programarea calculatoarelor;0,5;0,5;0;0;0;0;0;0;6");
            NotaNumerica nn = new NotaNumerica("N;CTI022106;103;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024");
            System.out.println(nn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        try {
            Repository.loadNote();
            for (Nota n : Repository.note)
                System.out.println(Repository.note);
            CautareNoteStudent c =new CautareNoteStudent();
            c.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

//    public static void main(String[] args){
//        try {
//            ArrayList<Nota> note = new ArrayList<Nota>();
//            NotaCalificativ nc1 = new NotaCalificativ("C;CTI022105;100;FOARTE BINE;26/6/2024");
//            NotaCalificativ nc2 = new NotaCalificativ("C;CTI022106;101;BINE;26/6/2024");
//            NotaCalificativ nc3 = new NotaCalificativ("C;CTI022107;102;SUFICIENT;26/6/2024");
//            NotaCalificativ nc4 = new NotaCalificativ("C;CTI022108;103;INSUFICIENT;26/6/2024");
//            NotaCalificativ nc5 = new NotaCalificativ("C;CTI022109;104;EXCELENT;26/6/2024");
//            System.out.println(nc1);
//            System.out.println(nc2);
//            System.out.println(nc3);
//            System.out.println(nc4);
//            System.out.println(nc5);
//            note.add(nc1);
//            note.add(nc2);
//            note.add(nc3);
//            note.add(nc4);
//            note.add(nc5);
//            NotaAR nar1 = new NotaAR("A;CTI022105;100;ADMIS;26/6/2024");
//            NotaAR nar2 = new NotaAR("A;CTI022115;110;RESPINS;26/6/2024");
//            System.out.println(nar1);
//            System.out.println(nar2);
//            note.add(nar1);
//            note.add(nar2);
//            Disciplina d = new Disciplina("103;Programarea calculatoarelor;0,5;0,5;0;0;0;0;0;0;6");
//            NotaNumerica nn = new NotaNumerica("N;CTI022106;103;9;8;7;6;0,6;0,7;0,5;0,4;26/6/2024");
//            System.out.println(nn);
//            note.add(nn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
