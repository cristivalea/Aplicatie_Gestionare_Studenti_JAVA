package teste;

import model.NotaAR;
import model.NotaCalificativ;

public class MainNota {
    public static void main(String[] args){
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
