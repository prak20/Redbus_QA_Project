package utils;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ExcelReaderTest
{
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
 
    public ExcelReaderTest(String xlFilePath,String sheetName)
    {
    	try {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    	}catch (Exception e) {

			e.printStackTrace();
		}
    }
 
    public String getValue(String colName, int rowVal)
    {
    	int rowNum=rowVal+1;
        try
        {
            int col_Num = -1;
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
 
            if(cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();
            else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA"))
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(DateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellType().name().equals("BLANK"))
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }
    }
}