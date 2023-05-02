package chap02.enums;

public enum Color {

    RED("빨간색"),
    GREEN("초록색");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getCode() {
        return name();
    }

    public String getName() {
        return name;
    }
}
