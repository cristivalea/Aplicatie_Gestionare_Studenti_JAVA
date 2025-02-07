package JSON_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Data;
import model.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParsareJSON {
    private static final String FOLDER_JSON = "D:\\JAVA\\Evidenta Studenti\\Evidenta_Studenti\\src\\Studenti";

    public static Student getStudent(String fileName) throws ParserConfigurationException, SAXException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(new File(fileName));
            String nume = root.get("Nume").asText();
            ArrayList<String> prenume = new ArrayList<String>();
            for (JsonNode p : root.get("Prenume")) {
                prenume.add(p.asText());
            }
            JsonNode dataNastereNode = root.get("Data Nastere");
            Data dataNastere = new Data(
                    Integer.parseInt(dataNastereNode.get("Zi").asText()),
                    Integer.parseInt(dataNastereNode.get("Luna").asText()),
                    Integer.parseInt(dataNastereNode.get("An").asText())
            );
            JsonNode dataInmatriculareNode = root.get("Data Inmatriculare");
            Data dataInmatriculare = new Data(
                    Integer.parseInt(dataInmatriculareNode.get("Zi").asText()),
                    Integer.parseInt(dataInmatriculareNode.get("Luna").asText()),
                    Integer.parseInt(dataInmatriculareNode.get("An").asText())
            );
            Student s = new Student(nume, dataNastere, dataInmatriculare, prenume.toArray(new String[0]));
            System.out.println(s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }// end try - catch
    } // end function getStudent

    public static ArrayList<Student> extrageStudenti() throws NullPointerException{
        try {
            File folder = new File(FOLDER_JSON);
            ArrayList<Student> studenti = new ArrayList<Student>();
            if(folder.isDirectory() == true){
                File[] caleFisiere = folder.listFiles();
                for(File f : caleFisiere){
                    String denumireFisier = f.getName();
                    if(denumireFisier.endsWith(".json")){
                        Student s = ParsareJSON.getStudent(f.getAbsolutePath());
                        studenti.add(s);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        try {
//            Student student = ParsareJSON.getStudent(FOLDER_JSON);
//
//            if (student != null) {
//                System.out.println("Student creat cu succes!");
//                System.out.println(student);
//            } else {
//                System.out.println("Eroare la parsarea JSON-ului.");
//            }
            ArrayList<Student> s = ParsareJSON.extrageStudenti();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
} // end class

