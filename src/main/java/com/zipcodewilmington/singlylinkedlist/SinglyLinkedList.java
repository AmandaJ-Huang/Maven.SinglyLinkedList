package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<Element extends Comparable<Element>> {

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

        void setData(Element data) { this.data = data; }
    }

    private Node head;
    private Node tail;
    private Integer size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Element data) {
        Node node = new Node(data);

        if (this.head == null) {
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
        Node currNode = this.head;
        Integer counter = 0;

        if (index < 0 || index > size) {
            return null;
        }

        while(counter != index) {
            currNode = currNode.getNextNode();
            counter++;
        }
        return currNode.getData();
    }

    public SinglyLinkedList<Element> copy() {
        SinglyLinkedList<Element> newList = new SinglyLinkedList<Element>();
        Node currNode = this.head;

        while (currNode != null) {
            Element data = currNode.getData();
            newList.add(data);
            currNode = currNode.getNextNode();
        }
        return newList;
    }

    public void sort() {
        Node currNode = this.head;
        Node nextNode;
            /*
            Comparable returns:
                -1  - object is < specified object
                0   - object is = specified object
                1   - object is > specified object
             */

        for(int i = 0; i < size; i++){
            while(currNode.getNextNode() != null){
                nextNode = currNode.getNextNode();
                if(currNode.getData().compareTo(nextNode.getData()) > 0){
                    Element tmp = currNode.getData();
                    currNode.setData((nextNode.getData()));
                    nextNode.setData(tmp);
                }
                currNode = currNode.getNextNode();
            }
            currNode = this.head;
        }

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
