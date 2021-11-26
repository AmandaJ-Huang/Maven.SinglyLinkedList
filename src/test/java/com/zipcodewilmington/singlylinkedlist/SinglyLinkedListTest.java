package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testRemoveAtZeroIndex() {
        // Given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        Integer expected = 2;

        // When
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(0);

        Integer actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveAtLastIndex() {
        // Given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        Integer expected = 4;

        // When
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.remove(linkedList.size()-1);

        Integer actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveOutOfBoundsIndex() {
        // Given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        Integer expected = 3;

        // When
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(4);
        Integer actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveAtMiddleIndex() {
        // Given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        Integer expected = 4;

        // When
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.remove(2);
        Integer actual = linkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains() {
        // Given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        String expected = "dog";

        // When
        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("bird");

        Boolean actual = linkedList.contains(expected);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFind() {
        // Given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        String target = "bird";
        Integer expected = 2;

        // When
        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("bird");

        Integer actual = linkedList.find(target);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
