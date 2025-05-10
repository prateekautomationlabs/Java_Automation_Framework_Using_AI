package utils;
import org.testng.IExecutionListener;
import com.aventstack.extentreports.ExtentReports;
import org.testng.IExecutionListener;

public class ExtentReporterListener  implements IExecutionListener {
    @Override
    public void onExecutionFinish() {
        ExtentReports extent = ExtentManager.getInstance();
        extent.flush();  // Very important: writes the report to file
    }

}
