public class Caeser extends MonoAlphaSubstitution {
    public Caeser() {
    }

    public static char ceaserTransform(char ch, int shift) {
        if (!Character.isLetter(ch))
            return ch;

        shift = shift < 0 ? 26 + shift : shift;

        char base = Character.isUpperCase(ch) ? 'A' : 'a';
        return (char) (base + (((ch - base) + shift) % 26));
    }

    private static String getCaeserStr(int k) {
        String s = "";
        for (char ch = 'a', CH = 'A'; ch <= 'z'; ch++, CH++) {
            s = s + ch + ceaserTransform(ch, k)
                    + CH + ceaserTransform(CH, k);
        }
        return s;
    }

    public Caeser(int k) {
        super(getCaeserStr(k));
    }

    public static void main(String[] args) {
        final String guide = "Usage: java Caeser encrypt n \"cipher text\"";
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

        Caeser caeser = new Caeser(Integer.parseInt(args[1]));
        if (args[0].equals("encrypt")) {
            System.out.println(caeser.encrypt(args[2]));
        } else {
            System.out.println(caeser.decrypt(args[2]));
        }
    }
}
