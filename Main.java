

public class Main {
    public static void main(String[] args) {
        linkedlist ll1 = new linkedlist();        
        ll1.insertFirst(32);
        ll1.insertFirst(1);
        ll1.insertFirst(9);
        ll1.insertFirst(16);
        ll1.insertFirst(99); 

        ll1.insertLast(100);

        ll1.insert(2, 3);

        System.out.println(ll1.deleteFirst());
        

        ll1.display();

    }
}
