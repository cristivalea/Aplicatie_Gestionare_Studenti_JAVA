package view;

import model.RegularExpresion;
import model.Repository;
import model.Student;

import javax.swing.*;
import java.util.Set;
import java.util.TreeSet;

public class ButonStergere extends JButton implements Comand {
    private JLabel labelAfisareStudentCautare;

    public ButonStergere(JLabel labelAfisareStudentCautare) {
        super("Stergere Student");
        this.labelAfisareStudentCautare = labelAfisareStudentCautare;
    }

    public void execute() {
        Student student = null;
        boolean c1 = false;
        boolean c2 = false;
        try {

            System.out.println("Textul din label: " + this.labelAfisareStudentCautare.getText());

            String text = this.labelAfisareStudentCautare.getText();


            String[] parts = text.replaceFirst("Student selectat:", "").trim().split("\\s+");
            System.out.println("Total elemente în parts[]: " + parts.length);

            for (String part : parts) {
                System.out.println("Element: " + part);
            }

            if (parts.length < 2) {
                System.err.println("Trebuie să existe cel puțin un prenume!");
                return;
            }

            String nume1 = parts[0];


            if (!RegularExpresion.RegularExpresionNumePrenume(nume1)) {
                System.err.println("Formatul numelui de familie este greșit!");
                return;
            }

            Set<String> prenume1 = new TreeSet<>();
            System.out.println("Prenume extrase:");
            for (int i = 1; i < parts.length - 1; i++) {
                System.out.println(parts[i]);
                if (!RegularExpresion.RegularExpresionNumePrenume(parts[i])) {
                    System.err.println("Formatul prenumelui " + parts[i] + " este greșit!");
                    return;
                }
                prenume1.add(parts[i]);
            }

            String numarMatricol = parts[parts.length - 1];
            if (!numarMatricol.matches("[A-Za-z0-9]+")) {
                System.err.println("Formatul numărului matricol este greșit!");
                return;
            }
            System.out.println("Număr matricol: " + numarMatricol);

            // Căutăm studentul în listă
            for (Student s : Repository.getInstance().getStudenti()) {
                if (nume1.equals(s.getNumeFamilie())) {
                    c1 = true;
                }
                Set<String> prenume2 = new TreeSet<>(s.getPrenume());
                c2 = prenume1.equals(prenume2);
                if (c1 && c2) {
                    student = s;
                    break;
                }
            }

            if (student == null) {
                System.err.println("Studentul nu a fost găsit");
                return;
            }


            if (student.getNote().isEmpty()) {
                Repository.getInstance().stergeStudent(student);
                System.out.println("Studentul a fost șters cu succes");
            } else {
                System.err.println("Studentul nu poate fi șters deoarece are note");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}