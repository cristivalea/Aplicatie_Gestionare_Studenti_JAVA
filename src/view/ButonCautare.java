package view;

import model.Repository;

import model.RegularExpresion;


import javax.swing.*;

public class ButonCautare extends JButton implements Comand {
    private JTextField textNumeText;
    private JLabel labelAfisareStudentCautare;

    public ButonCautare(JTextField textNumeText, JLabel labelAfisareStudentCautare) {
        super("Cautare Student");
        this.textNumeText = textNumeText;
        this.labelAfisareStudentCautare = labelAfisareStudentCautare;
    }

   public void execute() {
       try {
           String numeFam = this.textNumeText.getText();
           if (RegularExpresion.RegularExpresionNumePrenume(numeFam) == false) {
               System.err.println("Formatul numelui de familie este gresit!");
               return;
           }
           for (int i = 0; i < Repository.getInstance().getStudenti().size(); i++) {
               if (numeFam.equals(Repository.getInstance().getStudenti().get(i).getNumeFamilie())) {
                   String str1 = Repository.getInstance().getStudenti().get(i).getNumeFamilie();
                   String str2 = "";
                   for(String s : Repository.getInstance().getStudenti().get(i).getPrenume()){
                       str2 = str2 + " ";
                       str2 += s;
                   }
                   this.labelAfisareStudentCautare.setText(str1.concat(str2));

               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
