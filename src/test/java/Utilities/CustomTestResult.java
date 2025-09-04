package Utilities;

import java.util.List;

public class CustomTestResult {
    private String testName;
    private List<String> stepStatuses;

    public CustomTestResult(String testName, List<String> stepStatuses) {
        this.testName = testName;
        this.stepStatuses = stepStatuses;
    }

    public String getTestName() {
        return testName;
    }

    public List<String> getStepStatuses() {
        return stepStatuses;
    }
}
