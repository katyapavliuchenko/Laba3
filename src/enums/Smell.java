package enums;

public enum Smell {
    SMOKE("дымом"),
    GLUE("клеем"),
    VARNISH("лаком"),
    SHAVINGS("стружками");
    String title;
    Smell(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
