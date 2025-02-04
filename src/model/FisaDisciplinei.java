package model;

import java.util.ArrayList;
import java.util.Objects;

public class FisaDisciplinei {
    private static final String numeInstitutie = "Universitatea Politehnica Timisoara";
    private static final String facultate = "Automatica si Calculatoare";
    private static final String departament = "Tehnologia Informatiei";
    private static final String denumireDomeniuStudiu = "Calculatoare si Tehnologia Informatiei";
    private static final int cod = 10;
    private static final String cicluStudii = "Licenta";
    private static final String denumireProgramStudii = "Tehnologia Informatiei";
    private static final int codProgramStudii = 20;
    private static final String calificare = "Inginer";
    private String denumireDisciplina;
    private CategorieFormativa categFormativa;
    private String titularCurs;
    private ArrayList<String> titularAplicative = new ArrayList<String>();
    private int anStudiu;
    private int semestrul;
    private TipExamen tipEvaluare;
    private RegimDisciplina regimDisciplina;
    private double nrOreAsistSapt;
    private double oreCursSapt;
    private double oreAplicativeSapt;
    private double nrOreAsistSem;
    private double oreCursSem;
    private double oreAplicativeSem;
    private double oreAsistPartialSapt;
    private double oreAsistPartPrectica;
    private double oreElabProiectDiploma;
    private double nrOreAsistPartSem;
    private double nrOreAsistPartPractica;
    private double oreAsistPartDiploma;
    private double oreNEasistSapt;
    private double oreDocumentare;
    private double oreStudiuIndividual;
    private double orePregLab;
    private double oreNEasistSem;
    private double oreDocumentareSem;
    private double oreStudiuIndividualSem;
    private double orePregLabSem;
    private double totalOreSapt;
    private double totalOreSem;
    private double nrCredite;
    private ArrayList<Disciplina> precondCurriculum = new ArrayList<Disciplina>();
    private String precondCompetente;
    private String condDesfCurs;
    private String condActPractice;
    private ArrayList<String> compSpecifice = new ArrayList<String>();
    private ArrayList<String> compProfesionale = new ArrayList<String>();
    private ArrayList<String> compTransversale = new ArrayList<String>();
    private ArrayList<String> obiectiveGenerale = new ArrayList<String>();
    private ArrayList<String> obiectiveSpecifice = new ArrayList<String>();
    private ArrayList<Pereche<String, Integer>> curs = new ArrayList<Pereche<String, Integer>>();
    private String metodePredareCurs;
    private ArrayList<Publicatie> bibliografieCurs = new ArrayList<Publicatie>();
    private ArrayList<Pereche<String, Integer>> lab = new ArrayList<Pereche<String, Integer>>();
    private String metodePredareLab;
    private ArrayList<Publicatie> bibliografieLab = new ArrayList<Publicatie>();
    private ArrayList<String> coroborare = new ArrayList<String>();
    private String tipActivitateCurs;
    private String criteriiEvaluareCurs;
    private String metodeEvaluareCurs;
    private double coeficientNotaFinalaCurs;

    private String tipActivitateLab;
    private String criteriiEvaluareLaborator;
    private String metodeEvaluareLaborator;
    private double coeficientNotaFinalaLaborator;

    private String tipActivitateProiect;
    private String criteriiEvaluareProiect;
    private String metodeEvaluareProiect;
    private double coeficientNotaFinalaProiect;

    private String tipActivitatePrezenta;
    private String criteriiEvaluarePrezenta;
    private String metodeEvaluarePrezenta;
    private double coeficientNotaFinalaPrezenta;

    private Data datacompletarii;
    private Data dataAvizarii;
    private String standardMinPerformanta;

    public FisaDisciplinei(){}

