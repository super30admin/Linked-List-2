//Time Complexity = O(n)
//Space Complexity = O(1)
// Does it run on LeetCode successfully? : Yes
// Any difficulties: Conditions check while traversing.

/*
Find Middle
Reverse second half of the linkedlist
merge both part to form output
*/

public class ReorderList {

    class ListNode{// Singly Linkedlist representation
        int val;
        ListNode next; //initially it is alway null unless specified. This is object reference.

        ListNode(){ //Empty Constructor
        }
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        //find middle element of LinkedList
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){ //I made a mistake in this condition
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at middle element. For odd length LinkedList, it is always skewed.
        System.out.println("Middle element is : " + slow.val);

        fast = reverse(slow.next); //reverse second half of LinkedList.
        slow.next = null; //breaking the links between first and second part of the linkedList

        //merging two part of the list to form the output.
        slow = head;
        ListNode temp = null;
        while(fast!= null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head){
        //Using 3 pointers approach - Reversing second half of the list here
        ListNode prev = null;
        ListNode curr = head;
        ListNode fst = null; // purposely here naming fst instead of fast to avoid confusion with above fast pointer.

        while(curr!=null){
            fst = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fst;
        }

        return prev;
    }

    public static void main(String[] args){
        ReorderList list = new ReorderList();

        ListNode head = list.new ListNode(2);
        head.next = list.new ListNode(03);
        head.next.next = list.new ListNode(5);
        head.next.next.next = list.new ListNode(9);
        head.next.next.next.next = list.new ListNode(-11);
        head.next.next.next.next.next = list.new ListNode(31);
        list.reorderList(head);
    }
}