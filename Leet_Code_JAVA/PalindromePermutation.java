public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("racecarr"));
    }

    public static boolean isPalindromePermutation(String s) {

        int[] charCounts = new int[128];

        for (char c: s.toCharArray()) {
            if (c != ' ') charCounts[c]++;
        }

        boolean foundOdd = false;
        for (int i : charCounts) {
            if (i % 2 == 1) {
                if (foundOdd) return false;
                foundOdd = true;
            }
        }

        return true;
    }
}
