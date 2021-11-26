package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<Element> {

    private class Node {
        Element data;
        Node next;

        Node(Element data) {
            this.data = data;
            this.next = null;
        }

        void setNextNode(Node node) {
            this.next = node;
        }

        Node getNextNode() {
            return this.next;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void add(Element data) {
        Node node = new Node(data);

        if (head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

    public void remove(int index) {

    }

    public Boolean contains(Element element) {
        return true;
    }

    public Integer find(Element element) {
        return -1;
    }

    public Integer size(Element element) {
        return -1;
    }

    public Element get(int index) {
        return null;
    }


}
