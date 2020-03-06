package Accademy;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.Baseclass;

public class Listeners implements ITestListener {
	Baseclass b = new Baseclass();
	
	public void onTestFailure(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}


