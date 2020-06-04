package finaltest.actions;

import finaltest.ui.CapacitiesBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseCapacities implements Interaction {
    private final int adultNumber;
    private final int childrenNumber;
    private final int roomNumber;

    protected ChooseCapacities(int adultNumber, int childrenNumber, int roomNumber) {
        this.adultNumber = adultNumber;
        this.childrenNumber = childrenNumber;
        this.roomNumber = roomNumber;
    }

    public static ChooseCapacitiesBuilder withAdults(int adultNumber){
        return new ChooseCapacitiesBuilder(adultNumber);
    }

    @Step("{0} wants to book #roomNumber rooms for #adultNumber adults and #childrenNumber children")
    public <T extends Actor> void performAs(T actor) {
        CapacitiesBox.CAPACITIES_BOX.resolveFor(actor).click();
        // increase adult number
        int numberOfAdults = Integer.parseInt(CapacitiesBox.CURRENT_ADULTS.resolveFor(actor).getText());
        for (int i = 0; i < this.adultNumber - numberOfAdults; i++) {
            CapacitiesBox.INCREASING_ADULTS_BUTTON.resolveFor(actor).click();
        }

        // increase children number
        int numberOfChildren = Integer.parseInt(CapacitiesBox.CURRENT_CHILDREN.resolveFor(actor).getText());
        for (int i = 0; i < this.childrenNumber - numberOfChildren; i++) {
            CapacitiesBox.INCREASING_CHILDREN_BUTTON.resolveFor(actor).click();
        }

        // increase room number
        int numberOfRoom = Integer.parseInt(CapacitiesBox.CURRENT_ROOMS.resolveFor(actor).getText());
        for (int i = 0; i < this.roomNumber - numberOfRoom; i++) {
            CapacitiesBox.INCREASING_ROOMS_BUTTON.resolveFor(actor).click();
        }

    }

    public static class ChooseCapacitiesBuilder {
        private int adultNumber;
        private int childrenNumber;

        public ChooseCapacitiesBuilder(int adultNumber){
            this.adultNumber = adultNumber;
        }

        public ChooseCapacitiesBuilder withChildren(int childrenNumber){
            this.childrenNumber = childrenNumber;
            return this;
        }

        public Interaction withRooms(int roomNumber){
            return instrumented(ChooseCapacities.class, this.adultNumber, this.childrenNumber, roomNumber);
        }
    }

}
