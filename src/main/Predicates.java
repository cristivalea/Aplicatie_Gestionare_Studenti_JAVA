package main;

import model.Repository;
import model.Student;
import teste.Main2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface Predicates {

    public final Predicate<Student> studentExistent=(Student student)->{
        try{
            for(Student s : Repository.getInstance().getStudenti()){
                if(student.getNumeFamilie().equals(s.getNumeFamilie()) && student.getPrenume().equals(s.getPrenume()) && student.getDataNAstere().equals(s.getDataNAstere()) && student.getDataInmatriculare().equals(s.getDataInmatriculare())){
                    return true;
                }
            }
        }catch (Exception e){
            Main2.logger.info(e.getMessage());
        }
        return false;
    }; //end function

    public final BiPredicate<Student, Student> studentiIdentici=(Student a, Student b) -> {
        boolean c1 = a.getNumeFamilie().equals(b.getNumeFamilie());
        boolean c2 = a.getPrenume().equals(b.getPrenume());
        boolean c3 = a.getDataInmatriculare().equals(b.getDataInmatriculare());
        boolean c4 = a.getDataNAstere().equals(b.getDataNAstere());
        return c1 && c2 && c3 && c4;
    }; // enf function Bipredicat
}
