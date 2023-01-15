package enums;

public enum PlaceStatus {
    POOR("имеет бедную обстановку"),
    UGLY("имеет некрасивую обстановку"),
    CROWDED("битком набита предметами");
    private String title;
    PlaceStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
