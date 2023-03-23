/**
 * An abstract class that implements the Cipher interface.
 * It represents a cipher where each character is de/encrypted one at a time.
 * It exposes two abstract methods with same name as the 
 * Cipher interface but with char arguments instaed.
 * 
 * @author Yuvaraj Konjeti
 */
public abstract class Substitution implements Cipher {

    /**
     * Given a string, encrypts it character by character
     * 
     * @param plainText plain text
     */
    @Override
    public String encrypt(String plainText) {
        String result = "";
        for (char ch: plainText.toCharArray()) {
            result += encrypt(ch);
        }
        return result;
    }

    /**
     * Given a string, decrypts it character by character
     * 
     * @param cryptoText encryptedString
     */
    @Override
    public String decrypt(String cryptoText) {
        String result = "";
        for (char ch : cryptoText.toCharArray()) {
            result += decrypt(ch);
        }
        return result;
    }

    /**
     * Returns the encryption of the given character
     * 
     * @param ch character to be encrypted
     */
    public abstract char encrypt(char ch);

    /**
     * Returns the decryption of the given character
     * 
     * @param ch character to be decrypted
     */
    public abstract char decrypt(char ch);

}
