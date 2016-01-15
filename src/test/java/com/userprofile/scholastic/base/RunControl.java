package com.userprofile.scholastic.base;

import java.util.Hashtable;

public class RunControl {
	public static Xls_Reader xl =null;
	
	public static boolean checkTestRunMode(String testName)
	{		
		xl = new Xls_Reader(System.getProperty("user.dir")+"\\testData\\TestController.xlsx");
		for (int i = 1; i <= xl.getRowCount("Suite"); i++) {
			String d = xl.getCellData("Suite", "TestName", i);
			//System.out.println(d);
			if(d.equals(testName)){
				System.out.print("testName "+d+"  RunMode is "+xl.getCellData("Suite", 1, i));
				if(xl.getCellData("Suite", 1, i).equals("Y"))
					return true;
				else
					return false;
			}
				
		}
		return false;
	
	}
	
	
	
	// To read Test Data from the worksheet as per test case
	
	public static Object[][] getTestData(String testName){
		Hashtable<String, String> table = null;
		int row = 0;
		int col = 0;
		xl=new Xls_Reader(System.getProperty("user.dir")+"\\testData\\TestData.xlsx");
		System.out.println("total No of Row "+xl.getRowCount(testName));
		Object[][] data = new Object[xl.getRowCount(testName)-1][1];
		for( row=2;row<=xl.getRowCount(testName);row++)
		{
			table = new Hashtable<String, String>();
			
				//System.out.println("total Col "+xl.getColumnCount("BookwizardRegistrationTest"));
				String tData=null;
				for(col=0;col<xl.getColumnCount(testName);col++)
				{
					tData= xl.getCellData(testName, col, row);
		    		System.out.print("data ---"+tData);
					table.put(xl.getCellData(testName, col, 1), xl.getCellData(testName, col, row));
					System.out.println();
			    	
			}
		data[row-2][0]=table;
		}
		
		return data;
	}
	
	
}
