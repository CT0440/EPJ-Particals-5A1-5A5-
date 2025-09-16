package coupling2;

public class Container {
    private static Dog dog;
    private static Cat cat;

    public static Object getObj(String type) {
        if (type.equals("dog")) {
            if (dog == null) {
                dog = new Dog();
            }
            return dog;
        }

        if (type.equals("cat")) {
            if (cat == null) {
                cat = new Cat();
            }

            return cat;
        }

        return null;
    }
}
