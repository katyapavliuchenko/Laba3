package enums;

public enum Time {
    AFTER_LUNCH("После обеда"),
    PAST("В прошлом"),
    PRESENT("В настоящем");
    String title;
    Time(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
