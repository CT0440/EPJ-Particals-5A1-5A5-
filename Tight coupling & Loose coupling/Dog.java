package coupling2;

public class Dog implements Animal {
    
    String name;
    String color;

    Dog() {
        this.name = "chintu bahi";
        this.color = "brown";
    }
    
    public void sound() {
        System.out.println("Dog is start souding");
     };

     public void details() {
        System.out.println(name + " - " + color);
     };
}
