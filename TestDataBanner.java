package TestData;
import me.darsini.mainTest.ExcelDataImport;

import com.github.javafaker.Faker;
import TestData.WriteExcel;



public class TestDataBanner {
String[] testData;
String[] fakerData;
Faker faker = new Faker();

	public String[] getSignInData() {
		testData = new String[14];
		testData[0] = ExcelDataImport.getValue(1, 0);
		testData[1] = ExcelDataImport.getValue(1, 1);
		testData[2] = ExcelDataImport.getValue(1, 2);
		testData[3] = ExcelDataImport.getValue(1, 3);
		testData[4] = ExcelDataImport.getValue(1, 4);
		testData[5] = ExcelDataImport.getValue(1, 5);
		testData[6] = ExcelDataImport.getValue(1, 6);
		testData[7] = ExcelDataImport.getValue(1, 7);
		testData[8] = ExcelDataImport.getValue(1, 8);
		testData[9] = ExcelDataImport.getValue(1, 9);
		testData[10] = ExcelDataImport.getValue(1, 10);
		testData[11] = ExcelDataImport.getValue(1, 11);
		testData[12] = ExcelDataImport.getValue(1, 12);
		testData[13] = ExcelDataImport.getValue(1, 13);
				
		return testData;
	}
	
public String[] setFakerData() {
		
		fakerData = new String[2];
	
		ExcelDataImport.setValue(1, 0, faker.name().title());
		ExcelDataImport.setValue(1, 1, faker.name().title());
		
		
		return fakerData;
		
	}
}