    public FisaDisciplinei(String denumireDisciplina, CategorieFormativa categFormativa, String titularCurs, ArrayList<String> titularAplicative, int anStudiu, int semestrul, TipExamen tipEvaluare, RegimDisciplina regimDisciplina, double nrOreAsistSapt, double oreCursSapt, double oreAplicativeSapt, double nrOreAsistSem, double oreCursSem, double oreAplicativeSem, double oreAsistPartialSapt, double oreAsistPartPrectica, double oreElabProiectDiploma, double nrOreAsistPartSem, double nrOreAsistPartPractica, double oreAsistPartDiploma, double oreNEasistSapt, double oreDocumentare, double oreStudiuIndividual, double orePregLab, double oreNEasistSem, double oreDocumentareSem, double oreStudiuIndividualSem, double orePregLabSem, double totalOreSapt, double totalOreSem, double nrCredite, ArrayList<Disciplina> precondCurriculum, String precondCompetente, String condDesfCurs, String condActPractice, ArrayList<String> compSpecifice, ArrayList<String> compProfesionale, ArrayList<String> compTransversale, ArrayList<String> obiectiveGenerale, ArrayList<String> obiectiveSpecifice, ArrayList<Pereche<String, Integer>> curs, String metodePredareCurs, ArrayList<Publicatie> bibliografieCurs, ArrayList<Pereche<String, Integer>> lab, String metodePredareLab, ArrayList<Publicatie> bibliografieLab, ArrayList<String> coroborare, String tipActivitateCurs, String criteriiEvaluareCurs, String metodeEvaluareCurs, double coeficientNotaFinalaCurs, String tipActivitateLab, String criteriiEvaluareLaborator, String metodeEvaluareLaborator, double coeficientNotaFinalaLaborator, String tipActivitateProiect, String criteriiEvaluareProiect, String metodeEvaluareProiect, double coeficientNotaFinalaProiect, String tipActivitatePrezenta, String criteriiEvaluarePrezenta, String metodeEvaluarePrezenta, double coeficientNotaFinalaPrezenta, Data datacompletarii, Data dataAvizarii, String standardMinPerformanta) {
        this.denumireDisciplina = denumireDisciplina;
        this.categFormativa = categFormativa;
        this.titularCurs = titularCurs;
        this.titularAplicative = titularAplicative;
        this.anStudiu = anStudiu;
        this.semestrul = semestrul;
        this.tipEvaluare = tipEvaluare;
        this.regimDisciplina = regimDisciplina;
        this.nrOreAsistSapt = nrOreAsistSapt;
        this.oreCursSapt = oreCursSapt;
        this.oreAplicativeSapt = oreAplicativeSapt;
        this.nrOreAsistSem = nrOreAsistSem;
        this.oreCursSem = oreCursSem;
        this.oreAplicativeSem = oreAplicativeSem;
        this.oreAsistPartialSapt = oreAsistPartialSapt;
        this.oreAsistPartPrectica = oreAsistPartPrectica;
        this.oreElabProiectDiploma = oreElabProiectDiploma;
        this.nrOreAsistPartSem = nrOreAsistPartSem;
        this.nrOreAsistPartPractica = nrOreAsistPartPractica;
        this.oreAsistPartDiploma = oreAsistPartDiploma;
        this.oreNEasistSapt = oreNEasistSapt;
        this.oreDocumentare = oreDocumentare;
        this.oreStudiuIndividual = oreStudiuIndividual;
        this.orePregLab = orePregLab;
        this.oreNEasistSem = oreNEasistSem;
        this.oreDocumentareSem = oreDocumentareSem;
        this.oreStudiuIndividualSem = oreStudiuIndividualSem;
        this.orePregLabSem = orePregLabSem;
        this.totalOreSapt = totalOreSapt;
        this.totalOreSem = totalOreSem;
        this.nrCredite = nrCredite;
        this.precondCurriculum = precondCurriculum;
        this.precondCompetente = precondCompetente;
        this.condDesfCurs = condDesfCurs;
        this.condActPractice = condActPractice;
        this.compSpecifice = compSpecifice;
        this.compProfesionale = compProfesionale;
        this.compTransversale = compTransversale;
        this.obiectiveGenerale = obiectiveGenerale;
        this.obiectiveSpecifice = obiectiveSpecifice;
        this.curs = curs;
        this.metodePredareCurs = metodePredareCurs;
        this.bibliografieCurs = bibliografieCurs;
        this.lab = lab;
        this.metodePredareLab = metodePredareLab;
        this.bibliografieLab = bibliografieLab;
        this.coroborare = coroborare;
        this.tipActivitateCurs = tipActivitateCurs;
        this.criteriiEvaluareCurs = criteriiEvaluareCurs;
        this.metodeEvaluareCurs = metodeEvaluareCurs;
        this.coeficientNotaFinalaCurs = coeficientNotaFinalaCurs;
        this.tipActivitateLab = tipActivitateLab;
        this.criteriiEvaluareLaborator = criteriiEvaluareLaborator;
        this.metodeEvaluareLaborator = metodeEvaluareLaborator;
        this.coeficientNotaFinalaLaborator = coeficientNotaFinalaLaborator;
        this.tipActivitateProiect = tipActivitateProiect;
        this.criteriiEvaluareProiect = criteriiEvaluareProiect;
        this.metodeEvaluareProiect = metodeEvaluareProiect;
        this.coeficientNotaFinalaProiect = coeficientNotaFinalaProiect;
        this.tipActivitatePrezenta = tipActivitatePrezenta;
        this.criteriiEvaluarePrezenta = criteriiEvaluarePrezenta;
        this.metodeEvaluarePrezenta = metodeEvaluarePrezenta;
        this.coeficientNotaFinalaPrezenta = coeficientNotaFinalaPrezenta;
        this.datacompletarii = datacompletarii;
        this.dataAvizarii = dataAvizarii;
        this.standardMinPerformanta = standardMinPerformanta;
    }

