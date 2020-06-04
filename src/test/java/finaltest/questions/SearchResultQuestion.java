package finaltest.questions;

import finaltest.ui.SearchingResult;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultQuestion implements Question<Integer> {
    public static Question<Integer> numberOfResultsFound(){
        return new SearchResultQuestion();
    }

    @Step("{0} see #foundNumber rooms matched with destination in the list of result")
    public Integer answeredBy(Actor actor) {
        String searchingResult = SearchingResult.SEARCHING_RESULT.resolveFor(actor).getText();
        final Pattern pattern = Pattern.compile("[0-9]+", Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(searchingResult);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }
}
