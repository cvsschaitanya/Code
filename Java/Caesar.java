/**
 * Extends the MonoAlphabeticSubstitution class.
 * A special type of MonoAlphabeticSubstitution cipher
 * where the mapping is given by the following simple method
 * 
 * f(x) = ord_((ord(x) + k) % 26)
 * where ord(x) is an invertible function(with inverse ord_) that gives
 * the position of the letter in the Latin Alphabet with zero indexing.
 * 
 * @author Yuvaraj Konjeti
 */
public class Caesar extends MonoAlphaSubstitution {
    /**
     * Implicitly calls the default constructor in the
     * {@link MonoAlphaSubstitution) class to give the identity cipher.
     */
    public Caesar() {
    }

    /**
     * The simplest form of the Caesar cipher algorithm. Same as the rotate method
     * in the previous assignment.
     * 
     * @param ch    Character to be encrypted
     * @param shift Shift parameter of the cipher
     * @return The encrypted character
     */
    public static char ceaserTransform(char ch, int shift) {
        if (!Character.isLetter(ch))
            return ch;

        shift = shift < 0 ? 26 + shift : shift;

        char base = Character.isUpperCase(ch) ? 'A' : 'a';
        return (char) (base + (((ch - base) + shift) % 26));
    }

    /**
     * Creates the key for the MonoAlphabetic Cipher from the shift of the Caesar
     * Cipher
     * 
     * @param k The shift of the Caesar Cipher
     * @return The equivalent key for the MonoAlphabetic Cipher
     */
    private static String getCaesarStr(int k) {
        String s = "";
        for (char ch = 'a', cH = 'A'; ch <= 'z'; ch++, cH++) {
            s = s + ch + ceaserTransform(ch, k)
                    + cH + ceaserTransform(cH, k);
        }
        return s;
    }

    /**
     * Creates a new Caesar cipher with given shift
     * 
     * @param k the shift of the cipher.
     */
    public Caesar(int k) {
        super(getCaesarStr(k));
    }

    /**
     * Main entry point
     * 
     * @param args {encrypt/decrypt, n, input}
     */
    public static void main(String[] args) {
        final String guide = "Usage: java Caesar encrypt n \"cipher text\"";
        final String wordError = "The first parameter must be \"encrypt\" or \"decrypt\"!";

        if (args.length != 3) {
            System.out.println(
                    "Too "
                            + (args.length > 3 ? "many" : "few")
                            + " parameters!");
            System.out.println(guide);
            return;
        }

        if (!args[0].equals("encrypt") && !args[0].equals("decrypt")) {
            System.out.println(wordError);
            System.out.println(guide);
            return;
        }

        Caesar caesar = new Caesar(Integer.parseInt(args[1]));
        if (args[0].equals("encrypt")) {
            System.out.println(caesar.encrypt(args[2]));
        } else {
            System.out.println(caesar.decrypt(args[2]));
        }
    }
}
