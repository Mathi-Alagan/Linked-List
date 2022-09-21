
public class linkedlist {

    private Node head;
    private Node tail;
    private int size; // just to keep track of the size

    public linkedlist() {
        this.size = 0; // initial size of ll
    }

    // private so that no other classes can access it
    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /*----------------------------------------------------METHODS--------------------------------------------------------------------*/

    // insertion @ beginning: rfr the hand-written notes for better understanding
    public void insertFirst(int val) {
        Node node = new Node(val); // creating an object for the newly inserted node; the upcoming new node's
                                   // objects will overwrite the previous reference made by the object
        node.next = head; // this is pretty self-explanatory
        head = node;

        // since while inserting the first node, tail would be pointing to null; this
        // condition is specifically for inserting the first node
        if (tail == null) {
            tail = node;
        }

        size += 1; // to keep track of the size of linked list; if not we have to traverse the
                   // whole list to find the size
    }

    // insertion @ end
    public void insertLast(int val) {

        // so to insert the first node alone, we better call the insertFirst method
        if (tail == null) {
            insertFirst(val);
            return; // so that the next statements after the if condition do not execute;
        }

        Node node = new Node(val);
        tail.next = node; // this will not work for inserting the first element; cuz tail will be a null
                          // node, it has no next value
        tail = node;

        /*
         * This approach is wrong, cuz when tail is at null, we cannot insert the first
         * element; so checking this condition is out of context
         * if(head==null)
         * head = node;
         */
        size += 1;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
        } else if (index == size - 1) {
            insertLast(val);
        } else {
            Node prev = get(index - 1); // prev => element before index
            /*
             * for(int i=1; i<=index-1; i++) //simple logic, visualize with an example it'll
             * be easy to understand
             * temp1 = temp1.next;
             */
            Node node = new Node(val, prev.next); // since we overloaded the constructor with this type also
            // Node temp2 = temp1.next;
            prev.next = node;
        }
        size += 1;

    }

    // deleting at the beginning
    public Object deleteFirst() {
        if (head == null) // trying to delete from an empty list; here tail would already be null
            return null;
        int del_data = head.value;
        head = head.next;
        if (head == null) // if we deleted a single element linkedlist(where head & tail point to same
                          // node), after head is moved and points to null, tail would be still pointing
                          // the deleted node
            tail = null;
        size--;
        return del_data;
    }

    // deletion at the end
    public Object deleteLast() {
        /*
         * if(head==null)
         * return null;
         * int del_val = tail.value;
         * if(head==tail) //if head and tail are same, it means only one element remains
         * head = tail = null;
         */

        // the below steps are optimized version of the previous comments
        if (head == null || head == tail)
            return deleteFirst();

        // to understand below steps visualize it with an example
        /*
         * int del_val = tail.value;
         * Node temp = head;
         * while(temp.next!=tail)
         * temp = temp.next;
         * tail = temp;
         * tail.next = null;
         * size--;
         * return del_val;
         */

        // the above comments can further be modified with help of get function
        int del_val = tail.value;
        Node secondLast = get(size - 2); // since we want to find the element before the last element
        tail = secondLast;
        tail.next = null;
        size--;
        return del_val;

    }

    public Object delete(int index) {
        if (index == 0)
            return deleteFirst();
        if (index == size - 1)
            return deleteLast();
        if (head == null || index > size) // just to check some edge cases
            return null;

        // visualize the below steps with an example
        Node prev = get(index - 1);
        int del_val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return del_val;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) // it will traverse till the index of the given element(if index is 3, 3 times
                                        // we have to iterate to get to that node)
            temp = temp.next;
        return temp;
    }

    // displaying the ll
    public void display() {
        Node temp = head; // since temp is of node type, it can potentially have a value and a next
                          // pointer; here, it has the valand next of the head node

        while (temp != null) {
            System.out.print(temp.value + "-> ");
            temp = temp.next; // it assigns itself with the node it was pointing
        }
        System.out.println("END\nSize of linked list: " + size);
    }

}