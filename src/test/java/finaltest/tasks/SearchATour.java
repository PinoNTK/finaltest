package finaltest.tasks;

import finaltest.actions.ChooseCapacities;
import finaltest.actions.ChooseTime;
import finaltest.ui.SearchBox;
import finaltest.ui.SearchingBox;
import finaltest.ui.SuggestionList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class SearchATour implements Task {
    private final String searchTerm;

    protected SearchATour(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        LocalDate startingDateObj = LocalDate.now().plusDays(7);
        LocalDate endingDateObj = startingDateObj.plusDays(3);
        String startingDate = DateTimeFormatter.ISO_DATE.format(startingDateObj);
        String endingDate = DateTimeFormatter.ISO_DATE.format(endingDateObj);


        actor.attemptsTo(
                Enter.theValue(searchTerm).into(SearchingBox.SEARCH_FIELD),
                Click.on(SuggestionList.FIRST_OPTION),
                ChooseTime.between(startingDate, endingDate),
                ChooseCapacities.withAdults(4).withChildren(3).withRooms(2),
                Click.on(SearchingBox.SEARCH_BUTTON)
        );
    }

    public static SearchATour withKeyword(String searchTerm) {
        return instrumented(SearchATour.class, searchTerm);
    }
}
