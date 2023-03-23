import java.util.HashMap;
import java.util.Map;

/**
 * Extends the Substitution class to implement its char de/encrypt methods.
 * Represents a substitution cipher where every character in the
 * plaintext is replaced with a fixed letter in the encrypted text.
 * 
 * @author Yuvaraj Konjeti
 */
public class MonoAlphaSubstitution extends Substitution {

    private Map<Character, Character> encryptTable, decryptTable;

    /**
     * Constructs the identity substitution cipher
     */
    public MonoAlphaSubstitution() {
        this("");
    }

    /**
     * Constructs a new MonoAlphabeticSubstitution cipher with the given key
     * 
     * @param key The key to encrypt and decrypt
     */
    public MonoAlphaSubstitution(String s) {
        encryptTable = new HashMap<Character, Character>();
        decryptTable = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i += 2) {
            encryptTable.put(s.charAt(i), s.charAt(i + 1));
            decryptTable.put(s.charAt(i + 1), s.charAt(i));
        }
    }

    /**
     * Returns the encryption of the given character
     * 
     * @param ch character to be encrypted
     */
    @Override
    public char encrypt(char ch) {
        return encryptTable.containsKey(ch)
                ? encryptTable.get(ch)
                : ch;
    }

    /**
     * Returns the decryption of the given character
     * 
     * @param ch character to be decrypted
     */
    @Override
    public char decrypt(char ch) {
        return decryptTable.containsKey(ch)
                ? decryptTable.get(ch)
                : ch;
    }

    /**
     * Main entry point
     * 
     * @param args {encrypt/decrypt, key, input}
     */
    public static void main(String[] args) {
        final String guide = "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"";
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

        MonoAlphaSubstitution monoAlphaSubstitution = new MonoAlphaSubstitution(args[1]);
        if (args[0].equals("encrypt")) {
            System.out.println(monoAlphaSubstitution.encrypt(args[2]));
        } else {
            System.out.println(monoAlphaSubstitution.decrypt(args[2]));
        }
    }
}
