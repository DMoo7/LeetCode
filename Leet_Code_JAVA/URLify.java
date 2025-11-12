public class URLify {

    public static void main(String[] args) {
        String str = "Mr John Smith    "; // Extra spaces for replacement
        int trueLength = 13; // True length of "Mr John Smith"

        char[] charArray = str.toCharArray();
        urlify(charArray, trueLength);
        System.out.println("\"" + new String(charArray) + "\"");
    }

    public static void urlify(char[] str, int trueLength) {
        int spaceCount = 0;

        // Count spaces within the true length
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Calculate new length after replacements
        int index = trueLength + spaceCount * 2;

        // If there’s extra space at the end, mark the new end
        if (trueLength < str.length) str[trueLength] = '\0';

        // Modify the string in reverse (to avoid overwriting)
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
