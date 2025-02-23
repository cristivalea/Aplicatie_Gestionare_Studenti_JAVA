package Excel_file;

import model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.ArrayList;

public class Parsare_Excel_Calificativ {
    private static final String cale_fisier_nota_calificativ = "D:\\PYTHON\\Generare_Studenti_Local\\model\\catalog_examen_calificativ.xlsx";

    public static ArrayList<NotaCalificativ> getNoteCalificative(String cale_fisier_nota_calificativ) throws Exception {
        ArrayList<NotaCalificativ> note_calificative = new ArrayList<NotaCalificativ>();
        File xlsxFile = new File(cale_fisier_nota_calificativ);
        final XlsReader reader = new XlsReader();
        Workbook workbook = reader.getWorkbook(xlsxFile);
        Sheet sheet = workbook.getSheetAt(0);
        int index = 0;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            String nume = row.getCell(0).getStringCellValue();
            String prenume = row.getCell(1).getStringCellValue();
            String disciplina = row.getCell(2).getStringCellValue();
            String dataExamen = row.getCell(3).getStringCellValue();
            String calificativ = row.getCell(4).getStringCellValue();
            double coefPrezentaExamen = row.getCell(5).getNumericCellValue();
            double coefPrezentaSeminar = row.getCell(6).getNumericCellValue();
            double coefPrezentaLaborator = row.getCell(7).getNumericCellValue();
            double coefPrezentaProiect = row.getCell(8).getNumericCellValue();
            index++;
            System.out.println(nume + prenume + disciplina + dataExamen + calificativ + coefPrezentaExamen + coefPrezentaLaborator + coefPrezentaSeminar + coefPrezentaProiect);

            //Găsirea studentului;
            Student student = null;
            for(int j = 0; j < Repository.getInstance().getStudenti().size(); j++){
                if(nume.equals(Repository.getInstance().getStudenti().get(j).getNumeFamilie())){
                    student = Repository.getInstance().getStudenti().get(j);
                    break;
                }
            }

            //Găsirea disciplinei
            Disciplina disciplina1 = null;
            for(int k = 0; k < Repository.getInstance().getDiscipline().size(); k++){
                if(disciplina.equals(Repository.getInstance().getDiscipline().get(k).getNumeDisciplina())){
                    disciplina1 = Repository.getInstance().getDiscipline().get(k);
                    break;
                }
            }
            NotaCalificativ nota_calificativ = new NotaCalificativ(student.getNrMatricol(), disciplina1.getCodDisciplina(), new Data(dataExamen), calificativ);
            note_calificative.add(nota_calificativ);
        }
            System.out.println(index);
            workbook.close();
            return note_calificative;
    }
        public static void main(String[] args){
            try {
                ArrayList<NotaCalificativ> note = getNoteCalificative(cale_fisier_nota_calificativ);
                System.out.println("Notele au fost procesate cu succes.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}