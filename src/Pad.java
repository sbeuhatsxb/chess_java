public interface Pad {

    public static String padHyphen(String s, int n) {
        return s.repeat(n);
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public static String padLeft(int s, int n) {
        return String.format("%" + n + "s", s);
    }

}
