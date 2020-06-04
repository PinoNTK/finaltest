package finaltest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuggestionList {
    public static Target FIRST_OPTION = Target.the("search field").located(By.cssSelector("ul[role=\"listbox\"]>li"));
}
