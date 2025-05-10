    package utils;
    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;


    public class ExtentManager {

        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {
                synchronized (ExtentManager.class) {
                    if (extent == null) {
                        try {
                            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
                            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
                            reporter.config().setReportName("Automation Results");
                            reporter.config().setDocumentTitle("Framework Report");

                            extent = new ExtentReports();
                            extent.attachReporter(reporter);
                            extent.setSystemInfo("Tester", "QA FromAI");
                        } catch (Exception e) {
                            throw new RuntimeException("Failed to initialize ExtentReports", e);
                        }
                    }
                }
            }
            return extent;
        }
    }

