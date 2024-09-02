/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Bruteforce: Iterate over one linked list and check whether it is present in another linked list
// TC - O(m*n) m = length of LL1, n =length of LL2
// SC - O (1)
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = new ListNode();
        ListNode pointerB = new ListNode();
        pointerA = headA;
        pointerB = headB;
        while(pointerA != null) {
            while(pointerB != null) {
                if(pointerA == pointerB)
                    return pointerA;
                else
                	pointerB = pointerB.next;
            }
            pointerA = pointerA.next;
            pointerB = headB;
        }
        return null;
    }
}


// Put all values of one linked list into a set. Now iterate over other list and check whether that is present in set or not
// TC - O(m+n)
// SC - O(max(m,n)
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode pointerA = new ListNode();
        ListNode pointerB = new ListNode();
        pointerA = headA;
        pointerB = headB;
        while(pointerA!= null) {
            set.add(pointerA);
            pointerA = pointerA.next;
        }

        while(pointerB!= null) {
            if(set.contains(pointerB)) {
                return pointerB;
            } else {
                pointerB = pointerB.next;
            }
        }
        return null;
    }
}

// Check the lengths of 2 lists and increment the pointer lo higher linked list by |lengthA - lengthB| and start from there to check intersection
// TC - O(m+n) m = length of LL1, n =length of LL2
// SC - O(1)
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = new ListNode();
        ListNode pointerB = new ListNode();
        pointerA = headA;
        pointerB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(pointerA!= null) {
            pointerA = pointerA.next;
            lengthA++;
        }

        while(pointerB!= null) {
            pointerB = pointerB.next;
            lengthB++;
        }

        pointerA = headA;
        pointerB = headB;

        while(lengthA > lengthB) {
            pointerA = pointerA.next;
            lengthA --;
        }
        while(lengthB > lengthA) {
            pointerB = pointerB.next;
            lengthB --;
        }
        while(pointerA!= null && pointerB!= null) {
            if(pointerA == pointerB) {
                return pointerB;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return null;
    }
}

// Instead of finding lengths, we iterate over the lists and whenever one reaches null, we move the pointer to head of other list.
// If two lists intersect, the two pointers will meet at intersection in at most 2 iterations of each list. 
// TC - O(m+n)
// SC - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = new ListNode();
        ListNode pointerB = new ListNode();
        pointerA = headA;
        pointerB = headB;
        while(pointerA!= null || pointerB!= null) {
            if(pointerA == pointerB) {
                return pointerA;
            }
            pointerA = (pointerA!=null) ? pointerA.next:headB;
            pointerB = (pointerB!=null) ? pointerB.next:headA;
        }
        return null;
    }
}