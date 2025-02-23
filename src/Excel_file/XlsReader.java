package Excel_file;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XlsReader {
    public Workbook getWorkbook(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        return new XSSFWorkbook(fis);
    }
}