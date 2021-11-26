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

        Element getData() {
            return this.data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private Integer size = 0;

    public void add(Element data) {
        Node node = new Node(data);

        if (head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
    }

    public void remove(int index) {
        Node prevNode = this.head;
        Node currNode = this.head.getNextNode();

        if (index < 0 || index > this.size-1) {
            return;
        }
        if (index == 0) {
            this.head = this.head.getNextNode();
        }

        for (int i = 0; i < index-1; i++) {
            currNode = currNode.getNextNode();
            prevNode = prevNode.getNextNode();
        }
        prevNode.next = currNode.getNextNode();

        this.size--;
    }

    public Boolean contains(Element element) {
        Node currNode = this.head;
//        for (int i = 0; i < size; i++) {
//            if (currNode.getData().equals(element)) {
//                return true;
//            }
//            currNode = currNode.getNextNode();
//        }
        while(currNode != null) {
            if (currNode.getData().equals(element)) {
                return true;
            }
            currNode = currNode.getNextNode();
        }
        return false;
    }

    public Integer find(Element element) {
        Node currNode = this.head;
        Integer counter = 0;

        while(currNode != null) {
            if (currNode.getData().equals(element)) {
                return counter;
            }
            currNode = currNode.getNextNode();
            counter++;
        }
        return -1;
    }

    public Integer size() {
        return this.size;
    }

    public Element get(int index) {

        return null;
    }

    public SinglyLinkedList<Element> copy() {
        return null;
    }

    public void sort() {

    }

    public String toString() {
        Node currNode = this.head;
        String s = "";

        while (currNode != null) {
            s += currNode.data;
            currNode = currNode.getNextNode();
        }

        return s;
    }


}
