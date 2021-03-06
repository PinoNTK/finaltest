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
    private int totalFound;
    @Step("{0} see #totalFound rooms matched with destination in the list of result")
    public Integer answeredBy(Actor actor) {
        String searchingResult = SearchingResult.SEARCHING_RESULT.resolveFor(actor).getText();
        final Pattern pattern = Pattern.compile("[0-9]+", Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(searchingResult);
        if (matcher.find()) {
            totalFound = Integer.parseInt(matcher.group());
            return totalFound;
        }
        return 0;
    }
}
