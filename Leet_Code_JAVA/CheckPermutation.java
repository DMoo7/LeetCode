public class CheckPermutation {

    public static void main(String[] args) {

        System.out.println(isPermutation("abc", "abc"));

    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] charCounts = new int[128];

        for (char c: s1.toCharArray()) charCounts[c]++;


        for (char c: s2.toCharArray()) {
            charCounts[c]--;
            if (charCounts[c] < 0) return false;
        }

        return true;
    }

}
