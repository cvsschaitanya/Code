/**
 * Extends the Subtitution class.
 * This cipher has the speciality that a given letter will be translated to different
 * letters depending on the position at which it appears in the plain text.
 * 
 * @author Yuvaraj Konjeti
 */
public class Vigenere extends Substitution {

    /**
     * Keeps tract of the position of the letter that is being de/encrypted.
     */
    int letterPos = 0;
    /**
     * Stores the key for the de/encryption.
     */
    String key;

    /**
     * Constructs the identity substitution cipher
     */
    public Vigenere() {
        this("A");
    }

    /**
     * Constructs a new Vigenere cipher with the given key
     * @param key The key to encrypt and decrypt
     */
    public Vigenere(String key) {
        this.key = key;
    }

    /**
     * Calculate the Caesar shift value based on the position of the plain text character
     * @param key Vigenere key
     * @param pos Position in the plain text 
     * @return The Caesar shift for this character
     */
    private int getShift(String key, int pos) {
        pos = pos % key.length();
        return (int) (key.charAt(pos) - 'A');
    }

    /**
     * Returns the encryption of the given character
     * 
     * @param ch character to be encrypted
     */
    @Override
    public char encrypt(char ch) {
        return Caesar.ceaserTransform(ch, getShift(key, letterPos++));
    }
    
    /**
     * Returns the decryption of the given character
     * 
     * @param ch character to be decrypted 
     */
    @Override
    public char decrypt(char ch) {
        return Caesar.ceaserTransform(ch, -getShift(key, letterPos++));
    }

    /**
     * Main entry point
     * @param args {encrypt/decrypt, key, input}
     */
    public static void main(String[] args) {
        final String guide = "Usage: java Vigenere encrypt key \"cipher text\"";
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

        Vigenere vigenere = new Vigenere(args[1]);
        if (args[0].equals("encrypt")) {
            System.out.println(vigenere.encrypt(args[2]));
        } else {
            System.out.println(vigenere.decrypt(args[2]));
        }
    }

}
