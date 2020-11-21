package commonFunctions;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

	int failCount=0;
	int Limit=4;
	@Override
	public boolean retry(ITestResult result) {
        if(failCount<Limit){
        	failCount++;
        	return true;
        }
		return false;
	}

}