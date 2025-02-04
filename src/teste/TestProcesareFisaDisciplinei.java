package teste;

import XMLProcess.ProcesareFisaDisciplinei;
import model.FisaDisciplinei;

import java.util.ArrayList;
import java.util.Optional;


public class TestProcesareFisaDisciplinei {
    public static void main(String[] args) throws Exception{
        //FisaDisciplinei f = ProcesareFisaDisciplinei.getFisaDisciplina(ProcesareFisaDisciplinei.FILENAME);
        Optional<ArrayList<FisaDisciplinei>> box = ProcesareFisaDisciplinei.getFiseDiscipline();
        if(box.isEmpty() == true){
            System.err.println("Nu s-au incarcat disciplinele");
        }
        else{
            ArrayList<FisaDisciplinei> listaFiseDiscipline = box.get();
            System.out.println(listaFiseDiscipline);
        }
    }//end main
}
