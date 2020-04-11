import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
//@CucumberOptions(plugin = {"pretty",},
        features = {"features"},
//        glue = {"lv/testdevlab/task/steps"},
        glue = {"steps"},
        tags = {"@SmokeTest"}
)
public class TestRunner {

}