package finaltest.tasks;

import finaltest.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenBookingPage implements Task {
    BookingPage bookingPage;

    @Step("Open the booking page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(bookingPage)
        );
    }
}
