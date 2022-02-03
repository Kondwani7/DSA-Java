package com.company;


public class Main {
    //beginning of the list
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
    //display linked List
    public void display(){
        //assigning a current node as the head of our list
        ListNode current = head;
        while(current != null) {
            System.out.println(current.data + "--> ");
            //ensuring that the current node traverses through each node until it reaches the node
            // last pointer = null
            current = current.next;
        }
        System.out.println("null");
    }
    //get the count of the linked list

    public int listLength(){
        //if the list has no nodes
        if (head == null) {
            return 0;
        }
        int count =0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    //insert into the first element of the linked list
    public  void insertFirst(int value){
        //initialize a new node with a value
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    //insert at end of list
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        //the head's pointer is null, it has no elements
        //therefore the newNode can become the last element
        if(head == null) {
            head = newNode;
            return;
        }
        //when the linked list has elements
        ListNode current = head;
        //travese through each element until we get to the node
        while(null!=current.next){
            current = current.next;
        }
        //this makes the last node our new node
        current.next = newNode;
    }



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
        //insert into the head of the linked list
        l1.insertFirst(0);
        l1.insertFirst(0);
        //insert at the end of linked list
        l1.insertLast(55);
        //print linked list
        l1.display();
        //get list length
        System.out.println("Length of linked list:"+ l1.listLength());
    }
}
