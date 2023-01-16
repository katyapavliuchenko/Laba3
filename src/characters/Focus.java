package characters;

import things.SmallThing;

public class Focus {

    public class DogOfFocus extends Dog {
        private boolean isInStomach;
        public DogOfFocus(String name, boolean isInStomach) {
            super(name);
            this.isInStomach = isInStomach;
        }
        public boolean isInStomach() {
            return isInStomach;
        }

        public void setInStomach(boolean inStomach) {
            isInStomach = inStomach;
        }
    }
    public void focus(Boy boy, SmallThing thing) {
        DogOfFocus dogOfFocus = new DogOfFocus("Каштанка", false);
        boy.giveSomething(dogOfFocus, thing);
        dogOfFocus.setInStomach(true);
        boy.laugh();
        boy.takeAwaySomething(dogOfFocus, thing);
        dogOfFocus.setInStomach(false);
        dogOfFocus.setHappiness(10);
        System.out.println(dogOfFocus + " скулит ");
    }

}
