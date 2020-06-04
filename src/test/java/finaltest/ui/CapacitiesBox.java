package finaltest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CapacitiesBox {
    public static Target CAPACITIES_BOX = Target.the("the capacities box")
            .located(By.cssSelector("#frm > div.xp__fieldset.accommodation > div.xp__input-group.xp__guests"));
    public static Target INCREASING_ADULTS_BUTTON = Target.the("adults-children button")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group__field-adults > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > button.bui-button.bui-button--secondary.bui-stepper__add-button"));
    public static Target INCREASING_CHILDREN_BUTTON = Target.the("children-increasing button")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group-children > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > button.bui-button.bui-button--secondary.bui-stepper__add-button"));
    public static Target INCREASING_ROOMS_BUTTON = Target.the("rooms-increasing button")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group__field-rooms > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > button.bui-button.bui-button--secondary.bui-stepper__add-button"));
    public static Target CURRENT_ADULTS = Target.the("the number of current adults in Capacities Box")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group__field-adults > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > span.bui-stepper__display"));
    public static Target CURRENT_CHILDREN = Target.the("the number of current children in Capacities Box")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group-children > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > span.bui-stepper__display"));
    public static Target CURRENT_ROOMS = Target.the("the number of current rooms in Capacities Box")
            .located(By.cssSelector("#xp__guests__inputs-container > div > div > div.sb-group__field.sb-group__field-rooms > div > div.bui-stepper__wrapper.sb-group__stepper-a11y > span.bui-stepper__display"));
}
