//  Approach 1: Using Length Difference

// Time Complexity : O(m + n), where m and n are lengths of the two lists.
// Space Complexity : O(1), no extra space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// 1. Count the lengths of both lists.
// 2. Advance the pointer in the longer list by the difference in lengths.
// 3. Now both lists have the same number of nodes left. Traverse both together until they meet.
// 4. The meeting point is the intersection node, or null if no intersection.

public class IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 
        ListNode currA = headA;
        ListNode currB = headB;
        int countA = 0;
        int countB = 0;

        // count length of list A
        while (currA != null) {
            countA++;
            currA = currA.next;
        }

        // count length of list B
        while (currB != null) {
            countB++;
            currB = currB.next;
        }

        // reset pointers
        currA = headA;
        currB = headB;

        // advance the longer list
        while (countA > countB) {
            currA = currA.next;
            countA--;
        }
        while (countB > countA) {
            currB = currB.next;
            countB--;
        }

        // traverse both until they meet
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA; // may be null (no intersection) or intersection node
    }
}


// Approach 2: Two Pointer Switching Trick

// Time Complexity : O(m + n), since each pointer traverses both lists at most once.
// Space Complexity : O(1), no extra space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially tricky to understand pointer switching logic.
//
// Approach : 
// 1. Use two pointers starting at headA and headB.
// 2. Traverse both lists. When one pointer reaches the end, redirect it to the other list’s head.
// 3. If the lists intersect, pointers will eventually meet at the intersection node.
// 4. If they do not intersect, both pointers will reach null at the same time.

class IntersectionTwoLinkedList2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            // move to next or switch to the other list’s head
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }

        return currA; // either intersection node or null
    }  
}


// Node Definition 

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
