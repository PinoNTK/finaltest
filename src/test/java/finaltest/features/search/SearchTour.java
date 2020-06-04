package finaltest.features.search;

import finaltest.questions.SearchResultQuestion;
import finaltest.tasks.OpenBookingPage;
import finaltest.tasks.SearchATour;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class SearchTour {
    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenBookingPage openBookingPage;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void book_a_tour_in_PhuQuoc() {
        givenThat(anna).wasAbleTo(openBookingPage);
        when(anna).attemptsTo(SearchATour.withKeyword("Phu Quoc"));
        then(anna).should(seeThat(SearchResultQuestion.numberOfResultsFound(), CoreMatchers.equalTo(272)));
    }
}