    public String getDenumireDisciplina() {
        return denumireDisciplina;
    }

    public void setDenumireDisciplina(String denumireDisciplina) {
        this.denumireDisciplina = denumireDisciplina;
    }

    public CategorieFormativa getCategFormativa() {
        return categFormativa;
    }

    public void setCategFormativa(CategorieFormativa categFormativa) {
        this.categFormativa = categFormativa;
    }

    public String getTitularCurs() {
        return titularCurs;
    }

    public void setTitularCurs(String titularCurs) {
        this.titularCurs = titularCurs;
    }

    public ArrayList<String> getTitularAplicative() {
        return titularAplicative;
    }

    public void setTitularAplicative(ArrayList<String> titularAplicative) {
        this.titularAplicative = titularAplicative;
    }

    public int getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }

    public int getSemestrul() {
        return semestrul;
    }

    public void setSemestrul(int semestrul) {
        this.semestrul = semestrul;
    }

    public TipExamen getTipEvaluare() {
        return tipEvaluare;
    }

    public void setTipEvaluare(TipExamen tipEvaluare) {
        this.tipEvaluare = tipEvaluare;
    }

    public RegimDisciplina getRegimDisciplina() {
        return regimDisciplina;
    }

    public void setRegimDisciplina(RegimDisciplina regimDisciplina) {
        this.regimDisciplina = regimDisciplina;
    }

    public double getNrOreAsistSapt() {
        return nrOreAsistSapt;
    }

    public void setNrOreAsistSapt(double nrOreAsistSapt) {
        this.nrOreAsistSapt = nrOreAsistSapt;
    }

    public double getOreCursSapt() {
        return oreCursSapt;
    }

    public void setOreCursSapt(double oreCursSapt) {
        this.oreCursSapt = oreCursSapt;
    }

    public double getOreAplicativeSapt() {
        return oreAplicativeSapt;
    }

    public void setOreAplicativeSapt(double oreAplicativeSapt) {
        this.oreAplicativeSapt = oreAplicativeSapt;
    }

    public double getNrOreAsistSem() {
        return nrOreAsistSem;
    }

    public void setNrOreAsistSem(double nrOreAsistSem) {
        this.nrOreAsistSem = nrOreAsistSem;
    }

    public double getOreCursSem() {
        return oreCursSem;
    }

    public void setOreCursSem(double oreCursSem) {
        this.oreCursSem = oreCursSem;
    }

    public double getOreAplicativeSem() {
        return oreAplicativeSem;
    }

    public void setOreAplicativeSem(double oreAplicativeSem) {
        this.oreAplicativeSem = oreAplicativeSem;
    }

    public double getOreAsistPartialSapt() {
        return oreAsistPartialSapt;
    }

    public void setOreAsistPartialSapt(double oreAsistPartialSapt) {
        this.oreAsistPartialSapt = oreAsistPartialSapt;
    }

    public double getOreAsistPartPrectica() {
        return oreAsistPartPrectica;
    }

    public void setOreAsistPartPrectica(double oreAsistPartPrectica) {
        this.oreAsistPartPrectica = oreAsistPartPrectica;
    }

    public double getOreElabProiectDiploma() {
        return oreElabProiectDiploma;
    }

    public void setOreElabProiectDiploma(double oreElabProiectDiploma) {
        this.oreElabProiectDiploma = oreElabProiectDiploma;
    }

    public double getNrOreAsistPartSem() {
        return nrOreAsistPartSem;
    }

    public void setNrOreAsistPartSem(double nrOreAsistPartSem) {
        this.nrOreAsistPartSem = nrOreAsistPartSem;
    }

    public double getNrOreAsistPartPractica() {
        return nrOreAsistPartPractica;
    }

    public void setNrOreAsistPartPractica(double nrOreAsistPartPractica) {
        this.nrOreAsistPartPractica = nrOreAsistPartPractica;
    }

    public double getOreAsistPartDiploma() {
        return oreAsistPartDiploma;
    }

    public void setOreAsistPartDiploma(double oreAsistPartDiploma) {
        this.oreAsistPartDiploma = oreAsistPartDiploma;
    }

    public double getOreNEasistSapt() {
        return oreNEasistSapt;
    }

    public void setOreNEasistSapt(double oreNEasistSapt) {
        this.oreNEasistSapt = oreNEasistSapt;
    }

    public double getOreDocumentare() {
        return oreDocumentare;
    }

    public void setOreDocumentare(double oreDocumentare) {
        this.oreDocumentare = oreDocumentare;
    }

    public double getOreStudiuIndividual() {
        return oreStudiuIndividual;
    }

    public void setOreStudiuIndividual(double oreStudiuIndividual) {
        this.oreStudiuIndividual = oreStudiuIndividual;
    }

    public double getOrePregLab() {
        return orePregLab;
    }

    public void setOrePregLab(double orePregLab) {
        this.orePregLab = orePregLab;
    }

    public double getOreNEasistSem() {
        return oreNEasistSem;
    }

    public void setOreNEasistSem(double oreNEasistSem) {
        this.oreNEasistSem = oreNEasistSem;
    }

    public double getOreDocumentareSem() {
        return oreDocumentareSem;
    }

    public void setOreDocumentareSem(double oreDocumentareSem) {
        this.oreDocumentareSem = oreDocumentareSem;
    }

    public double getOreStudiuIndividualSem() {
        return oreStudiuIndividualSem;
    }

    public void setOreStudiuIndividualSem(double oreStudiuIndividualSem) {
        this.oreStudiuIndividualSem = oreStudiuIndividualSem;
    }

    public double getOrePregLabSem() {
        return orePregLabSem;
    }

    public void setOrePregLabSem(double orePregLabSem) {
        this.orePregLabSem = orePregLabSem;
    }

    public double getTotalOreSapt() {
        return totalOreSapt;
    }

    public void setTotalOreSapt(double totalOreSapt) {
        this.totalOreSapt = totalOreSapt;
    }

    public double getTotalOreSem() {
        return totalOreSem;
    }

    public void setTotalOreSem(double totalOreSem) {
        this.totalOreSem = totalOreSem;
    }

    public double getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(double nrCredite) {
        this.nrCredite = nrCredite;
    }

    public ArrayList<Disciplina> getPrecondCurriculum() {
        return precondCurriculum;
    }

    public void setPrecondCurriculum(ArrayList<Disciplina> precondCurriculum) {
        this.precondCurriculum = precondCurriculum;
    }

    public String getPrecondCompetente() {
        return precondCompetente;
    }

    public void setPrecondCompetente(String precondCompetente) {
        this.precondCompetente = precondCompetente;
    }

    public String getCondDesfCurs() {
        return condDesfCurs;
    }

    public void setCondDesfCurs(String condDesfCurs) {
        this.condDesfCurs = condDesfCurs;
    }

    public String getCondActPractice() {
        return condActPractice;
    }

    public void setCondActPractice(String condActPractice) {
        this.condActPractice = condActPractice;
    }

    public ArrayList<String> getCompSpecifice() {
        return compSpecifice;
    }

    public void setCompSpecifice(ArrayList<String> compSpecifice) {
        this.compSpecifice = compSpecifice;
    }

    public ArrayList<String> getCompProfesionale() {
        return compProfesionale;
    }

    public void setCompProfesionale(ArrayList<String> compProfesionale) {
        this.compProfesionale = compProfesionale;
    }

    public ArrayList<String> getCompTransversale() {
        return compTransversale;
    }

    public void setCompTransversale(ArrayList<String> compTransversale) {
        this.compTransversale = compTransversale;
    }

    public ArrayList<String> getObiectiveGenerale() {
        return obiectiveGenerale;
    }

    public void setObiectiveGenerale(ArrayList<String> obiectiveGenerale) {
        this.obiectiveGenerale = obiectiveGenerale;
    }

    public ArrayList<String> getObiectiveSpecifice() {
        return obiectiveSpecifice;
    }

    public void setObiectiveSpecifice(ArrayList<String> obiectiveSpecifice) {
        this.obiectiveSpecifice = obiectiveSpecifice;
    }

    public ArrayList<Pereche<String, Integer>> getCurs() {
        return curs;
    }

    public void setCurs(ArrayList<Pereche<String, Integer>> curs) {
        this.curs = curs;
    }

    public String getMetodePredareCurs() {
        return metodePredareCurs;
    }

    public void setMetodePredareCurs(String metodePredareCurs) {
        this.metodePredareCurs = metodePredareCurs;
    }

    public ArrayList<Publicatie> getBibliografieCurs() {
        return bibliografieCurs;
    }

    public void setBibliografieCurs(ArrayList<Publicatie> bibliografieCurs) {
        this.bibliografieCurs = bibliografieCurs;
    }

    public ArrayList<Pereche<String, Integer>> getLab() {
        return lab;
    }

    public void setLab(ArrayList<Pereche<String, Integer>> lab) {
        this.lab = lab;
    }

    public String getMetodePredareLab() {
        return metodePredareLab;
    }

    public void setMetodePredareLab(String metodePredareLab) {
        this.metodePredareLab = metodePredareLab;
    }

    public ArrayList<Publicatie> getBibliografieLab() {
        return bibliografieLab;
    }

    public void setBibliografieLab(ArrayList<Publicatie> bibliografieLab) {
        this.bibliografieLab = bibliografieLab;
    }

    public ArrayList<String> getCoroborare() {
        return coroborare;
    }

    public void setCoroborare(ArrayList<String> coroborare) {
        this.coroborare = coroborare;
    }

    public String getTipActivitateCurs() {
        return tipActivitateCurs;
    }

    public void setTipActivitateCurs(String tipActivitateCurs) {
        this.tipActivitateCurs = tipActivitateCurs;
    }

    public String getCriteriiEvaluareCurs() {
        return criteriiEvaluareCurs;
    }

    public void setCriteriiEvaluareCurs(String criteriiEvaluareCurs) {
        this.criteriiEvaluareCurs = criteriiEvaluareCurs;
    }

    public String getMetodeEvaluareCurs() {
        return metodeEvaluareCurs;
    }

    public void setMetodeEvaluareCurs(String metodeEvaluareCurs) {
        this.metodeEvaluareCurs = metodeEvaluareCurs;
    }

    public double getCoeficientNotaFinalaCurs() {
        return coeficientNotaFinalaCurs;
    }

    public void setCoeficientNotaFinalaCurs(double coeficientNotaFinalaCurs) {
        this.coeficientNotaFinalaCurs = coeficientNotaFinalaCurs;
    }

    public String getTipActivitateLab() {
        return tipActivitateLab;
    }

    public void setTipActivitateLab(String tipActivitateLab) {
        this.tipActivitateLab = tipActivitateLab;
    }

    public String getCriteriiEvaluareLaborator() {
        return criteriiEvaluareLaborator;
    }

    public void setCriteriiEvaluareLaborator(String criteriiEvaluareLaborator) {
        this.criteriiEvaluareLaborator = criteriiEvaluareLaborator;
    }

    public String getMetodeEvaluareLaborator() {
        return metodeEvaluareLaborator;
    }

    public void setMetodeEvaluareLaborator(String metodeEvaluareLaborator) {
        this.metodeEvaluareLaborator = metodeEvaluareLaborator;
    }

    public double getCoeficientNotaFinalaLaborator() {
        return coeficientNotaFinalaLaborator;
    }

    public void setCoeficientNotaFinalaLaborator(double coeficientNotaFinalaLaborator) {
        this.coeficientNotaFinalaLaborator = coeficientNotaFinalaLaborator;
    }

    public String getTipActivitateProiect() {
        return tipActivitateProiect;
    }

    public void setTipActivitateProiect(String tipActivitateProiect) {
        this.tipActivitateProiect = tipActivitateProiect;
    }

    public String getCriteriiEvaluareProiect() {
        return criteriiEvaluareProiect;
    }

    public void setCriteriiEvaluareProiect(String criteriiEvaluareProiect) {
        this.criteriiEvaluareProiect = criteriiEvaluareProiect;
    }

    public String getMetodeEvaluareProiect() {
        return metodeEvaluareProiect;
    }

    public void setMetodeEvaluareProiect(String metodeEvaluareProiect) {
        this.metodeEvaluareProiect = metodeEvaluareProiect;
    }

    public double getCoeficientNotaFinalaProiect() {
        return coeficientNotaFinalaProiect;
    }

    public void setCoeficientNotaFinalaProiect(double coeficientNotaFinalaProiect) {
        this.coeficientNotaFinalaProiect = coeficientNotaFinalaProiect;
    }

    public String getTipActivitatePrezenta() {
        return tipActivitatePrezenta;
    }

    public void setTipActivitatePrezenta(String tipActivitatePrezenta) {
        this.tipActivitatePrezenta = tipActivitatePrezenta;
    }

    public String getCriteriiEvaluarePrezenta() {
        return criteriiEvaluarePrezenta;
    }

    public void setCriteriiEvaluarePrezenta(String criteriiEvaluarePrezenta) {
        this.criteriiEvaluarePrezenta = criteriiEvaluarePrezenta;
    }

    public String getMetodeEvaluarePrezenta() {
        return metodeEvaluarePrezenta;
    }

    public void setMetodeEvaluarePrezenta(String metodeEvaluarePrezenta) {
        this.metodeEvaluarePrezenta = metodeEvaluarePrezenta;
    }

    public double getCoeficientNotaFinalaPrezenta() {
        return coeficientNotaFinalaPrezenta;
    }

    public void setCoeficientNotaFinalaPrezenta(double coeficientNotaFinalaPrezenta) {
        this.coeficientNotaFinalaPrezenta = coeficientNotaFinalaPrezenta;
    }

    public Data getDatacompletarii() {
        return datacompletarii;
    }

    public void setDatacompletarii(Data datacompletarii) {
        this.datacompletarii = datacompletarii;
    }

    public Data getDataAvizarii() {
        return dataAvizarii;
    }

    public void setDataAvizarii(Data dataAvizarii) {
        this.dataAvizarii = dataAvizarii;
    }

    public String getStandardMinPerformanta() {
        return standardMinPerformanta;
    }

    public void setStandardMinPerformanta(String standardMinPerformanta) {
        this.standardMinPerformanta = standardMinPerformanta;
    }

    @Override
    public String toString() {
        return "FisaDisciplinei{" +
                "denumireDisciplina='" + denumireDisciplina + '\'' +
                ", categFormativa=" + categFormativa +
                ", titularCurs='" + titularCurs + '\'' +
                ", titularAplicative=" + titularAplicative +
                ", anStudiu=" + anStudiu +
                ", semestrul=" + semestrul +
                ", tipEvaluare=" + tipEvaluare +
                ", regimDisciplina=" + regimDisciplina +
                ", nrOreAsistSapt=" + nrOreAsistSapt +
                ", oreCursSapt=" + oreCursSapt +
                ", oreAplicativeSapt=" + oreAplicativeSapt +
                ", nrOreAsistSem=" + nrOreAsistSem +
                ", oreCursSem=" + oreCursSem +
                ", oreAplicativeSem=" + oreAplicativeSem +
                ", oreAsistPartialSapt=" + oreAsistPartialSapt +
                ", oreAsistPartPrectica=" + oreAsistPartPrectica +
                ", oreElabProiectDiploma=" + oreElabProiectDiploma +
                ", nrOreAsistPartSem=" + nrOreAsistPartSem +
                ", nrOreAsistPartPractica=" + nrOreAsistPartPractica +
                ", oreAsistPartDiploma=" + oreAsistPartDiploma +
                ", oreNEasistSapt=" + oreNEasistSapt +
                ", oreDocumentare=" + oreDocumentare +
                ", oreStudiuIndividual=" + oreStudiuIndividual +
                ", orePregLab=" + orePregLab +
                ", oreNEasistSem=" + oreNEasistSem +
                ", oreDocumentareSem=" + oreDocumentareSem +
                ", oreStudiuIndividualSem=" + oreStudiuIndividualSem +
                ", orePregLabSem=" + orePregLabSem +
                ", totalOreSapt=" + totalOreSapt +
                ", totalOreSem=" + totalOreSem +
                ", nrCredite=" + nrCredite +
                ", precondCurriculum=" + precondCurriculum +
                ", precondCompetente='" + precondCompetente + '\'' +
                ", condDesfCurs='" + condDesfCurs + '\'' +
                ", condActPractice='" + condActPractice + '\'' +
                ", compSpecifice=" + compSpecifice +
                ", compProfesionale=" + compProfesionale +
                ", compTransversale=" + compTransversale +
                ", obiectiveGenerale=" + obiectiveGenerale +
                ", obiectiveSpecifice=" + obiectiveSpecifice +
                ", curs=" + curs +
                ", metodePredareCurs='" + metodePredareCurs + '\'' +
                ", bibliografieCurs=" + bibliografieCurs +
                ", lab=" + lab +
                ", metodePredareLab='" + metodePredareLab + '\'' +
                ", bibliografieLab=" + bibliografieLab +
                ", coroborare=" + coroborare +
                ", tipActivitateCurs='" + tipActivitateCurs + '\'' +
                ", criteriiEvaluareCurs='" + criteriiEvaluareCurs + '\'' +
                ", metodeEvaluareCurs='" + metodeEvaluareCurs + '\'' +
                ", coeficientNotaFinalaCurs=" + coeficientNotaFinalaCurs +
                ", tipActivitateLab='" + tipActivitateLab + '\'' +
                ", criteriiEvaluareLaborator='" + criteriiEvaluareLaborator + '\'' +
                ", metodeEvaluareLaborator='" + metodeEvaluareLaborator + '\'' +
                ", coeficientNotaFinalaLaborator=" + coeficientNotaFinalaLaborator +
                ", tipActivitateProiect='" + tipActivitateProiect + '\'' +
                ", criteriiEvaluareProiect='" + criteriiEvaluareProiect + '\'' +
                ", metodeEvaluareProiect='" + metodeEvaluareProiect + '\'' +
                ", coeficientNotaFinalaProiect=" + coeficientNotaFinalaProiect +
                ", tipActivitatePrezenta='" + tipActivitatePrezenta + '\'' +
                ", criteriiEvaluarePrezenta='" + criteriiEvaluarePrezenta + '\'' +
                ", metodeEvaluarePrezenta='" + metodeEvaluarePrezenta + '\'' +
                ", coeficientNotaFinalaPrezenta=" + coeficientNotaFinalaPrezenta +
                ", datacompletarii=" + datacompletarii +
                ", dataAvizarii=" + dataAvizarii +
                ", standardMinPerformanta='" + standardMinPerformanta + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FisaDisciplinei that = (FisaDisciplinei) o;
        return anStudiu == that.anStudiu && semestrul == that.semestrul && Double.compare(nrOreAsistSapt, that.nrOreAsistSapt) == 0 && Double.compare(oreCursSapt, that.oreCursSapt) == 0 && Double.compare(oreAplicativeSapt, that.oreAplicativeSapt) == 0 && Double.compare(nrOreAsistSem, that.nrOreAsistSem) == 0 && Double.compare(oreCursSem, that.oreCursSem) == 0 && Double.compare(oreAplicativeSem, that.oreAplicativeSem) == 0 && Double.compare(oreAsistPartialSapt, that.oreAsistPartialSapt) == 0 && Double.compare(oreAsistPartPrectica, that.oreAsistPartPrectica) == 0 && Double.compare(oreElabProiectDiploma, that.oreElabProiectDiploma) == 0 && Double.compare(nrOreAsistPartSem, that.nrOreAsistPartSem) == 0 && Double.compare(nrOreAsistPartPractica, that.nrOreAsistPartPractica) == 0 && Double.compare(oreAsistPartDiploma, that.oreAsistPartDiploma) == 0 && Double.compare(oreNEasistSapt, that.oreNEasistSapt) == 0 && Double.compare(oreDocumentare, that.oreDocumentare) == 0 && Double.compare(oreStudiuIndividual, that.oreStudiuIndividual) == 0 && Double.compare(orePregLab, that.orePregLab) == 0 && Double.compare(oreNEasistSem, that.oreNEasistSem) == 0 && Double.compare(oreDocumentareSem, that.oreDocumentareSem) == 0 && Double.compare(oreStudiuIndividualSem, that.oreStudiuIndividualSem) == 0 && Double.compare(orePregLabSem, that.orePregLabSem) == 0 && Double.compare(totalOreSapt, that.totalOreSapt) == 0 && Double.compare(totalOreSem, that.totalOreSem) == 0 && Double.compare(nrCredite, that.nrCredite) == 0 && Double.compare(coeficientNotaFinalaCurs, that.coeficientNotaFinalaCurs) == 0 && Double.compare(coeficientNotaFinalaLaborator, that.coeficientNotaFinalaLaborator) == 0 && Double.compare(coeficientNotaFinalaProiect, that.coeficientNotaFinalaProiect) == 0 && Double.compare(coeficientNotaFinalaPrezenta, that.coeficientNotaFinalaPrezenta) == 0 && Objects.equals(denumireDisciplina, that.denumireDisciplina) && categFormativa == that.categFormativa && Objects.equals(titularCurs, that.titularCurs) && Objects.equals(titularAplicative, that.titularAplicative) && tipEvaluare == that.tipEvaluare && regimDisciplina == that.regimDisciplina && Objects.equals(precondCurriculum, that.precondCurriculum) && Objects.equals(precondCompetente, that.precondCompetente) && Objects.equals(condDesfCurs, that.condDesfCurs) && Objects.equals(condActPractice, that.condActPractice) && Objects.equals(compSpecifice, that.compSpecifice) && Objects.equals(compProfesionale, that.compProfesionale) && Objects.equals(compTransversale, that.compTransversale) && Objects.equals(obiectiveGenerale, that.obiectiveGenerale) && Objects.equals(obiectiveSpecifice, that.obiectiveSpecifice) && Objects.equals(curs, that.curs) && Objects.equals(metodePredareCurs, that.metodePredareCurs) && Objects.equals(bibliografieCurs, that.bibliografieCurs) && Objects.equals(lab, that.lab) && Objects.equals(metodePredareLab, that.metodePredareLab) && Objects.equals(bibliografieLab, that.bibliografieLab) && Objects.equals(coroborare, that.coroborare) && Objects.equals(tipActivitateCurs, that.tipActivitateCurs) && Objects.equals(criteriiEvaluareCurs, that.criteriiEvaluareCurs) && Objects.equals(metodeEvaluareCurs, that.metodeEvaluareCurs) && Objects.equals(tipActivitateLab, that.tipActivitateLab) && Objects.equals(criteriiEvaluareLaborator, that.criteriiEvaluareLaborator) && Objects.equals(metodeEvaluareLaborator, that.metodeEvaluareLaborator) && Objects.equals(tipActivitateProiect, that.tipActivitateProiect) && Objects.equals(criteriiEvaluareProiect, that.criteriiEvaluareProiect) && Objects.equals(metodeEvaluareProiect, that.metodeEvaluareProiect) && Objects.equals(tipActivitatePrezenta, that.tipActivitatePrezenta) && Objects.equals(criteriiEvaluarePrezenta, that.criteriiEvaluarePrezenta) && Objects.equals(metodeEvaluarePrezenta, that.metodeEvaluarePrezenta) && Objects.equals(datacompletarii, that.datacompletarii) && Objects.equals(dataAvizarii, that.dataAvizarii) && Objects.equals(standardMinPerformanta, that.standardMinPerformanta);
    }
}