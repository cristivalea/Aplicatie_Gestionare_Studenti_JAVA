package XMLProcess;

import model.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import org.w3c.dom.Document;
import teste.Main2;

public class ProcesareFisaDisciplinei {

    //public final static String FILENAME = "D:\\JAVA\\Evidenta Studenti\\Evidenta_Studenti\\src\\XMLProcess\\PAA.xml";
    private final static String FOLDER_FISE_DISCIPLINE ="D:\\JAVA\\Evidenta Studenti\\FiseDiscipline\\";

    public static FisaDisciplinei getFisaDisciplina(String fileName) throws ParserConfigurationException, SAXException, IOException {
        String denumireDisciplinaFisa ="";
        CategorieFormativa categoriaFormativa = null;
        String titular = "";
        ArrayList<String> titularA = new ArrayList<String>();
        int anStudii = 0;
        int semestrul = 0;
        TipExamen tipEvaluare = null;
        RegimDisciplina regimDisc = null;

        File inputFile = new File(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(inputFile);
        d.getDocumentElement().normalize();


        NodeList nl1 = d.getElementsByTagName("Date_despre_disciplina");
        System.out.println("---------------------------");
        Node nl = nl1.item(0);
        System.out.println(nl.getNodeName());
        if(nl.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) nl;

            String numeDisciplina = e.getElementsByTagName("Denumirea_disciplinei").item(0).getTextContent().trim();
            if(numeDisciplina == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                denumireDisciplinaFisa = numeDisciplina;
                Main2.logger.info("Nume dsiciplina: " + numeDisciplina);
            }

            String categFormativa = e.getElementsByTagName("Categorie_formativa").item(0).getTextContent().trim();
            if(categFormativa == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                categoriaFormativa = CategorieFormativa.string2CategorieFormativa(categFormativa).get();
                Main2.logger.info("Categoria formativa: " + categFormativa);
            }
            String titularCurs = e.getElementsByTagName("Titularul_activitatilor_de_curs").item(0).getTextContent().trim();
            if(titularCurs == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                titular = titularCurs;
                Main2.logger.info("titular curs: " + titularCurs);
            }

            String string_sef_lucrari = e.getElementsByTagName("Titularul_activitatilor_aplicative").item(0).getTextContent().trim();
            if(string_sef_lucrari == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                Main2.logger.info("Titular activitati aplicative: " + string_sef_lucrari);
                Scanner sc1 = new Scanner(string_sef_lucrari);
                sc1.useDelimiter(",");
                ArrayList<String> sef_lucrari = new ArrayList<String>();
                while (sc1.hasNext()) {
                    sef_lucrari.add(sc1.next());
                }
                titularA = sef_lucrari;
                Main2.logger.info("Sef lucrari: " + sef_lucrari);
            }

            int an = -1;
            String string_an = e.getElementsByTagName("Anul_de_studiu").item(0).getTextContent().trim();
            if(string_an == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                an = Integer.parseInt(string_an);
                anStudii = an;
                Main2.logger.info("An studiu: " + an);
            }

            int semestru = -1;
            String string_sem = e.getElementsByTagName("Semestrul").item(0).getTextContent().trim();
            if(string_sem == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                semestru = Integer.parseInt(string_sem);
                semestrul = semestru;
                Main2.logger.info("Semestrul: " + semestru);
            }

            String tip_evaluare = "";
            String string_tip_evaluare = e.getElementsByTagName("Tipul_de_evaluare").item(0).getTextContent().trim();
            if(string_tip_evaluare == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                tip_evaluare = string_tip_evaluare;
                tipEvaluare = TipExamen.string2CategorieFormativa(tip_evaluare).get();
                Main2.logger.info("Tip de evaluare: " + tip_evaluare);
            }

            String regimulDisciplinei = e.getElementsByTagName("Regimul_disciplinei").item(0).getTextContent().trim();
            if(regimulDisciplinei == null){
                System.err.println("Nu exista valoare!");
            }
            else
                regimDisc = RegimDisciplina.string2CategorieFormativa(regimulDisciplinei).get();
                 Main2.logger.info("Regimul disciplinei: " + regimulDisciplinei);
        }//enf if verificare element

        double oreTotaleAsistIntegralSapt = -1;
        double oreCursIntegralSapt = -1;
        double oreLabIntegralSapt = -1;
        double oreTotalAsistIntegralSem = -1;
        double oreCursIntegralSem = -1;
        double oreLabIntegralSem = -1;
        double oreTotalAsistPartSapt = -1;
        double oreCursPartsapt = -1;
        double oreLabPartSapt = -1;
        double oreTotalAsistPartSem = -1;
        double oreCursPartSem = -1;
        double oreLabParSem = -1;
        double oreNeasistateSapt = -1;
        double oreDocSupsapt = -1;
        double oreStudiuIndividualSapt = -1;
        double orePregLabSapt = -1;
        double oreNeasistateSem = -1;
        double oreDocSupSem = -1;
        double oreStudiuIndividualSem = -1;
        double orePregLabSem = -1;
        double totalSapt = -1;
        double TotalSem = -1;
        double nrCrediteDisciplina = -1;

        NodeList nl2 = d.getElementsByTagName("Timp_total_estimat_ore_pe_semestru_activitati_didactice_directe_aistate_integral_sau_asistate_partial_si_activitati_de_pregatire_individuala_neasistate");
        System.out.println("---------------------------");
        Node n2 = nl2.item(0);
        System.out.println(n2.getNodeName());
        if(n2.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n2;

            NodeList nl21 = d.getElementsByTagName("Numar_de_ore_asistat_integral_pe_saptamana");
            System.out.println("---------------------------");
            Node n21 = nl21.item(0);
            System.out.println(n21.getNodeName());
            if(n21.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n21;

                double valoare = -1;
                String string_val = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(string_val == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    valoare = Double.parseDouble(string_val);
                    oreTotaleAsistIntegralSapt = valoare;
                    Main2.logger.info("Valoare ore asistate saptamana: " + valoare);
                }

                double ore_curs = -1;
                String string_ore_curs = e1.getElementsByTagName("Ore_curs").item(0).getTextContent().trim();
                if(string_ore_curs == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    ore_curs = Double.parseDouble(string_ore_curs);
                    oreCursIntegralSapt = ore_curs;
                    Main2.logger.info("Numar ore curs: " + ore_curs);
                }

                double ore_lab = -1;
                String string_ore_lab = e1.getElementsByTagName("Ore_seminar_laborator_proiect").item(0).getTextContent().trim();
                if(string_ore_lab == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    ore_lab = Double.parseDouble(string_ore_lab);
                    oreLabIntegralSapt = ore_lab;
                    Main2.logger.info("Numar ore de laborator pe saptamnana: " + ore_lab);
                }
            }//end if n21

            NodeList nl22 = d.getElementsByTagName("Numar_total_de_ore_asistat_pe_semestru");
            System.out.println("---------------------------");
            Node n22 = nl22.item(0);
            System.out.println(n22.getNodeName());
            if(n22.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n22;

                double nr_ore_sem = -1;
                String str_ore_sem = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(str_ore_sem == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    nr_ore_sem = Double.parseDouble(str_ore_sem);
                    oreTotalAsistIntegralSem = nr_ore_sem;
                    Main2.logger.info("Nr de ore pe semestru: " + nr_ore_sem);
                }

                double nr_ore_curs = -1;
                String string_ore_curs = e1.getElementsByTagName("Ore_de_curs").item(0).getTextContent().trim();
                if(string_ore_curs == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    nr_ore_curs = Double.parseDouble(string_ore_curs);
                    oreCursIntegralSem = nr_ore_curs;
                    Main2.logger.info("Nr de ore de curs pe semestru: " + nr_ore_curs);
                }

                double nr_ore_lab = -1;
                String string_ore_lab = e1.getElementsByTagName("Ore_seminar_laborator_proiect").item(0).getTextContent().trim();
                if(string_ore_lab == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    nr_ore_lab = Double.parseDouble(string_ore_lab);
                    oreLabIntegralSem = nr_ore_lab;
                    Main2.logger.info("Numarul de ore de laborator:  " + nr_ore_lab);
                }
            }// end if n22

            NodeList nl23 = d.getElementsByTagName("Numade_de_ore_asistate_partial_saptamana");
            System.out.println("---------------------------");
            Node n23 = nl23.item(0);
            System.out.println(n23.getNodeName());
            if(n23.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n23;

                double nr_total_ore = -1;
                String string_nr_total_ore = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(string_nr_total_ore == null){
                    System.err.println("Nu exista valoarea!");
                }
                else {
                    nr_total_ore = Double.parseDouble(string_nr_total_ore);
                    oreTotalAsistPartSapt = nr_total_ore;
                    Main2.logger.info("Nr de ore asistate partial pe saptamana: " + nr_total_ore);
                }

                double ore_curs = -1;
                String string_ore_practica = e1.getElementsByTagName("Ore_de_practica").item(0).getTextContent().trim();
                if(string_ore_practica == null){
                    System.err.println("Nu exist valoare");
                }
                else{
                    ore_curs = Double.parseDouble(string_ore_practica);
                    oreCursPartsapt = ore_curs;
                    Main2.logger.info("Nr de ore de practica: " + ore_curs);
                }

                double ore_elab_proiect = -1;
                String string_elab_proiect = e1.getElementsByTagName("Ore_elaborare_proiect_de_diploma").item(0).getTextContent().trim();
                if(string_elab_proiect == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_elab_proiect = Double.parseDouble(string_elab_proiect);
                    oreLabPartSapt = ore_elab_proiect;
                    Main2.logger.info("Nr ore de elaborare proiect de diploma:  " + ore_elab_proiect);
                }
            }// end if n23

            NodeList nl24 = d.getElementsByTagName("Numar_total_de_ore_asistate_partial_semestru");
            System.out.println("---------------------------");
            Node n24 = nl24.item(0);
            System.out.println(n24.getNodeName());
            if(n24.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n24;

                double nr_total_ore = -1;
                String string_nr_total_ore = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(string_nr_total_ore == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    nr_total_ore = Double.parseDouble(string_nr_total_ore);
                    oreTotalAsistPartSem = nr_total_ore;
                    Main2.logger.info("Nr total de ore asistate partial pe semestru: " + nr_total_ore);
                }

                double ore_practica = -1;
                String string_ore_practica = e1.getElementsByTagName("Ore_de_Practica").item(0).getTextContent().trim();
                if(string_ore_practica == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    ore_practica = Double.parseDouble(string_ore_practica);
                    oreCursPartSem = ore_practica;
                    Main2.logger.info("Ore de practica: " + ore_practica);
                }

                double ore_diploma = -1;
                String string_ore_diploma = e1.getElementsByTagName("Ore_elaborare_proiect_de_diploma").item(0).getTextContent().trim();
                if(string_ore_diploma == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    ore_diploma = Double.parseDouble(string_ore_diploma);
                    oreLabParSem = ore_diploma;
                    Main2.logger.info("Ore pregatire proiect de diploma: " + ore_diploma);
                }
            }// end if n24

            NodeList nl25 = d.getElementsByTagName("Numar_de_activitati_neasistate_pe_saptamana");
            System.out.println("---------------------------");
            Node n25 = nl25.item(0);
            System.out.println(n25.getNodeName());
            if(n25.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n25;

                double nr_total = -1;
                String string_nr_total = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(string_nr_total == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    nr_total = Double.parseDouble(string_nr_total);
                    oreNeasistateSapt = nr_total;
                    Main2.logger.info("Nr total de ore neasistate: " + nr_total);
                }

                double ore_doc_suplimentara = -1;
                String string_ore_doc_sup = e1.getElementsByTagName("Ore_documentare_suplimentara").item(0).getTextContent().trim();
                if(string_ore_doc_sup == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_doc_suplimentara = Double.parseDouble(string_ore_doc_sup);
                    oreDocSupsapt = ore_doc_suplimentara;
                    Main2.logger.info("Ore documentare suplimentare: " + ore_doc_suplimentara);
                }

                double ore_studiu_ind = -1;
                String string_ore_studiu_ind = e1.getElementsByTagName("Ore_studiu_individual").item(0).getTextContent().trim();
                if(string_ore_studiu_ind == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_studiu_ind = Integer.parseInt(string_ore_studiu_ind);
                    oreStudiuIndividualSapt = ore_studiu_ind;
                    Main2.logger.info("Ore de studiu individual: " + ore_studiu_ind);
                }

                double ore_preg_lab = -1;
                String string_ore_preg_lab = e1.getElementsByTagName("Ore_pregatire_seminarii_laborator").item(0).getTextContent().trim();
                if(string_ore_preg_lab == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_preg_lab = Double.parseDouble(string_ore_preg_lab);
                    orePregLabSapt = ore_preg_lab;
                    Main2.logger.info("Ore de pregatire a laboratorului: " + ore_preg_lab);
                }
            }// end if n25

            NodeList nl26 = d.getElementsByTagName("Numar_total_de_ore_de_activitati_neasistate_semestru");
            System.out.println("---------------------------");
            Node n26 = nl26.item(0);
            System.out.println(n26.getNodeName());
            if(n26.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n26;

                double ore_totale = -1;
                String string_ore_totale = e1.getElementsByTagName("Valoare").item(0).getTextContent().trim();
                if(string_ore_totale == null){
                    System.err.println("Nu exista valoare");
                }
                else{
                    ore_totale = Double.parseDouble(string_ore_totale);
                    oreNeasistateSem = ore_totale;
                    Main2.logger.info("Ore totale neasistate pe semestru: " + ore_totale);
                }

                double ore_doc_sup = -1;
                String string_ore_doc_sup = e1.getElementsByTagName("Ore_documentare_suplimentara").item(0).getTextContent().trim();
                if(string_ore_doc_sup == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_doc_sup = Double.parseDouble(string_ore_doc_sup);
                    oreDocSupSem = ore_doc_sup;
                    Main2.logger.info("Ore de doc suplimetara neasistate: " + ore_doc_sup);
                }

                double ore_studiu_ind = -1;
                String string_ore_studiu_ind = e1.getElementsByTagName("Ore_de_studiu_individual").item(0).getTextContent().trim();
                if(string_ore_studiu_ind == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_studiu_ind = Integer.parseInt(string_ore_studiu_ind);
                    oreStudiuIndividualSem = ore_studiu_ind;
                    Main2.logger.info("Ore de studiu individual neasistate: " + ore_studiu_ind);
                }

                double ore_preg_lab = -1;
                String string_ore_preg_lab = e1.getElementsByTagName("Ore_pregatire_seminarii_laboratoare").item(0).getTextContent().trim();
                if(string_ore_preg_lab == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    ore_preg_lab = Double.parseDouble(string_ore_preg_lab);
                    orePregLabSem = ore_preg_lab;
                    Main2.logger.info("Ore de pregatire lab neasistate: " + ore_preg_lab);
                }
            }// end if n26

                double total_ore_sapt = -1;
                String string_total_ore_sapt = e.getElementsByTagName("Total_ore_pe_saptaman").item(0).getTextContent().trim();
                if (string_total_ore_sapt == null) {
                    System.err.println("Nu exista valoarea!");
                } else {
                    total_ore_sapt = Double.parseDouble(string_total_ore_sapt);
                    totalSapt = total_ore_sapt;
                    Main2.logger.info("Nr total de ore pe saptamana: " + total_ore_sapt);
                }

               double total_ore_sem = -1;
                String string_total_ore_sem = e.getElementsByTagName("Total_ore_pe_semestru").item(0).getTextContent().trim();
                if(string_total_ore_sem == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    total_ore_sem = Double.parseDouble(string_total_ore_sem);
                    TotalSem = total_ore_sem;
                    Main2.logger.info("total ore pe semestru: " + total_ore_sem);
                }

                double nr_credite = 0;
                String string_nr_credite = e.getElementsByTagName("Numar_de_credite").item(0).getTextContent().trim();
                if(string_nr_credite == null){
                    System.err.println("Nu exista valoarea!");
                }
                else{
                    nr_credite = Double.parseDouble(string_nr_credite);
                    nrCrediteDisciplina = nr_credite;
                    Main2.logger.info("Nr de credite: " + nr_credite);
                }
        }//end if n2

        ArrayList<Disciplina> listaCurriculum = new ArrayList<Disciplina>();
        String listaCompetente = "";

        NodeList nl3 = d.getElementsByTagName("Preconditii_unde_este_cazul");
        System.out.println("---------------------------");
        Node n3 = nl3.item(0);
        System.out.println(n3.getNodeName());
        if (n3.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n3;
                try {
                    ArrayList<Disciplina> curriculum = new ArrayList<Disciplina>();
                        String string_curriculum = e.getElementsByTagName("curriculum").item(0).getTextContent().trim();
                        Scanner sc2 = new Scanner(string_curriculum);
                        sc2.useDelimiter(",");
                        if (string_curriculum == null) {
                            System.err.println("Nu exista valoare!");
                        }
                        while (sc2.hasNext()) {
                            String denumireDisciplina = sc2.next();
                            for (Disciplina dis : Repository.getInstance().getDiscipline()) {
                                if (dis.getNumeDisciplina().equals(denumireDisciplina)) {
                                    curriculum.add(dis);
                                }// end id cautare disciplina
                            } // end for parcurgere lista discipline rep
                        }// end while
                        Main2.logger.info("Discipline curriculum: " + curriculum);
                        listaCurriculum = curriculum;
                    }catch (Exception ee){
                        ee.printStackTrace();
                    }

                String competente = e.getElementsByTagName("competente").item(0).getTextContent().trim();
                if(competente == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    listaCompetente = competente;
                    Main2.logger.info("Competente: " + competente);
                }//end if atribuire
        }// end if n3

        String conDesfCurs = "";
        String condDesfActAplicat = "";

        NodeList nl4 = d.getElementsByTagName("Conditii_unde_este_cazul");
        System.out.println("---------------------------");
        Node n4 = nl4.item(0);
        System.out.println(n4.getNodeName());
        if(n4.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n4;

            String desfasurare_curs = e.getElementsByTagName("de_desfasurare_a_cursului").item(0).getTextContent().trim();
            if(desfasurare_curs == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                conDesfCurs = desfasurare_curs;
                Main2.logger.info("Conditii dsfasurare curs: " + desfasurare_curs);
            }

            String desfasurare_aplicative = e.getElementsByTagName("de_desfasurare_a_activitatilor_aplicative").item(0).getTextContent().trim();
            if(desfasurare_aplicative == null){
                System.err.println("Nu exista valoare!");
            }
            else {
                condDesfActAplicat = desfasurare_aplicative;
                Main2.logger.info("Conditii de desfasurare activitati aplicative: " + desfasurare_aplicative);
            }
        }//end if n4

        ArrayList<String> listaCompetenteSpecifice = new ArrayList<String>();
        ArrayList<String> listaCompetenteProfesionale = new ArrayList<String>();
        ArrayList<String> listaCompetenteTransversale = new ArrayList<String>();

        NodeList nl5 = d.getElementsByTagName("Competente_la_formarea_carora_contribuie_disciplina");
        System.out.println("---------------------------");
        Node n5 = nl5.item(0);
        System.out.println(n5.getNodeName());
        if(n5.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n5;

            NodeList nl51 = d.getElementsByTagName("Competente_specifice");
            System.out.println("---------------------------");
            Node n51 = nl51.item(0);
            System.out.println(n51.getNodeName());
            ArrayList<String> competenteSpecifice = new ArrayList<String>();
            if(n51.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n51;

                NodeList listaNoduriCS =  e1.getElementsByTagName("CS");
                for(int i = 0; i < listaNoduriCS.getLength(); i++){
                   Node nodeCS =  listaNoduriCS.item(i);
                   String competenta = nodeCS.getTextContent();
                   competenteSpecifice.add(competenta);
                   Main2.logger.info("Competenta: " + competenta);
                }// end for
            }// end if n51 comp specifice
            listaCompetenteSpecifice = competenteSpecifice;
            Main2.logger.info("Lista competente specifice: " + competenteSpecifice);

            ArrayList<String> competenteProfesionale = new ArrayList<String>();
            NodeList nl52 = d.getElementsByTagName("Competentele_profesionale_in_care_se_inscriu_competentele_specifice");
            System.out.println("---------------------------");
            Node n52 = nl52.item(0);
            System.out.println(n52.getNodeName());
            if(n52.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n52;

                NodeList listaNoduriCP = e1.getElementsByTagName("CP");
                for(int i = 0; i < listaNoduriCP.getLength(); i++){
                    Node nodeCP = listaNoduriCP.item(i);
                    String competenta = nodeCP.getTextContent();
                    competenteProfesionale.add(competenta);
                }//end for
            }//end if
            listaCompetenteProfesionale = competenteProfesionale;
            Main2.logger.info("Competente profesionale: " + competenteProfesionale);

            ArrayList<String> competenteTransversale = new ArrayList<String>();
            NodeList nl53 = d.getElementsByTagName("Competente_transversale_in_care_se_inscriu_competentele_specifice");
            System.out.println("---------------------------");
            Node n53 = nl53.item(0);
            System.out.println(n53.getNodeName());
            if(n53.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n53;

                NodeList listaNoduriCT = e1.getElementsByTagName("CT");
                for(int i = 0; i < listaNoduriCT.getLength(); i++){
                    Node nodeCT = listaNoduriCT.item(i);
                    String competenta = nodeCT.getTextContent();
                    competenteTransversale.add(competenta);
                }//end for
            }// end if
            listaCompetenteTransversale = competenteTransversale;
            Main2.logger.info("Competente transversale: " + competenteTransversale);
        }// end n5

        ArrayList<String> obiectiveGenerale = new ArrayList<String>();
        ArrayList<String> obiectiveSpecifice = new ArrayList<String>();

        NodeList nl6 = d.getElementsByTagName("Obiectivele_disciplinei_asociate_punctului_anterior");
        System.out.println("---------------------------");
        Node n6 = nl6.item(0);
        System.out.println(n6.getNodeName());
        if(n6.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n6;

            NodeList nl61 = d.getElementsByTagName("Obiectivul_general_al_disciplinei");
            System.out.println("---------------------------");
            Node n61 = nl61.item(0);
            System.out.println(n61.getNodeName());
            if(n61.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n61;

                NodeList listaNoduriOG = e1.getElementsByTagName("OG");
                for(int i = 0; i < listaNoduriOG.getLength(); i++){
                    Node nodeOG = listaNoduriOG.item(i);
                    String obiectivGeneral = nodeOG.getTextContent().trim();
                    obiectiveGenerale.add(obiectivGeneral);
                }//end for
            }//end if n61
            Main2.logger.info("Obiective generale: " + obiectiveGenerale);

            NodeList nl62 = d.getElementsByTagName("Obiectivele_specifice");
            System.out.println("---------------------------");
            Node n62 = nl62.item(0);
            System.out.println(n62.getNodeName());
            if(n62.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n62;

                NodeList listaOS = e1.getElementsByTagName("OS");
                for(int i = 0; i < listaOS.getLength(); i++){
                    Node nodeOS = listaOS.item(i);
                    String obiectivSpecific = nodeOS.getTextContent().trim();
                    obiectiveSpecifice.add(obiectivSpecific);
                }//end for
            }//end if n62
            Main2.logger.info("Obiective specifice: " + obiectiveSpecifice);
        }// end if n6

        //CONTINUT CURS
        ArrayList<Pereche<String, Integer>> curs = new ArrayList<Pereche<String, Integer>>();
        String metodeleDePredare = "";
        ArrayList<Publicatie> bibliografieCurs = new ArrayList<Publicatie>();
        ArrayList<Pereche<String, Integer>> laborator = new ArrayList<Pereche<String, Integer>>();
        String metodeleDePredareLab = "";
        ArrayList<Publicatie> bibliografieLab = new ArrayList<Publicatie>();

        NodeList nl7 = d.getElementsByTagName("Curs");
        for(int i = 0; i < nl7.getLength(); i++){
            Node nodCurs = nl7.item(i);
            int id = Integer.parseInt(nodCurs.getAttributes().item(0).getTextContent());
            Element e1 = (Element) nodCurs;
            String continut = e1.getElementsByTagName("Continut").item(0).getTextContent().trim();
            if(continut == null){
                System.err.println("NU exista valoare!");
            }
            else{
                Main2.logger.info("Continutul cursului: " + continut);
            }

            int nr_ore = -1;
            String string_nr_ore = e1.getElementsByTagName("Numar_de_ore").item(0).getTextContent().trim();
            if(string_nr_ore == null){
                System.err.println("Nu exista valoare!");
            }
            else{
                nr_ore = Integer.parseInt(string_nr_ore);
                Main2.logger.info("Nr de ore:" + nr_ore);
            }

            Pereche<String, Integer> p = new Pereche<String, Integer>(continut,nr_ore);
            curs.add(p);
        }//end for curs
        Main2.logger.info("Curs: " + curs);

        String metodeDePredareCurs = d.getElementsByTagName("Metode_de_predare_curs").item(0).getTextContent().trim();
        if(metodeDePredareCurs == null){
            System.err.println("Nu exista valoarea!");
        }
        else{
            metodeleDePredare = metodeDePredareCurs;
            Main2.logger.info("Metode predare curs: " + metodeDePredareCurs);
        }// end metode de predare ccurs


        NodeList nl8 = d.getElementsByTagName("Bibliografie_Curs");
        Element e2 = (Element) nl8.item(0);
        NodeList listaPublicatiiCurs = e2.getElementsByTagName("Publicatie");
        for(int i = 0; i < listaPublicatiiCurs.getLength(); i++){
            Node nodPublicatie = listaPublicatiiCurs.item(i);
            Element e21 = (Element) nodPublicatie;
            String autori = e21.getElementsByTagName("Autor").item(0).getTextContent().trim();
            if(autori == null){
                System.err.println("Nu exista valoare");
            }
            else{
                Main2.logger.info("Autori: " + autori);
            }//end if autori

            String titlu = e21.getElementsByTagName("Titlu").item(0).getTextContent().trim();
            if(titlu == null){
                System.err.println("Nu exista informatie!");
            }
            else {
                Main2.logger.info("Titlu: " + titlu);
            }// end if titlu

            String editura = e21.getElementsByTagName("Editura").item(0).getTextContent().trim();
            if(editura == null){
                System.err.println("Nu exista informatie!");
            }
            else{
                Main2.logger.info("Editura: " + editura);
            }// end if editura

            String orasAparitie = e21.getElementsByTagName("Oras").item(0).getTextContent().trim();
            if(orasAparitie == null){
                System.err.println("Nu exista informatie!");
            }
            else{
                Main2.logger.info("Oras Aparitie: " + orasAparitie);
            }// end if oras aparitie

            int anAparitie = -1;
            String stringAnAparitie = e21.getElementsByTagName("Anul_aparitiei").item(0).getTextContent().trim();
            if(stringAnAparitie == null){
                System.err.println("Nu exista informatie");
            }
            else{
                anAparitie = Integer.parseInt(stringAnAparitie);
                Main2.logger.info("Anul aparitiei: " + anAparitie);
            }// end if an aparitie
            Publicatie publicatie = new Publicatie(titlu, editura,orasAparitie, anAparitie, autori);
            bibliografieCurs.add(publicatie);
        }//end for

        //ACTIVITATI APLICATIVE
        NodeList nl9 = d.getElementsByTagName("Laborator");
        for(int i = 0; i < nl9.getLength(); i++){
            Node nodLab = nl9.item(i);
            int id = Integer.parseInt(nodLab.getAttributes().item(0).getTextContent());
            Element e1 = (Element) nodLab;
            String continut = e1.getElementsByTagName("Continut").item(0).getTextContent().trim();
            if(continut == null){
                System.err.println("Nu exita valoare!");
            }
            else{
                Main2.logger.info("Continut laborator: " + continut);
            }// end if

            int nr_ore = -1;
            String string_nr_ore = e1.getElementsByTagName("Ore").item(0).getTextContent().trim();
            if(string_nr_ore == null){
                System.err.println("Nu exista valoare!");
            }
            else{
                nr_ore = Integer.parseInt(string_nr_ore);
                Main2.logger.info("Nr de ore:" + nr_ore);
            }

            Pereche<String, Integer> p = new Pereche<String, Integer>(continut,nr_ore);
            laborator.add(p);
        }// end for lab
        Main2.logger.info("Laborator: " + laborator);

        String metodeDePredareLab = d.getElementsByTagName("Metode_de_predare_lab").item(0).getTextContent().trim();
        if(metodeDePredareLab == null){
            System.err.println("Nu exista valoarea!");
        }
        else{
            metodeleDePredareLab = metodeDePredareLab;
            Main2.logger.info("Metode predare lab: " + metodeDePredareLab);
        }// end metode de predare ccurs

        NodeList nl81 = d.getElementsByTagName("Bibliografie_Lab");
        Element e3 = (Element) nl81.item(0);
        NodeList listaPublicatiiLab = e3.getElementsByTagName("Publicatie");
        for(int i = 0; i < listaPublicatiiLab.getLength(); i++){
            Node nodPublicatie = listaPublicatiiLab.item(i);
            Element e31 = (Element) nodPublicatie;
            String autori = e31.getElementsByTagName("Autor").item(0).getTextContent().trim();
            if(autori == null){
                System.err.println("Nu exista valoare");
            }
            else{
                Main2.logger.info("Autori: " + autori);
            }//end if autori

            String titlu = e31.getElementsByTagName("Titlu").item(0).getTextContent().trim();
            if(titlu == null){
                System.err.println("Nu exista informatie!");
            }
            else {
                Main2.logger.info("Titlu: " + titlu);
            }// end if titlu

            String editura = e31.getElementsByTagName("Editura").item(0).getTextContent().trim();
            if(editura == null){
                System.err.println("Nu exista informatie!");
            }
            else{
                Main2.logger.info("Editura: " + editura);
            }// end if editura

            String orasAparitie = e31.getElementsByTagName("Oras").item(0).getTextContent().trim();
            if(orasAparitie == null){
                System.err.println("Nu exista informatie!");
            }
            else{
                Main2.logger.info("Oras Aparitie: " + orasAparitie);
            }// end if oras aparitie

            int anAparitie = -1;
            String stringAnAparitie = e31.getElementsByTagName("Anul_aparitiei").item(0).getTextContent().trim();
            if(stringAnAparitie == null){
                System.err.println("Nu exista informatie");
            }
            else{
                anAparitie = Integer.parseInt(stringAnAparitie);
                Main2.logger.info("Anul aparitiei: " + anAparitie);
            }// end if an aparitie
            Publicatie publicatie = new Publicatie(titlu, editura,orasAparitie, anAparitie, autori);
            bibliografieLab.add(publicatie);
        }//end for

        //END CONTINUTURI

        ArrayList<String> coroborareContinut = new ArrayList<String>();
        NodeList nl10 = d.getElementsByTagName("Coroborarea_continutului_disciplinei_cu_asteptarile_reprezentantilor_comunitatii_epistemice_asociatiilor_profesionale_si_angajatori_reprezentativi_din_domeniul_aferent_programului");
        System.out.println("---------------------------");
        Node n10 = nl10.item(0);
        System.out.println(n10.getNodeName());
        if(n10.getNodeType() == Node.ELEMENT_NODE){
            Element e1 = (Element) n10;

            NodeList listaNoduriCoroborare = e1.getElementsByTagName("CR");
            for(int i = 0; i < listaNoduriCoroborare.getLength(); i++){
                Node nodeCoroborare = listaNoduriCoroborare.item(i);
                String coroborare = nodeCoroborare.getTextContent();
                coroborareContinut.add(coroborare);
            }//end for
        }// end if
        Main2.logger.info("Coroborare continut: " + coroborareContinut);

        //EVALUARE

        //curs
        String numeActivitateCurs = "";
        String numeCritevalCurs = "";
        String numeMetEvalCurs = "";
        double coefCurs = -1;
        //curs

        //laborator
        String numeActivitateLab = "";
        String numeCritEvalLab = "";
        String numeMetEvalLab = "";
        double coefLab = -1;
        //Laborator

        //Proiect
        String numeActivitateProiect = "";
        String numeCritEvalProiect = "";
        String numeMetEvalProiect = "";
        double coefProiect = -1;
        //Proiect

        //Prezenta
        String numeActivitatePrezenta = "";
        String numeCritEvalPre = "";
        String numeMetEvalPrez = "";
        double coefPrez = -1;
        //Prezenta

        String standardMinimPerformanta = "";

        NodeList nl11 = d.getElementsByTagName("Evaluare");
        System.out.println("---------------------------");
        Node n11 = nl11.item(0);
        System.out.println(n11.getNodeName());
        if(n11.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n11;

            NodeList nl111 = d.getElementsByTagName("Activitate_curs");
            System.out.println("---------------------------");
            Node n111 = nl111.item(0);
            System.out.println(n111.getNodeName());
            if(n111.getNodeType() ==  Node.ELEMENT_NODE){
                Element e1 = (Element) n111;

                String denumire = e1.getElementsByTagName("Denumire").item(0).getTextContent().trim();
                if(denumire == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    numeActivitateCurs = denumire;
                    Main2.logger.info("Denumire: " + denumire);
                }//end if denumire

                String criteriiEvaluare = e1.getElementsByTagName("Criterii_de_evaluare").item(0).getTextContent().trim();
                if(criteriiEvaluare == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    numeCritevalCurs = criteriiEvaluare;
                    Main2.logger.info("Criterii de evaluare curs: " + criteriiEvaluare);
                }// end if criterii de evaluare

                String metodeEvaluare = e1.getElementsByTagName("Metode_de_evaluare").item(0).getTextContent().trim();
                if(metodeEvaluare == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    numeMetEvalCurs = metodeEvaluare;
                    Main2.logger.info("Metode de evaluare: " + metodeEvaluare);
                }// end if metode de evaluare

                double pondereCurs = -1;
                String string_pondere_curs= e1.getElementsByTagName("Pondere_din_nota_finala").item(0).getTextContent().trim();
                if(string_pondere_curs == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    coefCurs = pondereCurs;
                    pondereCurs = Double.parseDouble(string_pondere_curs);
                    Main2.logger.info("Pondere curs: " + pondereCurs);
                }// end if pondere curs
            }// end if n111

            NodeList nl112 = d.getElementsByTagName("Activitate_activitati_aplicative");
            System.out.println("---------------------------");
            Node n112 = nl112.item(0);
            System.out.println(n112.getNodeName());
            if(n112.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n112;

                String denumire = e1.getElementsByTagName("Denumire").item(0).getTextContent().trim();
                if(denumire == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    numeActivitateLab = denumire;
                    Main2.logger.info("Denumire activitati aplicative: " + denumire);
                }// end if denumire activitati aplicative

                String criteriiEvaluare = e1.getElementsByTagName("Criterii_de_evaluare").item(0).getTextContent().trim();
                if(criteriiEvaluare == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    numeCritEvalLab = criteriiEvaluare;
                    Main2.logger.info("Creiterii de evaluare lab: " + criteriiEvaluare);
                }// end criterii evaluare

                String metodeEvaluare = e1.getElementsByTagName("Metode_de_evaluare").item(0).getTextContent().trim();
                if(metodeEvaluare == null){
                    System.err.println("NU exista informtie!");
                }
                else{
                    numeMetEvalLab = metodeEvaluare;
                    Main2.logger.info("Metode de evaluare: " + metodeEvaluare);
                }// end if metode de evaluare

                double pondereLab = -1;
                String string_pondere_lab = e1.getElementsByTagName("Pondere_din_nota_finala").item(0).getTextContent().trim();
                if(string_pondere_lab == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    coefLab = pondereLab;
                    pondereLab = Double.parseDouble(string_pondere_lab);
                    Main2.logger.info(string_pondere_lab);
                }// end if pondere lab
            }// end if n112

            NodeList nl113 = d.getElementsByTagName("Proiect");
            System.out.println("---------------------------");
            Node n113 = nl113.item(0);
            System.out.println(n113.getNodeName());
            if(n113.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n113;

                String denumire = e1.getElementsByTagName("Denumire").item(0).getTextContent().trim();
                if(denumire == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    numeActivitateProiect = denumire;
                    Main2.logger.info("Denumire activitati aplicative: " + denumire);
                }// end if denumire activitati aplicative

                String criteriiEvaluare = e1.getElementsByTagName("Criterii_de_evaluare").item(0).getTextContent().trim();
                if(criteriiEvaluare == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    numeCritEvalProiect = criteriiEvaluare;
                    Main2.logger.info("Creiterii de evaluare lab: " + criteriiEvaluare);
                }// end criterii evaluare

                String metodeEvaluare = e1.getElementsByTagName("Metode_de_evaluare").item(0).getTextContent().trim();
                if(metodeEvaluare == null){
                    System.err.println("NU exista informtie!");
                }
                else{
                    numeMetEvalProiect = metodeEvaluare;
                    Main2.logger.info("Metode de evaluare: " + metodeEvaluare);
                }// end if metode de evaluare

                double pondereProiect = -1;
                String string_pondere_proiect = e1.getElementsByTagName("Pondere_nota_finala").item(0).getTextContent().trim();
                if(string_pondere_proiect == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    coefProiect = pondereProiect;
                    pondereProiect = Double.parseDouble(string_pondere_proiect);
                    Main2.logger.info(string_pondere_proiect);
                }// end if pondere lab
            }// end if n113

            NodeList nl114 = d.getElementsByTagName("Prezenta");
            System.out.println("---------------------------");
            Node n114 = nl114.item(0);
            System.out.println(n114.getNodeName());
            if(n113.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n114;

                String denumire = e1.getElementsByTagName("Denumire").item(0).getTextContent().trim();
                if(denumire == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    numeActivitatePrezenta = denumire;
                    Main2.logger.info("Denumire activitati aplicative: " + denumire);
                }// end if denumire activitati aplicative

                String criteriiEvaluare = e1.getElementsByTagName("Criterii_de_evaluare").item(0).getTextContent().trim();
                if(criteriiEvaluare == null){
                    System.err.println("Nu exista valoare!");
                }
                else {
                    numeCritEvalPre = criteriiEvaluare;
                    Main2.logger.info("Creiterii de evaluare lab: " + criteriiEvaluare);
                }// end criterii evaluare

                String metodeEvaluare = e1.getElementsByTagName("Metode_de_evaluare").item(0).getTextContent().trim();
                if(metodeEvaluare == null){
                    System.err.println("NU exista informtie!");
                }
                else{
                    numeMetEvalPrez = metodeEvaluare;
                    Main2.logger.info("Metode de evaluare: " + metodeEvaluare);
                }// end if metode de evaluare

                double ponderePrezenta = -1;
                String string_pondere_prezenta = e1.getElementsByTagName("Pondere_nota_finala").item(0).getTextContent().trim();
                if(string_pondere_prezenta == null){
                    System.err.println("Nu exista informatie!");
                }
                else{
                    coefPrez = ponderePrezenta;
                    ponderePrezenta = Double.parseDouble(string_pondere_prezenta);
                    Main2.logger.info(string_pondere_prezenta);
                }// end if pondere lab
            }// end if n114

            String standardMinim = e.getElementsByTagName("Standardul_minim_de_performanta").item(0).getTextContent().trim();
            if(standardMinim == null){
                System.err.println("Nu exista informatie!");
            }
            else{
                standardMinimPerformanta = standardMinim;
                Main2.logger.info("Standard minim de performanta: " + standardMinim);
            }// end if standard minim performanta
        }//end if n11

        //Data completarii
        int ziC = -1;
        int lunaC = -1;
        int anC = -1;

        NodeList nl12 = d.getElementsByTagName("Data_completarii");
        System.out.println("---------------------------");
        Node n12 = nl12.item(0);
        System.out.println(n12.getNodeName());
        if(n12.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n12;

            NodeList nl121 = d.getElementsByTagName("Data");
            System.out.println("---------------------------");
            Node n121 = nl121.item(0);
            System.out.println(n121.getNodeName());
            if(n121.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n121;

                int zi = -1;
                String string_zi = e1.getElementsByTagName("zi").item(0).getTextContent().trim();
                if(string_zi == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    zi = Integer.parseInt(string_zi);
                    ziC = zi;
                    Main2.logger.info("Zi: " + zi);
                }// end if zi

                int luna = -1;
                String string_luna = e1.getElementsByTagName("luna").item(0).getTextContent().trim();
                if(string_luna == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    luna = Integer.parseInt(string_luna);
                    lunaC = luna;
                    Main2.logger.info("Luna: " + luna);
                }// end if luna

                int an = -1;
                String string_an = e1.getElementsByTagName("an").item(0).getTextContent().trim();
                if(string_an == null){
                    System.err.println("Nun exista informatie!");
                }
                else{
                    an = Integer.parseInt(string_an);
                    anC = an;
                    Main2.logger.info("An : " + an);
                }// end if an
            }// end if n121
        } //end id n12

        Data dataC = null;
        try {
            dataC = new Data(ziC, lunaC, anC);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Data avizare
        int ziA = -1;
        int lunaA = -1;
        int anA = -1;

        NodeList nl13 = d.getElementsByTagName("Data_avizarii_in_Consiliul_Facultatii");
        System.out.println("---------------------------");
        Node n13 = nl13.item(0);
        System.out.println(n13.getNodeName());
        if(n13.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) n13;

            NodeList nl131 = d.getElementsByTagName("Data_avizare");
            System.out.println("---------------------------");
            Node n131 = nl131.item(0);
            System.out.println(n131.getNodeName());
            if(n131.getNodeType() == Node.ELEMENT_NODE){
                Element e1 = (Element) n131;

                int zi = -1;
                String string_zi = e1.getElementsByTagName("zi").item(0).getTextContent().trim();
                if(string_zi == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    zi = Integer.parseInt(string_zi);
                    ziA = zi;
                    Main2.logger.info("Zi avizare: " + zi);
                }// end if zi

                int luna = -1;
                String string_luna = e1.getElementsByTagName("luna").item(0).getTextContent().trim();
                if(string_luna == null){
                    System.err.println("Nu exista valoare!");
                }
                else{
                    luna = Integer.parseInt(string_luna);
                    lunaA = luna;
                    Main2.logger.info("Lunam avizare: " + luna);
                }// end if luna

                int an = -1;
                String string_an = e1.getElementsByTagName("an").item(0).getTextContent().trim();
                if(string_an == null){
                    System.err.println("Nun exista informatie!");
                }
                else{
                    an = Integer.parseInt(string_an);
                    anA = an;
                    Main2.logger.info("An avizare : " + an);
                }// end if an
            }// end if n131
        } //end id n13\

        Data dataA = null;
        try{
            dataA = new Data(ziA, lunaA, anA);
        }catch (Exception e){
            e.printStackTrace();
        }

        FisaDisciplinei f = new FisaDisciplinei();
        f.setDenumireDisciplina(denumireDisciplinaFisa);
        f.setCategFormativa(categoriaFormativa);
        f.setTitularCurs(titular);
        f.setTitularAplicative(titularA);
        f.setAnStudiu(anStudii);
        f.setSemestrul(semestrul);
        f.setTipEvaluare(tipEvaluare);
        f.setRegimDisciplina(regimDisc);

        f.setNrOreAsistSapt(oreTotaleAsistIntegralSapt);
        f.setOreCursSapt(oreCursIntegralSapt);
        f.setOreAplicativeSapt(oreLabIntegralSapt);

        f.setNrOreAsistSem(oreTotalAsistIntegralSem);
        f.setOreCursSem(oreCursIntegralSem);
        f.setOreAplicativeSem(oreLabIntegralSem);

        f.setOreAsistPartialSapt(oreTotalAsistPartSapt);
        f.setNrOreAsistPartPractica(oreCursPartsapt);
        f.setOreElabProiectDiploma(oreLabPartSapt);

        f.setNrOreAsistPartSem(oreTotalAsistPartSem);
        f.setOreAsistPartPrectica(oreCursPartSem);
        f.setOreAsistPartDiploma(oreLabParSem);

        f.setOreNEasistSapt(oreNeasistateSapt);
        f.setOreDocumentare(oreDocSupsapt);
        f.setOreStudiuIndividual(oreStudiuIndividualSapt);
        f.setOrePregLab(orePregLabSapt);

        f.setOreNEasistSem(oreNeasistateSem);
        f.setOreDocumentareSem(oreDocSupSem);
        f.setOreStudiuIndividualSem(oreStudiuIndividualSem);
        f.setOrePregLabSem(orePregLabSem);

        f.setTotalOreSapt(totalSapt);
        f.setTotalOreSem(TotalSem);
        f.setNrCredite(nrCrediteDisciplina);

        f.setPrecondCurriculum(listaCurriculum);
        f.setPrecondCompetente(listaCompetente);

        f.setCondDesfCurs(conDesfCurs);
        f.setCondActPractice(condDesfActAplicat);

        f.setCompSpecifice(listaCompetenteSpecifice);
        f.setCompProfesionale(listaCompetenteProfesionale);
        f.setCompTransversale(listaCompetenteTransversale);

        f.setObiectiveGenerale(obiectiveGenerale);
        f.setObiectiveSpecifice(obiectiveSpecifice);

        f.setCurs(curs);
        f.setBibliografieCurs(bibliografieCurs);
        f.setMetodePredareCurs(metodeDePredareCurs);
        f.setLab(laborator);
        f.setBibliografieLab(bibliografieLab);
        f.setMetodePredareLab(metodeleDePredareLab);

        f.setCoroborare(coroborareContinut);

        f.setTipActivitateCurs(numeActivitateCurs);
        f.setCriteriiEvaluareCurs(numeCritevalCurs);
        f.setMetodeEvaluareCurs(numeMetEvalCurs);
        f.setCoeficientNotaFinalaCurs(coefCurs);

        f.setTipActivitateLab(numeActivitateLab);
        f.setCriteriiEvaluareLaborator(numeActivitateLab);
        f.setMetodeEvaluareLaborator(numeMetEvalLab);
        f.setCoeficientNotaFinalaLaborator(coefLab);

        f.setTipActivitateProiect(numeActivitateProiect);
        f.setCriteriiEvaluareProiect(numeCritEvalProiect);
        f.setMetodeEvaluareProiect(numeMetEvalProiect);
        f.setCoeficientNotaFinalaProiect(coefProiect);

        f.setTipActivitatePrezenta(numeActivitatePrezenta);
        f.setCriteriiEvaluarePrezenta(numeCritEvalPre);
        f.setMetodeEvaluarePrezenta(numeMetEvalPrez);
        f.setCoeficientNotaFinalaPrezenta(coefPrez);

        f.setStandardMinPerformanta(standardMinimPerformanta);

        f.setDatacompletarii(dataC);
        f.setDataAvizarii(dataA);
        return f;
    }//end getFisaDisciplina

