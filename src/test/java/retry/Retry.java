package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int retryCount = 0;
    int max_retryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < max_retryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
