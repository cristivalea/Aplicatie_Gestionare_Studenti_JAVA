package model;

import XMLProcess.ProcesareFisaDisciplinei;
import main.Predicates;
import teste.Main2;
import view.Observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Repository {
    private static ArrayList<Disciplina> discipline=new ArrayList<Disciplina>();
    private static ArrayList<Student> studenti=new ArrayList<Student>();
    private static ArrayList<Nota> note=new ArrayList<Nota>();
    private ArrayList<Observer> observatori = new ArrayList<Observer>();
    private static Repository instance=null;
    private Repository() throws Exception
    {
        Main2.logger.info("****************Incarcare discipline**************");
        loadDiscipline();
        //incarcare note
        Main2.logger.info("*****************Incarcare Note********************");
        loadNote();
        for(Nota n:note) {
         for(Disciplina d:discipline)
            if(d.getCodDisciplina()==n.getCodDisciplina()) {
                n.setDisciplina(d);
//                n.setPromovat(n.isPromovat());
//                n.setNotaFinala();
                break;
            }
        }
        //incarcare studenti
        Main2.logger.info("******************Incarcare Studenti******************");
        loadStudenti();
        for(Student s:studenti)
            for(Nota n:note)
                if(s.getNrMatricol().equals(n.getCodStudent())) {
                    s.getNote().add(n);
                }
        //update note
        for(Nota n:note)
            for(Student s:studenti)
                if(n.getCodStudent().equals(s.getNrMatricol()))
                { n.setStudent(s);
                break;
                }
        Main2.logger.info("*********************Update studenti***********************");
        for(Student s : studenti){
            Main2.logger.info("Studentul: " + s.toString());
        }

        Optional<ArrayList<FisaDisciplinei>> box = ProcesareFisaDisciplinei.getFiseDiscipline();
        ArrayList<FisaDisciplinei> listaFiseDiscipline = new ArrayList<FisaDisciplinei>();
        if(box.isEmpty() == true){
            System.err.println("Nu s-au incarcat disciplinele");
        }
        else{
            listaFiseDiscipline = box.get();
        }

        for(Disciplina d : discipline){
            for(FisaDisciplinei f : listaFiseDiscipline){
                if(f.getDenumireDisciplina().equals(d.getNumeDisciplina())){
                    d.setFisaDisciplinei(f);
                }
            }
        }//end for
    }//end Repository
    public static Repository getInstance() throws Exception {
        if(instance == null)
            instance=new Repository();
        return instance;
    }
    private void loadDiscipline() throws IOException{
        File f=new File(Files.FILE_DISCIPLINE);
        Scanner scanner=new Scanner(f);
        while(scanner.hasNext())
            discipline.add(new Disciplina(scanner.nextLine()));
        scanner.close(); }

    private void loadNote() throws Exception{
        File f=new File(Files.FILE_NOTE);
        Scanner scanner=new Scanner(f);
        while(scanner.hasNext())
           // note.add(new Nota(scanner.nextLine()));
        scanner.close();
    }

    private void loadStudenti() throws Exception{
        File f=new File(Files.FILE_STUDENTI);
        Scanner scanner=new Scanner(f);
        while(scanner.hasNext())
            studenti.add(new Student(scanner.nextLine()));
        scanner.close();
    }

    public ArrayList<Disciplina> getDiscipline() {
        return discipline; }
    public ArrayList<Nota> getNote() {
        return note;
    }
    public  ArrayList<Student> getStudenti() {
        return studenti;
    }

    public void adaugaStudent(Student s) throws IOException{
        File f = new File(Files.FILE_STUDENTI);
        if(f.canWrite()){
            FileWriter f2 = new FileWriter(f,true);
            String strPren = "";
            for(int i = 0; i < s.getPrenume().size(); i++){
                strPren = strPren + s.getPrenume().get(i) + " ";
            }
            strPren = strPren.trim();
            String dataNStr = s.getDataNAstere().getZi() + "/" + s.getDataNAstere().getLuna().getNrOrdine() + "/" + s.getDataNAstere().getAn();
            String dataInmStr = s.getDataInmatriculare().getZi() + "/" + s.getDataInmatriculare().getLuna().getNrOrdine() + "/" + s.getDataInmatriculare().getAn();
            String str = "\n" + s.getNrMatricol() + ";" + s.getNumeFamilie() + ";" + strPren + ";" + dataNStr + ";" + dataInmStr;
            f2.write(str);
            f2.close();
        }
        studenti.add(s);
        notifyObservers();
    } // end adauga student

    public void stergeStudent(Student std) throws IOException{
        int index = -1;
        for(int i = 0; i < studenti.size(); i++){
            if(Predicates.studentiIdentici.test(studenti.get(i),std)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.err.println("Studentul nu a fost gasit");
            return;
        }
        studenti.remove(index);
        notifyObservers();
        File f = new File(Files.FILE_STUDENTI);
        if(f.canWrite()){
            FileWriter f2 = new FileWriter(f);
            for(int i = 0; i < studenti.size(); i++){
                String pren = "";
                for(int j = 0; j < studenti.get(i).getPrenume().size(); j++){
                    pren = pren + studenti.get(i).getPrenume().get(j) + " ";
                }
                pren = pren.trim();
                String dataN = studenti.get(i).getDataNAstere().getZi() + "/" + studenti.get(i).getDataNAstere().getLuna().getNrOrdine() + "/" + studenti.get(i).getDataNAstere().getAn();
                String dataInmat = studenti.get(i).getDataInmatriculare().getZi() + "/" + studenti.get(i).getDataInmatriculare().getLuna().getNrOrdine() + "/" + studenti.get(i).getDataInmatriculare().getAn();
                String line = studenti.get(i).getNrMatricol() + ";" + studenti.get(i).getNumeFamilie() + ";" + pren + ";" + dataN + ";" + dataInmat + ((i == studenti.size() - 1 ) ? "" : "\n");
                f2.write(line);
            }
            f2.close();
        }
    }

    public void registerObserver(Observer obj){
        observatori.add(obj);
    }

    public void notifyObservers(){
        for(Observer o : observatori){
            o.update();
        }
    }
} // end class
