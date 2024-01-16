import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseClass {
    protected static ExtentReports reports;
    protected static ExtentTest test;


    @BeforeAll

    public static void start() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("E:\\tasks\\timetraker\\ReportFile\\ExtentReportResults.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

    }




    @AfterAll
    public static void end(){
        reports.flush();
    }
}
