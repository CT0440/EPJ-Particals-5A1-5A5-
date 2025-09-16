package Coupling;

public class Container {
    private static Dog d;
    private static Cat c;

    public static Object getObj(String pref) {
        if (pref.equals("dog")) {
            if (d == null) {
                d = new Dog();
            }

            return d;
        }

        if (pref.equals("cat")) {
            if (c == null) {
                c = new Cat();
            }

            return c;
        }

        return null;
    }
}
