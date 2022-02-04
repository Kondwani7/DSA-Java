package com.company;
import java.util.LinkedList;
import java.util.List;

public class Main {
    //beginning of the list
    private static ListNode head;
    //first node / constructor
    private static class ListNode {
        final int data;
        private ListNode next;
        //data = integer, pointer = next
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
        //traverse through each element until we get to the node
        while(null!=current.next){
            current = current.next;
        }
        //this makes the last node our new node
        current.next = newNode;
    }

    public void insertTarget(int position, int value){
        ListNode targetNode = new ListNode(value);
        //if the linked list only has the head the target posiition is 1
        if(position ==1){
            //the head points at the targetNode
            targetNode.next = head;
            //head --> targetNode
            head = targetNode;
        } else {
            //the node just before our target node position
            //we initially assign it as a head so that we can traverse through the linked list
            //till we find the position just before the target node to prep for insertion
            ListNode previousNode = head;
            int count = 1;
            //traversal until we are 1 position behind the target position
            while(count < position -1){
                //asign it a pointer once found
                previousNode = previousNode.next;
                count++;
            }
            //the node in the current position we want our target node to occupy
            // previousNode --> currentNode
            ListNode currentNode = previousNode.next;
            // targetNode --> currentNode
            targetNode.next = currentNode;
            //previousNode --> targetNode --> currentNode
            previousNode.next = targetNode;
        }
    }
    //delete the first node/ head
    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        //assigning tempNode to the head/firstNode
        ListNode tempNode = head;
        //traverse to the second node and make it the head
        //tempNode --> head
        head = head.next;
        //delete the tempNode by assigning it to null
        tempNode.next = null;
        return  tempNode;
    }
    //delete last node from linked List
    public ListNode deleteLast(){
        if(head == null || head.next == null) {
            return null;
        }
        //traverse to the last node
        ListNode currentNode = head;
        //that will take the place of the last node
        ListNode previousNode = null;
        while(null!= currentNode.next){
            //previousNode --> currentNode;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        //now delete the last node
        previousNode.next = null;
        return currentNode;
    }

    public ListNode deleteTarget(int position){
        if(position ==1){
            head = head.next;
        }
        ListNode previousNode = head;
        int count = 0;
        //traversal until the node before the target
        while(count < position - 1){
            previousNode = previousNode.next;
            count++;
        }
        //establish a pointer to the target node that we want to delete
        ListNode currentNode = previousNode.next;
        //by assigning the previous to the node next to the current, we delete it
        //previousNode -- //currentNode// --> newCurrentNode
        previousNode.next = currentNode.next;
        return currentNode;
    }
    //reverse a linked list
    public ListNode reverseLL(){
        if(head == null){
            return null;
        }
        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return  prevNode;
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
        //insert at the end of linked list
        l1.insertLast(77);
        l1.insertLast(88);
        l1.insertLast(99);
        l1.insertLast(110);
        l1.insertLast(121);
        l1.insertLast(132);
        //insert at position 7
        l1.insertTarget(7, 55);
        //insert at position 8
        l1.insertTarget(8, 66);
        //print linked list
        l1.display();
        //get list length
        System.out.println("Length of linked list:"+ l1.listLength());
        //delete first node and check data
        System.out.println("data deleted from first Node:" + l1.deleteFirst().data);
        l1.display();
        System.out.println("data deleted from last Node:" + l1.deleteLast().data);
        l1.display();
        System.out.println("data removed from targetNode:" + l1.deleteTarget(10));
        l1.display();
        //search if a node contains specified data
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);
        l2.add(7);
        int targetElem = 5;
        //initializing the answer to the index -1
        int ans = -1;
        for (int i =0; i < l2.size(); i++){
            int llElem = l2.get(i);
            if(llElem == targetElem){
                ans = i;
                break;
            }
        }
        //check if the element is present in the linked list
        if(ans == -1){
            System.out.println("Element not in linked list");
        } else {
            System.out.println("Element in linked list:" + ans);
        }
    }
}
