package Coupling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // tight coupling
        Dog d = new Dog();
        Cat c = new Cat();

        // loose coupling
        Animal obj = null;

        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter u r preference : ");
        String u = sc.nextLine();

        // object creating at runtime
        obj = (Animal) Container.getObj(u);

        // tight coupling method calling
        if (u.equals("dog")) {
            d.sound();
        }
        else {
            c.sound();
        }

        // loose coupling method calling
        if (obj != null) {
            obj.details();
        }

        sc.close();
    }
}
