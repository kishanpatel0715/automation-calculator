package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java",
        glue = {"steps", "helpers", "pages"},
        plugin = {"pretty", "html:target/CucumberHtmlReport.html", "json:target/cucumber.json"},
        monochrome = true,
        tags = "@calculator" 
        )
        
public class Test_Runner extends AbstractTestNGCucumberTests {
	
	public static String browser;
	public static String baseUrl;
	public static Boolean isHeadless;
	
	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"browser", "base_url", "headless"})
	public void setParam(String browserParam, String baseUrlParam, boolean isHeadlessParam)
	{
		browser = browserParam;
		baseUrl = baseUrlParam;
	    isHeadless = isHeadlessParam;
	}
}