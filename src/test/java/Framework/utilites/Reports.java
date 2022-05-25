package Framework.utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeSuite;

public class Reports {
    ExtentReports extentReports;
    ExtentTest test;

    @BeforeSuite
    public void startReport() {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./TestReport.html");
        extentReports = new ExtentReports();// load reports on to it
        extentReports.attachReporter(extentSparkReporter);

    }

    void stopReport() {
        extentReports.flush();
    }
    void stepReport(String status, String description) {
        switch (status.toLowerCase()) {
            case "pass":
                test.pass(description);
                break;
            case "fail":
                test.fail(description);
                break;
            case "info":
                test.info(description);
                break;
            case "warning":
                test.warning(description);
                break;
            default:
                System.err.println("Status is not defined");
                break;
        }
    /*public static void main(String[] args) {
//it creates dummy html file
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./TestReport.html");
        ExtentReports extentReports=new ExtentReports();// load reports on to it
        extentReports.attachReporter(extentSparkReporter);//attach the html to the reporter
        ExtentTest extentTest=extentReports.createTest("Tc001-search product");
        extentTest.pass("enter");
        extentTest.pass("check");
        extentTest.pass("add");
        extentTest.fail("failed", MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
        extentReports.flush();

    }*/

    }
}