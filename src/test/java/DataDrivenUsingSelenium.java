import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenUsingSelenium {
    public static void main(String s[]) throws IOException {
        FileInputStream file = new FileInputStream("/Users/driveu/Downloads/EMPDATA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet ws = wb.getSheet("Sheet1");
        int rowcount = ws.getLastRowNum();
        int colcount = ws.getRow(0).getLastCellNum();

        for(int i=0;i<rowcount;i++)
        {
            XSSFRow currentrow= ws.getRow(i);
            for(int j=0;j<colcount;j++)
            {
                String value = currentrow.getCell(j).toString();
                System.out.print("  "+value);
            }
            System.out.println();
        }


    }
}
