package finaltest.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchingResult {
    public static Target SEARCHING_RESULT= Target.the("searching result")
            .located(By.cssSelector("#right > div:nth-child(5) > div > div.sr_header--title > div > h1"));
}
