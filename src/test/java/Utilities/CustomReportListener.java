package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomReportListener {

    private static final String TEMPLATE_FILE = "src/test/java/Utilities/report-template.html";
    private static final String LOG_FILE = "logs/mylog.log";

    public static void generateReport(String suiteName, String testName,
                                      int passed, int failed, int skipped,
                                      List<CustomTestResult> results) throws IOException {

        String template = new String(Files.readAllBytes(Paths.get(TEMPLATE_FILE)));

        int total = passed + failed + skipped;
        int successRate = total > 0 ? (passed * 100 / total) : 0;

        // Build rows for scenarios
        StringBuilder rowsHtml = new StringBuilder();
        for (CustomTestResult tr : results) {
            rowsHtml.append("<tr><td>").append(tr.getTestName()).append("</td>");
            for (String status : tr.getStepStatuses()) {
                String cssClass = status.equalsIgnoreCase("PASS") ? "status-pass"
                        : status.equalsIgnoreCase("FAIL") ? "status-fail" : "status-skip";
                rowsHtml.append("<td><span class='").append(cssClass).append("'>")
                        .append(status).append("</span></td>");
            }
            rowsHtml.append("</tr>");
        }

        // Read log file content
        String logs = getLogsContent();

        // Replace placeholders
        template = template.replace("$SUITE_NAME", suiteName)
                .replace("$TEST_NAME", testName)
                .replace("$PASSED_COUNT", String.valueOf(passed))
                .replace("$FAILED_COUNT", String.valueOf(failed))
                .replace("$SKIPPED_COUNT", String.valueOf(skipped))
                .replace("$TOTAL_COUNT", String.valueOf(total))
                .replace("$SUCCESS_RATE", String.valueOf(successRate))
                .replace("$DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .replace("$TIME", new SimpleDateFormat("HH:mm:ss").format(new Date()))
                .replace("$TEST_RESULTS_ROWS", rowsHtml.toString())
                .replace("$LOG_CONTENT", logs);

        // Save report file
        File dir = new File("target/custom-reports");
        if (!dir.exists()) dir.mkdirs();
        String filename = "custom_report_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir, filename)))) {
            writer.write(template);
        }
    }

    private static String getLogsContent() {
        try {
            File logFile = new File(LOG_FILE);
            if (logFile.exists()) {
                return new String(Files.readAllBytes(logFile.toPath()))
                        .replace("<", "&lt;")
                        .replace(">", "&gt;"); // HTML escape
            } else {
                return "⚠️ Log file not found.";
            }
        } catch (IOException e) {
            return "⚠️ Error reading log file: " + e.getMessage();
        }
    }
}
