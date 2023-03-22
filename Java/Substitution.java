public abstract class Substitution implements Cipher {

    public String encrypt(String plainText) {
        String result = "";
        for (char ch: plainText.toCharArray()) {
            result += encrypt(ch);
        }
        return result;
    }

    public String decrypt(String cryptoText) {
        String result = "";
        for (char ch : cryptoText.toCharArray()) {
            result += decrypt(ch);
        }
        return result;
    }

    public abstract char encrypt(char ch);

    public abstract char decrypt(char ch);

}
