package Framework;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Excelutils extends BaseClass{
    public static String fetchData(String sheetName ,String getField) throws IOException, FileNotFoundException {
        String path=System.getProperty("user.dir");
        File file =    new File(path+"\\"+"testdata"+"\\"+"testdata.xls");
        HashMap<String, String> map=new HashMap<String, String>();
        FileInputStream fs=new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fs);;
        Sheet sheet=workbook.getSheet(sheetName);
        String s = null;
        DataFormatter formatter=new DataFormatter();
        for(Row row:sheet) {
            for(Cell cell:row) {
                if(getField.equalsIgnoreCase(formatter.formatCellValue(cell))){
                    int rownum=row.getRowNum();
                    int col=cell.getColumnIndex();
                    for(int i=0;i<sheet.getRow(rownum).getLastCellNum();i++) {
                        s=formatter.formatCellValue(sheet.getRow(rownum+1).getCell(col));
                    }
                }
            }

        }

        return s;

    }
}
