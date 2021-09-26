package main.java.simple;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertNodeAtSpecificPositionInLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
     *
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-insert-a-node-at-a-specific-position-in-a-linked-list
     */


    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode prev  = llist;
        for(int i = 0; i < position - 1; i++){
            prev  = prev.next;
        }
        SinglyLinkedListNode next  = prev.next;
        SinglyLinkedListNode current = new SinglyLinkedListNode(data);
        current.next = next;
        prev.next = current;
        return llist;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ");

        scanner.close();
    }
}
