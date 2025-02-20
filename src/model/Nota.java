package model;

import java.util.Optional;

public abstract class Nota {
    protected Student student;
    protected String codStudent;
    protected Disciplina disciplina;
    protected int codDisciplina;
    protected Data dataExamen;
    protected boolean promovat = false;

    /**
     *
     * @param codS
     * @param codD
     * @param dataE
     */
    public Nota(String codS, int codD, Data dataE) throws Exception{
        this.codStudent = codS;

//        ArrayList<Student> listaStudenti = Repository.getInstance().getStudenti();
//        for(Student s : listaStudenti){
//            if(s.getNrMatricol().equals(codS)){
//                this.student = s;
//                break;
//            }
//        }

        this.codDisciplina = codD;
//        ArrayList<Disciplina> listaDiscipline = Repository.getInstance().getDiscipline();
//        for(Disciplina d : listaDiscipline){
//            if(d.getCodDisciplina() == codD){
//                this.disciplina = d;
//                break;
//            }
//        }
        this.dataExamen = dataE;
    }

    /**
     *
     * @param s
     * @param d
     * @param dataEx
     */
    public Nota(Student s, Disciplina d, Data dataEx){
        this.student = s;
        this.disciplina = d;
        this.dataExamen = dataEx;

    }

    public Nota() {

    }

    /**
     *
     * @return
     */
    protected String getCodStudent() {
        return codStudent;
    }

    /**
     *
     * @return
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     *
     * @return
     */
    public int getCodDisciplina() {
        return codDisciplina;
    }

    /**
     *
     * @param student
     */
    protected void setStudent(Student student) {
        this.student = student;
    }

    public void setDataExamen(Data dataExamen) {
        this.dataExamen = dataExamen;
    }

    /**
     *
     * @param disciplina
     */
    protected void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     *
     * @return
     */
    public abstract boolean isPromovat();

    /**
     *
     * @return
     */
    public abstract Optional getNotaFinala();

    public abstract void setNotaFinala();

    public void setPromovat(Boolean b){
        this.promovat = b;
    }
}
