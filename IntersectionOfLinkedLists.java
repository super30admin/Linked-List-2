// Time Complexity :O(m+n) where m and n are the lengths of the 2 Lists
// Space Complexity :O(1) as no auxiliary data structure used.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

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
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1 = 0, l2=0;
        ListNode current = headA;
        while(current != null){
            l1++;
            current = current.next;
        }

        current = headB;
        while(current != null){
            l2++;
            current = current.next;
        }

        while(l1 >l2){
            headA = headA.next;
            l1--;
        }
        while(l2 >l1){
            headB = headB.next;
            l2--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    //using HashSet
    /*private HashSet<ListNode> set;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        this.set = new HashSet<ListNode>();
        ListNode current = headA;

        while(current != null){
            set.add(current);
            current = current.next;
        }

        //now check with the second list
        current = headB;
        while(current != null){
            if(set.contains(current)){
               break;
            }
            current = current.next;
        }
        return current;
    }*/
}
