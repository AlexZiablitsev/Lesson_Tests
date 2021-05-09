package enums;

public enum ProjectType {
    SINGLE_FOR_ALL_CASES("1"),
    SINGLE_WITH_BASELINE("2"),
    MULTIPLE("3");

    private final String value;

    ProjectType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ProjectType getEnumByValue(int value) {
        for (ProjectType mod : ProjectType.values()) {
            if (mod.getValue().equals(value))
                return mod;
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
