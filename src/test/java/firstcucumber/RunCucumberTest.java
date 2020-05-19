package firstcucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report"},
        features = "src/test/resources/firstcucumber/"
        //dryRun = true
    )
public class RunCucumberTest {
    /*
    Thực hiện automation để thêm vào n item bất kỳ vào
    http://todomvc.com/examples/react-backbone/
    Sau đó refresh trình duyện
    Kiểm xem thức tự của các item có bị thay đổi hay không?
     */

}
