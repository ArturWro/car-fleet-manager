package pl.groupproject.carfleet.model;

public enum DamageType {
    ENGINE("Silnik"),
    CARSHEET("Karoseria"),
    WHEEL("Koła"),
    GLASS("Szyby");

    private String label;

    DamageType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}