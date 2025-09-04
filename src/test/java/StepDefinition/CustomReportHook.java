package StepDefinition;

import io.cucumber.java.AfterAll;
import Utilities.HTMLReportGenerator;

public class CustomReportHook {

    @AfterAll
    public static void generateReport() {
        HTMLReportGenerator.generateDetailedHTMLReport();
    }
}
