package Excel_file;

import model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.ArrayList;

public class Parsare_Excel_Nota_Numerica {
    private static final String cale_fisier_nota_numerica = "D:\\PYTHON\\Generare_Studenti_Local\\model\\catalog_examen_numeric.xlsx";

    public static void getNoteNumerice(String cale_fisier_nota_numerica) throws Exception {
        ArrayList<NotaNumerica> note_numerice = new ArrayList<>();
        File xlsxFile = new File(cale_fisier_nota_numerica);
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
            int notaExamen = (int) row.getCell(4).getNumericCellValue();
            int notaSeminar = (int) row.getCell(5).getNumericCellValue();
            int notaLaborator = (int) row.getCell(6).getNumericCellValue();
            int notaProiect = (int) row.getCell(7).getNumericCellValue();
            double coefPrezentaExamen = row.getCell(8).getNumericCellValue();
            double coefPrezentaSeminar = row.getCell(9).getNumericCellValue();
            double coefPrezentaLaborator = row.getCell(10).getNumericCellValue();
            double coefPrezentaProiect = row.getCell(11).getNumericCellValue();
            System.out.println(nume + prenume + disciplina + dataExamen + notaExamen + notaSeminar + notaLaborator + notaProiect + coefPrezentaExamen + coefPrezentaLaborator + coefPrezentaSeminar + coefPrezentaProiect);
            index++;

            // Găsirea studentului
//            Student student = null;
//            for (Student s : Repository.getInstance().getStudenti()) {
//                if (s.getNumeFamilie().equals(nume) && s.getPrenume().equals(prenume)) {
//                    student = s;
//                    break;
//                }
//            }

            // Găsirea disciplinei
//            Disciplina disciplina1 = null;
//            for (Disciplina d : Repository.getInstance().getDiscipline()) {
//                if (d.getNumeDisciplina().equals(disciplina)) {
//                    disciplina1 = d;
//                    break;
//                }
//            }
        }
        System.out.println(index);
        workbook.close();
//        return note_numerice;
    }

    public static void main(String[] args) {
        try {
            //ArrayList<NotaNumerica> note = getNoteNumerice(cale_fisier_nota_numerica);
            getNoteNumerice(cale_fisier_nota_numerica);
            System.out.println("Notele au fost procesate cu succes.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
