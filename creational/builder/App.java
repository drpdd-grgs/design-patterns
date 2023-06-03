package creational.builder;

public class App {
    public static void main(String[] args) {
        boolean state1 = new StringMultiStateBuilder("Abcasddsf")
                .isUpperCase()
                .isCapitalized()
                .check(); // false
        boolean state2 = new StringMultiStateBuilder("Abcsdfsdf")
                .isCapitalized()
                .contains("sdf")
                .check(); // true
        boolean state3 = new StringMultiStateBuilder("Absdf pref_12345")
                .isCapitalized()
                .matchesByRegex("pref_\\d+")
                .check(); // true
        boolean state4 = new StringMultiStateBuilder("ADSDFSD213-+FSDF")
                .isUpperCase()
                .check(); // true
    }
}