    public static Optional<ArrayList<FisaDisciplinei>> getFiseDiscipline(){
        Optional<ArrayList<FisaDisciplinei>> retur = Optional.empty();
        ArrayList<FisaDisciplinei> listaFIseDiscipline = new ArrayList<FisaDisciplinei>();
        File folder_discipline = new File(FOLDER_FISE_DISCIPLINE);
        if(folder_discipline.isDirectory() == true){
            File[] files = folder_discipline.listFiles();
            for(File f : files){
                FisaDisciplinei fisa = null;
                try {
                    fisa = getFisaDisciplina(f.getAbsolutePath());
                }catch (IOException e1){
                    System.err.println("Nu s-a gasit fisierul");
                    continue;
                }catch (SAXException e2){
                    System.err.println("Document XML nu e bine format");
                    continue;
                }catch (ParserConfigurationException e3){
                    System.err.println("Disciplina nu a fost parsata bine");
                }finally {
                    if(fisa != null) {
                        Main2.logger.info( "Fisa disciplinei: " + fisa.toString());
                        listaFIseDiscipline.add(fisa);
                    }
                }
            }
        }
        if(listaFIseDiscipline.size() != 0){
            retur = Optional.of(listaFIseDiscipline);
        }

        return retur;
    }//end getFiseDiscipline
}//end class