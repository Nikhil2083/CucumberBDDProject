package Utilities;

public class TestRecord {
    public String testName;
    public String status; // PASS, FAIL, SKIP
    public String browser;
    public String browserVersion;
    public long duration;
    public String startTime;
    public String endTime;
    public String logs;
    public String screenshotPath;
    public String platform;
    public String className;
    public String error;

    public TestRecord(String testName, String status, String browser, String browserVersion, long duration,
                      String startTime, String endTime, String logs, String screenshotPath) {
        this.testName = testName;
        this.status = status;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.logs = logs;
        this.screenshotPath = screenshotPath;
    }
}
