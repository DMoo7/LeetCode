public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUniqueString("Hello"));
    }

    public static boolean isUniqueString (String s) {

        if (s.length() < 2) return true;

        boolean[] charSet = new boolean[128];

        for (char c: s.toCharArray()) {
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
        }

        return true;
    }
}
