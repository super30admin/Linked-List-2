// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Intuition is to make pointers in both the lists to be at the same position before the intersection of the lists.
1. calculate length of both the lists
2. increment the pointer of longer list till the length of both lists become equal.
3. increment both pointers of the lists until they reach a common element.
 */

public class IntersectingLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        // calculating length of linked list A
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        //calculating length of linked list B
        curr = headB;
        while(curr != null){
            curr= curr.next;
            lenB++;
        }
        //when length of linked list A is greater than length of linked list B
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        //when length of linked list B is greater than length of linked list A
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headB; // or headA, both would be at the same position
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(9);
        ListNode next2 = new ListNode(1);
        ListNode next3 = new ListNode(2);
        ListNode next4 = new ListNode(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = null;

        ListNode head1 = new ListNode(3);
        head1.next = next3;

        System.out.println("Before 1");
        printList(head);
        System.out.println("");
        System.out.println("Before 2");
        printList(head1);

        System.out.println("");
        System.out.println("Intersecting node:");
        System.out.print(getIntersectionNode(head, head1).val); //2
    }
}
