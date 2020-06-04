package finaltest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchingBox {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.cssSelector("input[type=\"search\"]"));
    public static Target SEARCH_BUTTON = Target.the("search button").located(By.cssSelector("#frm > div.xp__fieldset.accommodation > div.xp__button > div.sb-searchbox-submit-col.-submit-button > button"));
}
