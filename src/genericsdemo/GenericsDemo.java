package genericsdemo;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author justin
 */
public class GenericsDemo {

    public static void main(String[] args) {
        /* Here we create four MyContainer objects and show that we can put
         * any type into them. Note that the generic type has to be a reference
         * type; we couldn't put a primitive in there.
         */
        MyContainer<String> container1 = new MyContainer("Hello");
        MyContainer<Integer> container2 = new MyContainer(5);
        MyContainer<java.util.Random> container3 = new MyContainer(new java.util.Random());
        MyContainer<Anything> container4 = new MyContainer(new Anything("Fred", 5));
        
        System.out.println(container1.get());
        System.out.println(container2.get());
        System.out.println(container3.get());
        System.out.println(container4.get());
        
        /* It is probably rare that you will use Java Generics to create
         * your own containers. Much more likely you will use it to specify  
         * the type of object to be held in a list object from the Java
         * library.
         */
        List<Anything> myList = new ArrayList();
        myList.add(new Anything("First", 1));
        myList.add(new Anything("Second", 2));
        myList.add(new Anything("Third", 3));
        System.out.println(myList.get(1));
    }
    
}

class MyContainer<T>{
    /* T is not a type, it is a type variable.
     * The variable t is an object of type T, even though we don't yet know 
     * what type T is. 
     */
    T t;
    public MyContainer(T t) {
        this.t = t;
    }
    
    T get(){
        return t;
    }
}

class Anything {
    String name;
    int number;
    
    public Anything(String name, int number) {
        this.name = name;
        this.number = number;
    }
    
    public String toString() {
        return "Anything object: " + name + ", " + number;
        
    }
}
