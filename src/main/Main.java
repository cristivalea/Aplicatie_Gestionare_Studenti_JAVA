package main;

import model.Repository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Repository.getInstance();
        System.out.println("Introduceti una dintre optiunile de mai jos: ");
        System.out.println("0 - Iesirea din aplicatie");
        System.out.println("1 - Adaugare Student");
        System.out.println("2 - Stergere Student Dupa Numar Matricol");
        System.out.println("3 - Stergere Student Dupa Nume si Prenume");
        System.out.println("4 - Stergere Student Dupa Nume, Prenume si Data Nasterii");
        System.out.println("5 - Cautarea Student dupa Nume");
        System.out.println("6 - Cautarea Student dupa Nume si Prenume");
        System.out.println("7 - Cautarea Student dupa Nume, Prenume si Data Nasterii");
        System.out.println("8 - Modificare Nume");
        System.out.println("9 - Modificare Prenume");
        System.out.println("10 - Modificare Data Nasterii");
        System.out.println("11 - Adaugare nota");
        System.out.println("12 - Cautarea notelor unui student");
        System.out.println("13 - Cautarea notelor de la o disciplina");
        System.out.println("14 - Cautarea notelor de la un examen"); // disciplina si data examenului
        System.out.println("15 - Modificarea unei note");
        System.out.println("16 - Stergerea unei note");
        System.out.println("Optiunea aleasa: ");
        Scanner scanner = new Scanner(System.in);
        int optiune = scanner.nextInt();
        switch (optiune){
            case 0:
            {
                return;
            }
            case 1:
            {
                Comand adaugare = new AdaugareStudent();
                adaugare.execute();
                break;
            }
            case 2:
            {
                Comand stergereNrMat = new StergereStudentDupaNrMatricol();
                stergereNrMat.execute();
                break;
            }
            case 3:
            {
                Comand stergerNumePren = new StergereStudentDupaNumePrenume();
                stergerNumePren.execute();
                break;
            }
            case 4:
            {
                Comand stergereNumePrenDataNastere = new StergeStudentDupaNumePrenumeDataNastere();
                stergereNumePrenDataNastere.execute();
                break;
            }
            case 5:
            {
                Comand cautareNume = new CautareDupaNume();
                cautareNume.execute();
                break;
            }
            case 6:
            {
                Comand cautareNumePren = new CautareDupaNumePrenume();
                cautareNumePren.execute();
                break;
            }
            case 7:
            {
                Comand cautareNumePrenDataN = new CautareDupaNumePrenumeDataNastere();
                cautareNumePrenDataN.execute();
                break;
            }
            case 8 :
            {
                Comand modNume = new ModificareNume();
                modNume.execute();
                break;
            }
            case 9:
            {
                Comand modPren = new ModificarePrenume();
                modPren.execute();
                break;
            }
            case 10:
            {
                Comand modDataNastere = new ModifcareDataNastere();
                modDataNastere.execute();
                break;
            }
            default:
            {
                System.out.println("Am iesit din aplicatie");
                return;
            }
        } // end switch
    } // end function

} // end class
