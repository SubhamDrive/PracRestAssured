package DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFRow xr;
    public static XSSFCell xc;

    public static int getRowCount(String xlfile,String xlsheet)throws IOException
    {
        fi= new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        int rowCount = sh.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }
    public static int getCellCount(String xlfile,String xlsheet,int rownum)throws IOException
    {
        fi= new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        Row row = sh.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum)throws IOException
    {
        fi= new FileInputStream(xlfile);
        wb= new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        Row row = sh.getRow(rownum);
        Cell cell = row.getCell(colnum);
        String data;
        try
        {
            DataFormatter formatter= new DataFormatter();
            String cellData= formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e)
        {
            data="";
        }
            wb.close();
            fi.close();
            return data;
    }

    public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String Data)throws IOException
    {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh= wb.getSheet(xlsheet);
        Row row = sh.getRow(rownum);
        Cell cell=row.createCell(colnum);
        cell.setCellValue(Data);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

}
