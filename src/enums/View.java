package enums;

public enum View {
    FOG("стоит туман"),
    DARK("стало темно"),
    POOR("бедная обстановка"),
    UGLY("некрасивая обстановка");
    String title;
    private View(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
