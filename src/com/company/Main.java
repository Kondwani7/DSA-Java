package com.company;

import java.util.List;

public class Main {
        //begining of the list
        private ListNode head;
        //first node
        private static class ListNode {
            private int data;
            private ListNode next;
            //data -> integer, pointer -> next
            public ListNode(int data) {
                this.data = data;
                // the last node points to null
                this.next = null;
            }
        }
        //display linkedlist



    public static void main(String[] args) {
        Main l1 = new Main();
        l1.head = new ListNode(1);
        ListNode second = new ListNode(11);
        ListNode third = new ListNode(22);
        ListNode four = new ListNode(33);
        ListNode five = new ListNode(44);
        //connecting the nodes to create chain
        l1.head.next = second;// 1 -->11
        second.next =  third;//1-->11-->22
        third.next = four;//1-->11-->22-->33
        four.next = five;//1-->11-->22-->33-->44
    }
}
