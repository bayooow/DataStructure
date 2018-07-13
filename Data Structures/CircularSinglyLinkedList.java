/**
 *
 * @author Bayu Aji Firmansyah
 */
public class CircularSinglyLinkedList<E> {

    class Node {

        E data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    public CircularSinglyLinkedList() {
        head = tail = null;
    }

    public CircularSinglyLinkedList(E data) {
        head = tail = new Node(data);
        tail.next = head;
        size++;
    }

    public void empty() {
        head = tail = null;

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
        tail.next = head;

    }

    // add Node after tail
    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node pointer = head;
            while (pointer.next != head) {
                pointer = pointer.next;
            }
            tail = pointer.next = new Node(data);
            tail.next = head;
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
                if (pointer == tail) {
                    tail = pointer.next;
                }
                tail.next = head;
                size++;
                break;
            }

        }
//        1 2 3 4 5 6 7
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head.next == head) {
                empty();
                return;
            }
            head = head.next;
            tail.next = head;
            size--;
        }

    }

    public void removeLast() {
        if (!isEmpty()) {
            Node pointer = head;
            if (head.next == head) {
                empty();
            } else {
                while (pointer.next.next != head) {
                    pointer = pointer.next;
                }
                pointer.next = null;
                tail = pointer;
                tail.next = head;
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
                while (pointer.next.next != head) {
                    if (pointer.next.data == data) {
                        pointer.next = pointer.next.next;
                        size--;
                        return;
                    }
                    pointer = pointer.next;
                }
                while (pointer.next.data == data) {
                    pointer.next = head;
                    tail = pointer;
                    tail.next = head;
                }

            }
        }
//        1 2 3 4 5 6 7 
    }

    public void print() {
        Node pointer = head;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        } else {
            System.out.print(head.data + "->");
            pointer = pointer.next;
            while (pointer != head) {
                System.out.print(pointer.data + "->");
                pointer = pointer.next;
            }
            System.out.println("");
        }

    }

}
