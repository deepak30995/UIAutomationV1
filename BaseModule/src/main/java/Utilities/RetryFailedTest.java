package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer { //This class is for retry the failed test case
    private int count = 0;
    private static final int retries = 0;


    @Override
    public boolean retry(ITestResult result) {
        if (count < retries) {
            count++;
            return true;
        }
        return false;
    }
}