
/**
 *
 * @author Bayu Aji Firmansyah
 */
public class SinglyLinkedList<E> {

    class Node {

        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
    }

    public SinglyLinkedList(E data) {
        this.head = new Node(data);
        size++;
    }

    public void empty() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return this.size;
    }

    // add Node before head
    public void addFirst(E data) {
        Node temp = head;
        this.head = new Node(data);
        this.head.next = temp;
        size++;
    }

    // add Node after tail
    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(data);
            size++;
        }
    }

    // add node after Node that has a value
    public void insert(E find, E insert) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.data == find) {
                Node temp = pointer.next;
                pointer.next = new Node(insert);
                pointer.next.next = temp;
                size++;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }

    }

    public void removeLast() {
        if (!isEmpty()) {
            Node pointer = head;
            if (head.next == null) {
                empty();
            } else {
                while (pointer.next.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = null;
                size--;
            }
        }
    }

    // remove node that containing the data
    public void remove(E data) {
        if (!isEmpty()) {
            Node pointer = head;            
            if (pointer.data == data) {
                removeFirst();
            } else {
                while (pointer.next.next != null) {
                    if (pointer.next.data == data) {
                        pointer.next = pointer.next.next;
                        size--;
                        return;
                    }
                    pointer = pointer.next;
                }
                if (pointer.next.data == data) {
                    pointer.next = null;
                }
            }
        }
    }

    public void print() {
        Node pointer = head;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        while (pointer != null) {
            System.out.print(pointer.data + "->");
            pointer = pointer.next;
        }
    }

}
