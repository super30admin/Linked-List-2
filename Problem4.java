// Time Complexity : O(m + n) where m and n are lengths of linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem4 {
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calculate length of the two linked lists
        int lenA = length(headA), lenB = length(headB);
        // if linkedlist B is shorter, call the function getIntersectionNode(headB, headA)
        if (lenB < lenA) {
            return getIntersectionNode(headB, headA);
        }
        // Set currA and currB pointers to respective heads of linked lists A and B
        ListNode currA = headA, currB = headB;
        // Advance head pointer of B(longer linked list) by (lenb - lenA) so that the distance from curr pointers to tails are same for both linked lists
        int count = lenB - lenA;
        while(count-- > 0) {
            currB = currB.next;
        }
        // Keep on incrementing both currA and currB pointers by 1 until the intersection node is found or we reach end of linked list
        while(currA != null) {
            // If intersection is found, return the node
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        // Return null if no intersection found
        return null;
    }
    
    // Function to calculate length of linked list
    private static int length(ListNode head) {
        ListNode curr = head;
        int countnodes = 0;
        while (curr != null) {
            countnodes++;
            curr = curr.next;
        }
        return countnodes;
    }

    public static ListNode[] makecustomLinkedList(int[] listA, int[] listB, int skipA, int skipB) {
        ListNode[] headtailA = {null, null}, headtailB = {null, null};
        ListNode headA = null, headB = null, tailA = null, tailB = null, commonhead = null;
        for (int i = 0; i < skipA; i++)
            headtailA = insertNode(headtailA[0], listA[i]);
            headA = headtailA[0];
            tailA = headtailA[1];
        for (int i = 0; i < skipB; i++)
            headtailB = insertNode(headtailB[0], listB[i]);
            headB = headtailB[0];
            tailB = headtailB[1];
        for (int i = skipA; i < listA.length; i++)
            commonhead = insertNode(commonhead, listA[i])[0];
        tailA.next = commonhead;
        tailB.next = commonhead;
        return new ListNode[]{headA, headB};
    }

    private static ListNode[] insertNode(ListNode head, int val) {
        ListNode temp = new ListNode(val);
        if (head == null)
            head = temp;
        else {
            ListNode curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = temp;
        }
        return new ListNode[]{head, temp};
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        List<Integer> ans = new ArrayList<Integer>(); 
        while (curr != null) {
            ans.add(curr.val);
            curr = curr.next;
        }
        System.out.println(ans);
    }
 
    public static void main(String args[]) {
        int[] listA = {4,1,8,4,5}, listB = {5,6,1,8,4,5};
        int skipA = 2, skipB = 3;
        ListNode[] heads = makecustomLinkedList(listA, listB, skipA, skipB);
        ListNode headA = heads[0], headB = heads[1];
        ListNode ans = getIntersectionNode(headA, headB);
        if (ans == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersected at '" + ans.val + "'");
        }
        
    }

}
