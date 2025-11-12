public class OneWayEdit {

    public static void main(String[] args) {
        System.out.println(isOneWayEdit("pale", "bake"));
    }

    public static boolean isOneWayEdit(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        int[] charCounts = new int[128];

        for (char c: s1.toLowerCase().toCharArray()) {
            if (c != ' ') {
                charCounts[c]++;
            }
        }

        int foundOdd = 0;

        for (char c: s2.toLowerCase().toCharArray()) {
            charCounts[c]++;
            if (charCounts[c] % 2 != 0) {
                foundOdd++;
                if (foundOdd > 1) return false;
            }
        }

        return true;
    }
}
