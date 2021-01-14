package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utils {

	@DataProvider(name="get")
	public Object[][] getData() throws IOException, URISyntaxException {
		
		
		//File file= new File("‪D:\\excelFiles\\loginData.xlsx");
		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource("loginData.xls").toString());*/
		ClassLoader classLoader = getClass().getClassLoader();
        URL inputStream = classLoader.getResource("loginData.xlsx");
        File file  = new File(inputStream.toURI());
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int latRowNum =sheet.getLastRowNum();
		int lastCellNumber = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[latRowNum][1];
		Map<String, String> datamap = new HashMap<String, String>();
		
		for(int i=0; i< latRowNum ; i++)
		{
			
			for(int j=0; j<lastCellNumber; j++)
			{
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
			}
			obj[i][0]=datamap;
			
		}
		
		
		
		return obj;
									 
		
	}
	
}


