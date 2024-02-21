//Time Complexity = O(m+n)
//Space Complexity = O(1)
// Does it run on LeetCode successfully? : Yes
// Any difficulties: None.

/*
Find Delta between both's length
Move Bigger List's head by that delta.
Traverse until both heads are same.
*/

public class IntersectionOfList {

    class ListNode{// Singly Linkedlist representation
        int val;
        ListNode next; //initially it is always null unless specified. This is object reference.

        ListNode(){ //Empty Constructor
        }
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA =1;
        int lenB =1;

        while(nodeA !=null){
            nodeA = nodeA.next;
            lenA +=1;
        }

        while(nodeB !=null){
            nodeB = nodeB.next;
            lenB +=1;
        }

        nodeA = headA;
        nodeB = headB;
        if(lenA > lenB){
            int diff = (lenA-lenB);
            while(diff>0){
                nodeA = nodeA.next;
                diff--;
            }
        }else{
            int diff = (lenB-lenA);
            while(diff>0){
                nodeB = nodeB.next;
                diff--;
            }
        }

        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA; //It could be return nodeB
    }


    public static void main(String[] args){
        IntersectionOfList list = new IntersectionOfList();

        ListNode head = list.new ListNode(2);
        head.next = list.new ListNode(03);
        head.next.next = list.new ListNode(5);
        head.next.next.next = list.new ListNode(9);
        head.next.next.next.next = list.new ListNode(-11);
        head.next.next.next.next.next = list.new ListNode(31);

        ListNode headA = head;

        ListNode headB = list.new ListNode(1);
        headB.next = list.new ListNode(21);
        headB.next.next = list.new ListNode(31);
        headB.next.next.next = list.new ListNode(4);
        headB.next.next.next.next = list.new ListNode(5);
        headB.next.next.next.next.next = list.new ListNode(-11);
        headB.next.next.next.next.next.next = list.new ListNode(41);
        headB.next.next.next.next.next.next.next = list.new ListNode(44);

        list.getIntersectionNode(headA, headB);

        // Print the linked list after deletion
        //Print ListA
        ListNode current = headA;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        //Print ListB
        current = headB;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}