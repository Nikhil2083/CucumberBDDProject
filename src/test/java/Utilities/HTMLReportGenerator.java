package Utilities;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import StepDefinition.CustomCucumberListener;

public class HTMLReportGenerator {

    public static void generateDetailedHTMLReport() {
        String reportFolder = "target/CustomeReports2";
        String reportPath = reportFolder + "/DeepFreezeAutomationTestReport.html";
        List<TestRecord> testRecords = CustomCucumberListener.testRecords;

        try (PrintWriter writer = new PrintWriter(new FileWriter(reportPath))) {
            // Calculate statistics
            int totalTests = testRecords.size();
            int passedTests = (int) testRecords.stream().filter(r -> "PASS".equals(r.status)).count();
            int failedTests = (int) testRecords.stream().filter(r -> "FAIL".equals(r.status)).count();
            int skippedTests = (int) testRecords.stream().filter(r -> "SKIP".equals(r.status)).count();
            double passRate = totalTests > 0 ? (passedTests * 100.0 / totalTests) : 0;

            long totalDuration = testRecords.stream().mapToLong(r -> r.duration).sum();
            long minutes = totalDuration / (60 * 1000);
            long seconds = (totalDuration % (60 * 1000)) / 1000;
            String formattedDuration = String.format("%dm %ds", minutes, seconds);

            String formattedDate = new SimpleDateFormat("dd MMMM yyyy").format(System.currentTimeMillis());

            // Start HTML
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='en'><head><meta charset='UTF-8'><title>DeepFreeze Automation Test Report</title>");
            writer.println("<style>");
            writer.println("body{font-family:Arial;background:#f5f5f5;padding:10px;} .summary{display:flex;gap:10px;margin:10px 0;} .summary div{background:white;padding:10px;border-radius:5px;text-align:center;} .passed{color:green;font-weight:bold;} .failed{color:red;font-weight:bold;} .badge-pass{color:white;background:green;padding:3px 6px;border-radius:4px;} .badge-fail{color:white;background:red;padding:3px 6px;border-radius:4px;} .badge-warning{color:white;background:orange;padding:3px 6px;border-radius:4px;} table{width:100%;border-collapse:collapse;margin-top:10px;} th,td{border:1px solid #ddd;padding:8px;text-align:left;} th{background:#3498db;color:white;} .modal{display:none;position:fixed;top:0;left:0;width:100%;height:100%;background:rgba(0,0,0,0.5);} .modal-content{background:white;margin:10% auto;padding:20px;width:80%;border-radius:5px;max-height:70%;overflow-y:auto;} .close{float:right;cursor:pointer;font-weight:bold;}");
            writer.println("</style></head><body>");

            // Summary
            writer.println("<h1>Automation Test Report</h1>");
            writer.println("<div class='summary'>");
            writer.println("<div>Total<br>" + totalTests + "</div>");
            writer.println("<div class='passed'>Passed<br>" + passedTests + "</div>");
            writer.println("<div class='failed'>Failed<br>" + failedTests + "</div>");
            writer.printf("<div>Pass Rate<br>%.1f%%</div>", passRate);
            writer.println("</div>");

            // Table
            writer.println("<table><thead><tr><th>Test Name</th><th>Status</th><th>Logs/Screenshot</th></tr></thead><tbody>");
            for (TestRecord r : testRecords) {
                String badge = r.status.equals("PASS") ? "badge-pass" : r.status.equals("FAIL") ? "badge-fail" : "badge-warning";
                writer.println("<tr>");
                writer.println("<td>" + r.testName + "</td>");
                writer.println("<td><span class='" + badge + "'>" + r.status + "</span></td>");
                String action = "";
                if (r.logs != null) action += "<button onclick=\"showModal('" + r.logs.replaceAll("'", "\\'") + "')\">View Logs</button>";
                if (r.screenshotPath != null) action += "<button onclick=\"showModal('<img src=\\'" + r.screenshotPath + "\\' width=400>')\">View Screenshot</button>";
                writer.println("<td>" + action + "</td>");
                writer.println("</tr>");
            }
            writer.println("</tbody></table>");

            // Modal
            writer.println("<div id='modal' class='modal'><div class='modal-content'><span class='close' onclick='closeModal()'>&times;</span><div id='modalBody'></div></div></div>");

            // JS
            writer.println("<script>");
            writer.println("function showModal(content){document.getElementById('modalBody').innerHTML=content;document.getElementById('modal').style.display='block';}");
            writer.println("function closeModal(){document.getElementById('modal').style.display='none';}");
            writer.println("</script>");

            writer.println("</body></html>");

            System.out.println("HTML report generated at: " + reportPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
