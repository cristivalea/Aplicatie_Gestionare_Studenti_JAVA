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
    public Nota(String codS, int codD, Data dataE){
        this.codStudent = codS;
        this.codDisciplina = codD;
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
}
