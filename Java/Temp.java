public class Temp {
    public static void main(String[] args) {
        Cipher c = new Caeser(10);
        System.out.println(c.decrypt("pex"));

        MonoAlphaSubstitution m = new MonoAlphaSubstitution("akbjcidhegffgehdicjbka");
        System.out.println(m.encrypt('i'));
    }
}
