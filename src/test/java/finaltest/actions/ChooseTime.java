package finaltest.actions;

import finaltest.tasks.SearchATour;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseTime implements Interaction {
    private final String startingDate;
    private final String endingDate;

    protected ChooseTime(String startingDate, String endingDate) {
        this.endingDate = endingDate;
        this.startingDate = startingDate;
    }


    @Step("{0} books a room from #startingDate to #endingDate")
    public <T extends Actor> void performAs(T actor) {
        Target STARTING_DATE = Target.the("starting date")
                .located(By.cssSelector("td[data-date=\"" + this.startingDate + "\"]"));
        STARTING_DATE.resolveFor(actor).click();

        Target ENDING_DATE = Target.the("ending date")
                .located(By.cssSelector("td[data-date=\"" + this.endingDate + "\"]"));
        ENDING_DATE.resolveFor(actor).click();
    }
    public static ChooseTime between(String startingDate, String endingDate) {
        return instrumented(ChooseTime.class, startingDate, endingDate);
    }
}
