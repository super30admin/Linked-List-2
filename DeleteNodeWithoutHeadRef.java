//Time Complexity = O(1)
//Space Complexity = O(1)
//Does it run on LeetCode successfully? : Yes
//Any difficulties: Come up with logic was challenge. You have to solve problem before hand. I used chatgpt lol.

/*
You can not delete last node with this without head ref as this is singly linked list.
Copy the value of next node in to current node that you are being asked to delete and free next node memory.
*/

//You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given.
// Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail node in the linked list.

// Condition is to delete it without any extra space and in O(1).
// Time: O(1), Space: O(1)

//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
//Tail can not be deleted
public class DeleteNodeWithoutHeadRef {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}//empty constructor
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    private void deleteNode(ListNode nodeToBeDeleted){
        if(nodeToBeDeleted.next == null) { //Node to be deleted is last node in the LinkedList;
            nodeToBeDeleted = null;
            return;
        }
       //If it is any node including head node
        ListNode nextNode = nodeToBeDeleted.next;
        nodeToBeDeleted.val = nextNode.val;
        nodeToBeDeleted.next = nextNode.next;
        nextNode = null;
    }

    public static void main(String[] args){
        DeleteNodeWithoutHeadRef dnode = new DeleteNodeWithoutHeadRef();
        ListNode head = dnode.new ListNode(1);
        head.next = dnode.new ListNode(2);
        head.next.next = dnode.new ListNode(3);
        head.next.next.next = dnode.new ListNode(4);
        head.next.next.next.next = dnode. new ListNode(5);

        ListNode printme = head;
        while(printme!= null){
            System.out.print(printme.val +" --> " );
            printme = printme.next;
        }

        ListNode deletenode = head.next.next.next.next;
        System.out.println("\n : " +deletenode);

        dnode.deleteNode(deletenode);

        System.out.println("\nList after deletion of node : ");
        printme = head;
        while(printme!= null){
            System.out.print(printme.val +" --> " );
            printme = printme.next;
        }



    }
}