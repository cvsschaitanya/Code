public class Temp {
    public static void main(String[] args) {
        Cipher c = new Vigenere();
        System.out.println(c.decrypt("pex"));

        MonoAlphaSubstitution m = new MonoAlphaSubstitution();
        System.out.println(m.encrypt('i'));
    }
}
