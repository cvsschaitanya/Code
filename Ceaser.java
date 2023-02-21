public class Ceaser {

    /**
     * Calculates the result of rotating a character by a certain shift in the Ceaser cipher.
     * @param shift The shift by which to rotate
     * @param ch The character to rotate
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
     * @param str The string to rotate
     * @return a character representing the rotated value
     */
    public static String rotate(int shift, String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++)
            result += rotate(shift, str.charAt(i));

        return result;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            if (args.length < 2)
                System.out.println("Too few parameters!");
            else
                System.out.println("Too many parameters!");

            System.out.println("Usage: java Ceaser n \"cipher text\"");
            return;
        }

        System.out.println(rotate(Integer.parseInt(args[0]), args[1]));

    }

}