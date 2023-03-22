public class Vigenere extends Substitution {

    int letterPos = 0;
    String key;

    public Vigenere() {
        this("A");
    }

    public Vigenere(String key) {
        this.key = key;
    }

    private int getShift(String key, int pos) {
        pos = pos % key.length();
        return (int) (key.charAt(pos) - 'A');
    }

    public char encrypt(char ch) {
        return Caeser.ceaserTransform(ch, getShift(key, letterPos++));
    }
    
    public char decrypt(char ch) {
        return Caeser.ceaserTransform(ch, -getShift(key, letterPos++));
    }

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
