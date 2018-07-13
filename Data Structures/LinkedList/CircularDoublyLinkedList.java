/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author Bayu Aji Firmansyah
 */
public class CircularDoublyLinkedList<E> {

    class Node {

        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    public CircularDoublyLinkedList() {
        head = tail = null;
    }

    public CircularDoublyLinkedList(E data) {
        head = tail = new Node(data);
        head.prev = tail;
        tail.next = head;
        size++;
    }

    public void empty() {
        head = null;
        size = 0;
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
        temp.prev = head;
        head.prev = tail;
        tail.next = head;
        size++;
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
            tail.prev = pointer;
            tail.next = head;
            head.prev = tail;
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
                pointer.next.prev = pointer;
                pointer.next.next = temp;
                temp.prev = pointer.next;
                if (pointer == tail) {
                    tail = pointer.next;
                }
                tail.next = head;
                head.prev = tail;
                size++;
                size++;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head.next == head) {
                empty();
                return;
            }
            head = head.next;
            head.prev = tail;
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
                pointer.next = head;
                tail = pointer;
                head.prev = tail;
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
                        pointer.next.prev = pointer;
                        size--;
                        return;
//                        1 2 3 4 5 6
                    }
                    pointer = pointer.next;
                }
                if (pointer.next.data == data) {
                    tail = pointer;
                    tail.next = head;
                    head.prev = tail;
                }
            }
        }
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

    public void printReverse() {
        Node pointer = tail;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        } else {
            System.out.print(pointer.data + "->");
            pointer = pointer.prev;
            while (pointer != tail) {
                System.out.print(pointer.data + "->");
                pointer = pointer.prev;
            }
            System.out.println("");
        }
    }
}
