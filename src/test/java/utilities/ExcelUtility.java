package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static void excelOutput(List<String>name,List<String>price,List<String>date,List<String>UsedCars) throws IOException {
		FileOutputStream fp=new FileOutputStream(System.getProperty("user.dir")+"\\output\\output.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("New Bike Details");		
		int row=0;
		for(int i=0;i<name.size();i++) {
				XSSFRow rows=sheet.createRow(row);			
				rows.createCell(0).setCellValue(name.get(i));
				rows.createCell(1).setCellValue(price.get(i));
				rows.createCell(2).setCellValue(date.get(i));
				row+=1;

		}
		XSSFSheet sheet2=wb.createSheet("Popular Used Cars");
		for(int i=0;i<UsedCars.size();i++) {
				XSSFRow rows=sheet2.createRow(i);			
				rows.createCell(0).setCellValue(UsedCars.get(i));				
		}

		wb.write(fp);
		wb.close();
		fp.close();
	}
}
