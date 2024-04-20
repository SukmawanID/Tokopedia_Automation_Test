package report;

import base.TestBased;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

public class ExtentReport extends TestBased {

    public static ExtentSparkReporter reports;
    public static ExtentReports extent;


    public static ExtentReports getReport() {

        try {
            setProjectDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO: Initialize ExtentReports
        reports = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport.html");

        //TODO: Initialize ExtentReports and attached Reports to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(reports);
        extent.setSystemInfo("Tester", "Sukmawan");


        //TODO: Configuration Reports
        reports.config().setReportName(project_name + " Test Automation Report");
        reports.config().setDocumentTitle(project_name + " Test Automation Project Report");
        reports.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        return extent;

    }
}
