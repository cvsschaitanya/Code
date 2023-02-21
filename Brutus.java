public class Brutus {
    /**
     * Standard values representing the frequencies of the 26 letteres of the alphabet in the English Language.
     */
    public static final double[] english = {
            0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
            0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
            0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    /**
     * Calculates the number of times each letter of the alphabet appears in the given string.
     * @param str The String for which count is to be calculated
     * @return An array of 26 Integers representing the counts of each letter of the alphabet in the string
     */
    public static int[] count(String str) {
        int[] letterCounts = new int[26];
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                letterCounts[ch - 'a']++;
            }
        }

        return letterCounts;
    }

    /**
     * Calculates the frequency of each letter of the alphabet in the
     * given string. It is calculated by dividing the count of each letter by the total number of letter occurances in the string.
     * 
     * @param str The String for which frequencies are to be calculated
     * @return An array of 26 Doubles representing the frequencies of each letter of the
     *         alphabet in the string
     */
    public static double[] frequency(String str) {
        double total = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                total += 1;
            }
        }

        double[] letterFreq = new double[26];
        int[] letterCounts = count(str);
        for (int i = 0; i < 26; i++) {
            letterFreq[i] = letterCounts[i] / total;
        }

        return letterFreq;
    }

    /**
     * Calculates the Chi-Square value for 2 lists. It represents the closeness between two arrays.
     * The smaller the value the closer the lists are.
     * 
     * @param A The First array of Doubles of size 26.
     * @param B The Second array of Doubles of size 26. This must be non-zero
     * @return The Chi-Square value for the two arrays
     */
    public static double chiSquared(double[] A, double[] B) {
        double cS = 0;
        for (int i = 0; i < 26; i++) {
            double diff = A[i] - B[i];
            cS += (diff * diff) / B[i];
        }

        return cS;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            if (args.length < 1)
                System.out.println("Too few parameters!");
            else
                System.out.println("Too many parameters!");

            System.out.println("Usage: java Brutus \"cipher text\"");
            return;
        }

        // Represents the best chi-square value from all possible shifts
        double bestCS = Double.MAX_VALUE;
        // Represents the shift value that gives the best chi-square value
        int bestShift = 0;
        for (int i = 0; i < 26; i++) {
            String plainText = rotate(-i, args[0]);
            double[] letterFreq = frequency(plainText);
            double cS = chiSquared(letterFreq, english);

            if (cS < bestCS) {
                bestCS = cS;
                bestShift = i;
            }
        }

        System.out.println(rotate(-bestShift, args[0]));

    }

    /**
     * Calculates the result of rotating a character by a certain shift in the
     * Ceaser cipher.
     * 
     * @param shift The shift by which to rotate
     * @param ch    The character to rotate
     * @return a character representing the rotated value
     */
    public static char rotate(int shift, char ch) {
        if (!Character.isLetter(ch))
            return ch;

        shift = shift < 0 ? 26 + shift : shift;

        char base = Character.isUpperCase(ch) ? 'A' : 'a';
        return (char) (base + (((ch - base) + shift) % 26));
    }

    /**
     * Calculates the result of rotating a string by a certain shift in the
     * Ceaser cipher.
     * 
     * @param shift The shift by which to rotate
     * @param str   The string to rotate
     * @return a character representing the rotated value
     */
    public static String rotate(int shift, String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++)
            result += rotate(shift, str.charAt(i));

        return result;
    }
}