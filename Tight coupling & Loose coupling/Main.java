package coupling2;

public class Main {
    public static void main(String[] args) {
        // tight coupling
        Dog obj = new Dog();
        Cat obj2 = new Cat();

        // loose couping
        Animal obj3 = (Cat) Container.getObj("cat"); // new Cat();

        obj.details();
        obj2.sound();
        obj3.details();
    }
}
