package model;

import exceptii.AnNeadecvat;
import exceptii.FormatException;
import exceptii.StudentNeadecvat;
import teste.Main2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Student {
   private String nrMatricol;
   private String numeFamilie;
   private ArrayList<String> prenume = new ArrayList<String>();
   private Data dataNAstere;
   private Data dataInmatriculare;
   private ArrayList<Nota> note = new ArrayList<Nota>();
   private int varta;

   private static ArrayList<Triplet<String, ArrayList<String>, Data>> lista = new ArrayList<Triplet<String, ArrayList<String>, Data>>();
   public static ArrayList<String> listaNrMatricole = new ArrayList<String>();

   public Student(String nrMat, String numeFam, Data dataN, Data dataInm, String ...prenume) throws Exception{
       if(nrMat == null || numeFam == null || dataN == null || dataInm == null || prenume.length == 0){
           return;
       }
       if(RegularExpresion.RegularExpresionNrMatricol(nrMat) == false){
           FormatException fnm = new FormatException(nrMat,FormatException.NR_MATRICOL_FORMAT);
           throw fnm;
       }
       for(String nr : listaNrMatricole){
           if(nrMat == nr){
               StudentNeadecvat stn = new StudentNeadecvat(StudentNeadecvat.UNICITATE,nrMat);
               throw stn;
           }
       }
       this.nrMatricol = nrMat;
       listaNrMatricole.add(this.nrMatricol);
       if(RegularExpresion.RegularExpresionNumePrenume(numeFam)){
           FormatException fnf = new FormatException(numeFam,FormatException.NUME_PRENUME_FORMAT);
           throw fnf;
       }
       this.numeFamilie = numeFam;
       if(RegularExpresion.RegularExpresionData(dataN.toString()) == false){
           FormatException fndn = new FormatException(dataN.toString(),FormatException.DATA_FORMAT);
           throw fndn;
       }
       if(dataInm.getAn() < dataN.getAn()){
           StudentNeadecvat datan = new StudentNeadecvat(StudentNeadecvat.DATA_NASTERE_INADECVATA, dataN.toString());
       }
       this.dataNAstere = dataN;
       if(RegularExpresion.RegularExpresionData(dataInm.toString()) == false){
           FormatException fndi = new FormatException(dataInm.toString(), FormatException.DATA_FORMAT);
           throw fndi;
       }
       if(dataInm.diferenta(dataN) < 18){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInm.toString());
           throw std;
       }
       if(dataInm.getAn() < 1921){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInmatriculare.toString());
           throw std;
       }
       this.dataInmatriculare = dataInm;
       for(String p : prenume){
           if(RegularExpresion.RegularExpresionNumePrenume(p) == false){
               FormatException fnp = new FormatException(p, FormatException.NUME_PRENUME_FORMAT);
               throw fnp;
           }
           this.prenume.add(p);
       }
       this.setVarsta();
   }

   public Student(String numeFam, Data dataN, Data dataInm, String ...prenume) throws Exception{
       Random random = new Random();
       int cod = 0;
       if(RegularExpresion.RegularExpresionNumePrenume(numeFam) == false){
           FormatException fe = new FormatException(numeFam,FormatException.NUME_PRENUME_FORMAT);
           throw fe;
       }
       Main2.logger.info("Format valid");
       String dataNast = dataN.getZi() + "/" + dataN.getLuna().getNrOrdine() + "/" + dataN.getAn();
       if(RegularExpresion.RegularExpresionData(dataNast) == false){
           FormatException fndn = new FormatException(dataNast,FormatException.DATA_FORMAT);
           throw fndn;
       }
       Main2.logger.info("Format data nasterii");
       if(dataInm.getAn() < dataN.getAn()){
           StudentNeadecvat datan = new StudentNeadecvat(StudentNeadecvat.DATA_NASTERE_INADECVATA, dataN.toString());
           throw datan;
       }
       Main2.logger.info("Verificare data nastere < data inmatricularii");
       String dataInmatric = dataInm.getZi() + "/" + dataInm.getLuna().getNrOrdine() + "/" + dataInm.getAn();
       if(RegularExpresion.RegularExpresionData(dataInmatric) == false){
           FormatException fndi = new FormatException(dataInmatric, FormatException.DATA_FORMAT);
           throw fndi;
       }
       Main2.logger.info("Verificare format data inmatriculare");
       if(dataInm.diferenta(dataN) < (18 * 365)){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInm.toString());
           throw std;
       }
       Main2.logger.info("Verificare diferenta dintre date");
       if(dataInm.getAn() < 1921){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInmatriculare.toString());
           throw std;
       }
       Main2.logger.info("Verificare an inmatriculare");
       for(String p : prenume){
           if(RegularExpresion.RegularExpresionNumePrenume(p) == false){
               FormatException fnp = new FormatException(p, FormatException.NUME_PRENUME_FORMAT);
               throw fnp;
           }
           this.prenume.add(p);
       }
       Main2.logger.info("Verificare format prenume");
       if(listaNrMatricole.size() == 0 ){
               cod = 100 + random.nextInt(899);
               this.nrMatricol = "CTI";
               this.nrMatricol += (dataInm.getAn() > 2000 ? "0" : "") + dataInm.getAn() % 1000;
               this.nrMatricol += String.valueOf(cod);
               adaugareCod(this.nrMatricol);
       }
       else{
           String nrMat = "";
               do{
                   nrMat = "CTI";
                   cod = 100 + random.nextInt(899);
                   nrMat += (dataInm.getAn() > 2000 ? "0" : "") + dataInm.getAn() % 1000;
                   nrMat += String.valueOf(cod);
               }while (verificareExistentaNrMatricol(nrMat) == true);
           this.nrMatricol = nrMat;
           adaugareCod(this.nrMatricol);
           }
       Main2.logger.info("Codul: " + cod);
       this.numeFamilie = numeFam;
       this.dataInmatriculare = dataInm;
       this.dataNAstere = dataN;
       this.setVarsta();
       Main2.logger.info("Setare atribute");
   }

   public Student(String linie) throws Exception{
       if(RegularExpresion.RegularExpresionStudent(linie) == false){
           FormatException fe = new FormatException(linie,FormatException.STUDENT_LINIE_FORMAT);
           throw fe;
       }
       Scanner scanner = new Scanner(linie);
       scanner.useDelimiter(";");
       String nrMat = scanner.next();
       //teste.Main.logger.info(nrMat);
       if(RegularExpresion.RegularExpresionNrMatricol(nrMat) == false){
           FormatException fe = new FormatException(nrMat,FormatException.NR_MATRICOL_FORMAT);
           throw fe;
       }
       for(String s : listaNrMatricole){
           if(s.equals(nrMat)){
               StudentNeadecvat nMAtnead = new StudentNeadecvat(StudentNeadecvat.UNICITATE,nrMat);
               throw nMAtnead;
           }
       }
       String numeFam = scanner.next();
       if(RegularExpresion.RegularExpresionNumePrenume(numeFam) == false){
           FormatException fe = new FormatException(numeFam, FormatException.NUME_PRENUME_FORMAT);
           throw fe;
       }
       String str = scanner.next();
       Scanner scanner2 = new Scanner(str);
       while (scanner2.hasNext()){
           String prenume = scanner2.next();
           if(RegularExpresion.RegularExpresionNumePrenume(prenume) == false){
               FormatException fe = new FormatException(prenume, FormatException.NUME_PRENUME_FORMAT);
               throw fe;
           }
           this.prenume.add(prenume);
       }
       scanner2.close();
       String dataNastere = scanner.next();
       String dataInmat = scanner.next();
       if(RegularExpresion.RegularExpresionData(dataNastere) == false){
           FormatException fndn = new FormatException(dataNastere,FormatException.DATA_FORMAT);
           throw fndn;
       }
       if(RegularExpresion.RegularExpresionData(dataInmat) == false){
           FormatException fndi = new FormatException(dataInmat, FormatException.DATA_FORMAT);
           throw fndi;
       }
       Exception e = null;
       Data dataN = null;
       Data dataInm = null;
       try {
           dataN = new Data(dataNastere);
       }catch (Exception ee){
           e = ee;
           System.err.println(e);
       }
       if(e != null){
           throw e;
       }
       try {
           dataInm = new Data(dataInmat);
       }catch (Exception ee){
           e = ee;
           System.err.println(e);
       }
       if(e != null){
           throw e;
       }
       if(dataN.compareTo(dataInm) > 0){
           StudentNeadecvat datan = new StudentNeadecvat(StudentNeadecvat.DATA_NASTERE_INADECVATA,dataN.toString());
           throw datan;
       }
       if((dataInm.diferenta(dataN) / 365) < 18){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInm.toString());
           throw std;
       }
       if(dataInm.getAn() < 1924){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInm.toString());
           throw std;
       }
       if(dataInm.getAn() > AnNeadecvat.extrageAn()){
           StudentNeadecvat std = new StudentNeadecvat(StudentNeadecvat.DATA_INMATRICULARE_ADECVATA, dataInm.toString());
           throw std;
       }
       this.nrMatricol = nrMat;
       listaNrMatricole.add(this.nrMatricol);
       this.numeFamilie = numeFam;
       this.dataNAstere = dataN;
       this.dataInmatriculare = dataInm;
       this.setVarsta();
       scanner.close();
       Main2.logger.info("S-a incarcat studentul: " + this.nrMatricol + ";" + this.numeFamilie + ";" + this.prenume + ";" + this.dataNAstere + ";" + this.dataInmatriculare);
   }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public String getNumeFamilie() {
        return numeFamilie;
    }

    public ArrayList<String> getPrenume() {
        return prenume;
    }

    public Data getDataNAstere() {
        return dataNAstere;
    }

    public Data getDataInmatriculare() {
        return dataInmatriculare;
    }

    public ArrayList<Nota> getNote() {
        return note;
    }

    public int getVarta() {
        return varta;
    }

    public void setNumeFamilie(String numeFamilie) {
        this.numeFamilie = numeFamilie;
    }

    public void setPrenume(ArrayList<String> prenume){
       this.prenume = prenume;
    }

    public void setDataNAstere(Data dataNastere) {
        this.dataNAstere = dataNastere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return varta == student.varta && Objects.equals(nrMatricol, student.nrMatricol) && Objects.equals(numeFamilie, student.numeFamilie) && Objects.equals(prenume, student.prenume) && Objects.equals(dataNAstere, student.dataNAstere) && Objects.equals(dataInmatriculare, student.dataInmatriculare) && Objects.equals(note, student.note);
    }

    @Override
    public String toString() {
       String str_note=" ";
       for(Nota n:this.getNote()) {
           str_note+=n.getDisciplina().getNumeDisciplina()+":"+String.valueOf(n.getNotaFinala())+" , ";
       }
       return "\n*************\n" +
               "model.Student ["
               + (nrMatricol != null ? "\nnumarMatricol=" + nrMatricol + ", " : "")
               + (numeFamilie != null ? "\nnumeFamilie=" + numeFamilie + ", " : "")
               + (prenume != null ? "\nprenume=" + prenume + ", " : "")
               + (dataNAstere != null ? "\ndataNasterii=" + dataNAstere + ", " : "")
               + (dataInmatriculare != null ? "\ndataInmatriculare=" + dataInmatriculare + ", " : "")
               + (note != null ? "\nnote=" + str_note : "")
               + "\nvarsta=" + varta + "\n]"; }

    public void setVarsta(){
       int dif = this.dataInmatriculare.diferenta(dataNAstere);
       int nrAniBisecti = (this.dataInmatriculare.getAn() - this.dataNAstere.getAn()) / 4;
       dif = dif - nrAniBisecti;
       this.varta = dif / 365;
    }



    public boolean verificaExistentaCod(String codMat){
       return listaNrMatricole.indexOf(codMat) != -1;
    }

    public void adaugareCod(String codMat){
       listaNrMatricole.add(codMat);
    }

    public static boolean verificareExistentaNrMatricol(String nrMat){
       for(int i = 0 ; i < listaNrMatricole.size(); i++){
           if(nrMat != null && nrMat.equals(listaNrMatricole.get(i))){
               return true;
           }
       }
       return false;
    }
}
