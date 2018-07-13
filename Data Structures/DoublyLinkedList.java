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
public class DoublyLinkedList<E> {

    class Node {

        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public DoublyLinkedList() {
        head = null;
    }

    public DoublyLinkedList(E data) {
        this.head = new Node(data);
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
        head.next.prev = head;
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
            pointer.next.prev = pointer;
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
//                temp.prev = pointer.next;
                size++;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head.next == null) {
                empty();
                return;
            }
            head = head.next;
            head.prev = null;
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
                        pointer.next.prev = pointer.next;
                        size--;
                        return;
//                        1 2 3 4 5 6
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
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void printReverse() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println("");
    }

}
