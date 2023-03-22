import java.util.HashMap;
import java.util.Map;

public class MonoAlphaSubstitution extends Substitution {

    private Map<Character, Character> encryptTable, decryptTable;

    public MonoAlphaSubstitution() {
        this("");
    }

    public MonoAlphaSubstitution(String s) {
        encryptTable = new HashMap<Character, Character>();
        decryptTable = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i += 2) {
            encryptTable.put(s.charAt(i), s.charAt(i + 1));
            decryptTable.put(s.charAt(i + 1), s.charAt(i));
        }
    }

    public char encrypt(char ch) {
        return encryptTable.containsKey(ch)
                ? encryptTable.get(ch)
                : ch;
    }

    public char decrypt(char ch) {
        return decryptTable.containsKey(ch)
                ? decryptTable.get(ch)
                : ch;
    }

    public static void main(String[] args) {
        final String guide = "Usage: java MonoSubstitution encrypt key \"cipher text\"";
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
