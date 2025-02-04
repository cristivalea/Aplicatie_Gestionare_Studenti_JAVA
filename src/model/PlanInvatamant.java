package model;

import java.util.ArrayList;

public class PlanInvatamant {
    private static final String denumire = "Plan de invatamant";
    private String seria_de_studenti;
    private static final String universitatea = "Universitatea Politehnica Timisoara";
    private static final String facultatea = "Facultatea de Automatica si Calculatoare";
    private static final String program_studii = "TEHNOLOGIA INFORMATIEI";
    private static final String domeniu_fundamental = "STIINTE INGENERESTI";
    private static final String ramura_de_stiinte = "INGINERIA SISTEMELOR, CALCULATOARE ȘI TEHNOLOGIA INFORMAȚIEI";
    private static final String domeniu_de_licenta = "CALCULATOARE SI TEHNOLOGIA INFORMATIEI";
    private static final int durata_studii = 4;
    private static final int nr_credite = 240;
    private static final String forma_invatamant = "IF - Invatamant cu frecventa";
    private static final String misiune_program_studii = "Misiunea programului de studii este de a produce ingineri de înaltă calificare în domeniul Calculatoare și Tehnologia Informației având cunoștințe aprofundate, teoretice și practice, atât hardware cât și software și pregatirea lor pentru o carieră de succes în dezvoltarea tehnologiei informației.";
    private ArrayList<String> obiective_program_studii = new ArrayList<String>();
    private ArrayList<String> competente_profesionale = new ArrayList<String>();
    private ArrayList<String> competente_transversale = new ArrayList<String>();
    private ArrayList<String> ocupatii = new ArrayList<String>();
    private ArrayList<ArrayList<Disciplina>> discipline_obligatorii_semestru = new ArrayList<ArrayList<Disciplina>>();
    private ArrayList<ArrayList<Disciplina>> disciplie_optionael_semestru = new ArrayList<ArrayList<Disciplina>>();


}
