/**
 * LinkedQueueImplementation.java
 * An implementation of the Queue ADT using circulary linked nodes.
 * @param <T> The type of data that the queue stores.
 * @author Frederik Roenn Stensaeth.
 * Created 05.21.14
 */
public class LinkedQueueImplementation<T> implements Queue<T> {
    /** Node variable last_node refers to the last node in the queue. */
    private Node last_node = null;
    /** Class for Nodes. Nodes keep track of value and what is the next 
     * node. */
    private class Node {
        /** T variable val is the value a node holds. */
        public T val;
        /** Node variable next is the next node in the chain. */
        public Node next;
        /** Creates an instance of the node. */
        private Node(T value) {
            val = value;
            next = null;
        }
    }
  
    /** Adds the given item to the back of the queue.
     * @param item the item to add.
     */
    public void enqueue(T item) {
        // Checks if item is valid.
        if(item != null) {
            Node new_node = new Node(item);
            // Checks if queue is empty.
            // Sets next of new_node to be itself, and sets last_node to be
            // new_node.
            if(isEmpty()) {
                new_node.next = new_node;
                last_node = new_node;
            // Sets next of new_node to be first node, and next of last_node
            // to be new_node. last_node is now new_node.
            } else {
                new_node.next = last_node.next;
                last_node.next = new_node;
                last_node = new_node;
            }
        }
    }

    /** Removes an item from the front of the queue and returns it.
     * @return the item at the front of the queue, or null if empty.
     */
    public T dequeue() {
        // Checks if queue is empty and returns null.
        if(isEmpty()) {
            return null;
        }
        // Gets value of first node.
        T value = last_node.next.val;
        // Checks if queue only contains a single item and sets 
        // last_node to null.
        if(last_node == last_node.next) {
            last_node = null;
        } else {
            last_node.next = last_node.next.next;
        }
        return value;
    }

    /** Returns the item at the front of the queue, without removing it.
     * @return the item at the front of the queue, or null if empty.
     */
    public T peek() {
        // Checks if queue is empty and returns null.
        if(isEmpty()) {
            return null;
        }
        // Returns value of first node.
        return last_node.next.val;
    }

    /** Returns true if the queue is empty. */
    public boolean isEmpty() {
        if(last_node == null) {
            return true;
        }
        return false;
    }

    /** Removes all items from the queue. */
    public void clear() {
        if(last_node != null) {
            last_node.next = null;
            last_node = null;
        }
    }

    /** XX */
    public static void main(String[] args) {
        int count = 0;
        Queue<String> test = new LinkedQueueImplementation<String>();
        if(test.isEmpty() == false) {
            System.out.println(
                "*** isEmpty FAILED; Expected true, got false ***");
            count++;
        }
        test.enqueue("leg");
        test.enqueue("arm");
        test.enqueue("body");
        test.enqueue("null");
        if(!test.peek().equals("leg")) {
            System.out.printf(
                "*** enqueue FAILED; Expected leg, got %s ***\n", test.peek());
            count++;
        }
        String top = test.dequeue();
        if(!top.equals("leg")) {
            System.out.printf(
                "*** dequeue FAILED; Expected leg, got %s ***\n", top);
            count++;
        }
        top = test.dequeue();
        if(!top.equals("arm")) {
            System.out.printf(
                "*** dequeue FAILED; Expected arm, got %s ***\n", top);
            count++;
        }
        if(test.isEmpty() == true) {
            System.out.println(
                "*** isEmpty FAILED; Expected false, got true ***");
            count++;
        }
        test.clear();
        if(test.isEmpty() == false) {
            System.out.println(
                "*** isEmpty FAILED; Expected true, got false ***");
            count++;
        }
        test.enqueue("0");
        top = test.dequeue();
        if(!top.equals("0")) {
            System.out.printf(
                "*** dequeue FAILED; Expected 0, got %s ***\n", top);
            count++;
        }
        test.clear();
        test.clear();
        if(test.isEmpty() == false) {
            System.out.println(
                "*** clear FAILED; Expected empty queue, got non-empty ***");
            count++;
        }
        test.enqueue(null);
        if(test.isEmpty() == false) {
            System.out.println(
                "*** enqueue FAILED; Expected empty queue, got null item ***");
            count++;
        }

        Queue<Integer> test2 = new LinkedQueueImplementation<Integer>();
        for(int i = 0; i < 100; i++) {
            test2.enqueue(i);
        }
        if(!test2.peek().equals(0)) {
            System.out.printf(
                "*** enqueue FAILED; Expected 0, got %d ***\n", test2.peek());
            count++;
        }
        for(int i = 0; i < 100; i++) {
            Integer item = test2.dequeue();
            if(!item.equals(i)) {
                System.out.printf(
                    "*** enqueue FAILED; Expected 0, got %d ***\n", item);
                count++;
            }
        }
        if(test.isEmpty() == false) {
            System.out.println(
                "*** enqueue FAILED; Expected true, got null false ***");
            count++;
        }

        if(count == 0) {
            System.out.println("All tests were successful!");
        }
    }
}