package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test_cases_run {
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    //helps to generate the logs in test report.
    static ExtentTest test;
    static String rootPath = Paths.get("").toAbsolutePath().toString() ;


    @BeforeTest
    public static void startTest()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\testReport.html");
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Test Report for code challenge");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
    @Test
    public void test_address_simple_cases() {
        test = extent.createTest("test_address_simple_cases", "simple_cases");
        String testdata = "testdata_simple_cases.txt";
        ArrayList<String> AddressDetails = (ArrayList<String>) utils.getTestData(testdata);
        ArrayList<String> StreetList = new ArrayList<String>();
        ArrayList<String> HouseList = new ArrayList<String>();
        Map<String, Object> data = new HashMap<String, Object>();

        String[] array_Address = null;
        for (int num = 0; num < AddressDetails.size(); num++) {
            String Address_data = AddressDetails.get(num);
            test.log(Status.INFO, "checking address: "+Address_data);
            String address_str = Address_data.replaceAll("[,]", "");
            array_Address = address_str.split(" ");
            List<String> address_data_list =utils.getAddressDetails(array_Address);
            JSONObject json = new JSONObject();
            json.put("street", address_data_list.get(0));
            json.put("housenumber",address_data_list.get(1));
            System.out.println(json);
            test.log(Status.INFO, "converted address: "+json);
            data.put( address_str,json );
        }
        System.out.println("------Test Output-------");
        System.out.println(data);
        test.log(Status.INFO, "output: "+data);
    }

    @Test
    public void test_address_complex_cases() {
        test = extent.createTest("test_address_complex_cases", "complex_cases");

        String testdata = "testdata_complex_cases.txt";
        ArrayList<String> AddressDetails = (ArrayList<String>) utils.getTestData(testdata);
        ArrayList<String> StreetList = new ArrayList<String>();
        ArrayList<String> HouseList = new ArrayList<String>();
        Map<String, Object> data = new HashMap<String, Object>();

        String[] array_Address = null;
        for (int num = 0; num < AddressDetails.size(); num++) {
            String Address_data = AddressDetails.get(num);
            test.log(Status.INFO, "checking address: "+Address_data);
            String address_str = Address_data.replaceAll("[,]", "");
            array_Address = address_str.split(" ");
            List<String> address_data_list =utils.getAddressDetails(array_Address);
            JSONObject json = new JSONObject();
            json.put("street", address_data_list.get(0));
            json.put("housenumber",address_data_list.get(1));
            System.out.println(json);
            test.log(Status.INFO, "converted address: "+json);
            data.put( address_str,json );
        }
        System.out.println("------Test Output-------");
        System.out.println(data);
        test.log(Status.INFO, "output: "+data);

    }

    @Test
    public void test_address_complicated_cases() {
        test = extent.createTest("test_address_complicated_cases", "complicated_cases");
        String testdata = "testdata_complicated_cases.txt";
        ArrayList<String> AddressDetails = (ArrayList<String>) utils.getTestData(testdata);
        ArrayList<String> StreetList = new ArrayList<String>();
        ArrayList<String> HouseList = new ArrayList<String>();
        Map<String, Object> data = new HashMap<String, Object>();

        String[] array_Address = null;
        for (int num = 0; num < AddressDetails.size(); num++) {
            String Address_data = AddressDetails.get(num);
            test.log(Status.INFO, "checking address: "+Address_data);
            String address_str = Address_data.replaceAll("[,]", "");
            array_Address = address_str.split(" ");
            List<String> address_data_list =utils.getAddressDetails(array_Address);
            JSONObject json = new JSONObject();
            json.put("street", address_data_list.get(0));
            json.put("housenumber",address_data_list.get(1));
            System.out.println(json);
            test.log(Status.INFO, "converted address: "+json);
            data.put( address_str,json );
        }
        System.out.println("------Test Output-------");
        System.out.println(data);
        test.log(Status.INFO, "output: "+data);
    }

    @Test
    public void test_address_extra_cases() {
        test = extent.createTest("test_address_extra_cases", "extra_cases");
        String testdata = "testdata_extra_cases.txt";
        ArrayList<String> AddressDetails = (ArrayList<String>) utils.getTestData(testdata);
        ArrayList<String> StreetList = new ArrayList<String>();
        ArrayList<String> HouseList = new ArrayList<String>();
        Map<String, Object> data = new HashMap<String, Object>();

        String[] array_Address = null;
        for (int num = 0; num < AddressDetails.size(); num++) {
            String Address_data = AddressDetails.get(num);
            test.log(Status.INFO, "checking address: "+Address_data);
            String address_str = Address_data.replaceAll("[,]", "");
            array_Address = address_str.split(" ");
            List<String> address_data_list =utils.getAddressDetails(array_Address);
            JSONObject json = new JSONObject();
            json.put("street", address_data_list.get(0));
            json.put("housenumber",address_data_list.get(1));
            test.log(Status.INFO, "converted address: "+json);
            System.out.println(json);
            data.put( address_str,json );
        }
        System.out.println("------Test Output-------");
        System.out.println(data);
        test.log(Status.INFO, "output: "+data);
    }
}
