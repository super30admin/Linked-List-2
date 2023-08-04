// Time Complexity : O(m+n) where m is the length of linked list 1 and n is the length of linked list 2
// Space Complexity : O(m) where m is the length of linked list 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode copyA = headA;

        ListNode copyB = headB;

        HashSet<ListNode> set = new HashSet<>();

        // Iterating through first Linked List
        while(copyA != null)
        {
            set.add(copyA);
            copyA = copyA.next;
        }

        // Iterating through second Linked List
        while(copyB != null)
        {
            if(set.contains(copyB))
            {
                System.out.println(copyB);
                return copyB;
            }
            copyB = copyB.next;
        }

        System.out.println(copyB);

        return copyB;

    }
}