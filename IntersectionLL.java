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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      HashSet<ListNode> set = new HashSet<>();
      ListNode curr=headA;
        int i=0;
        while(curr!= null){
            set.add(curr);
            curr=curr.next;
        }
        curr=headB;
        while(curr!= null){
            if(set.contains(curr)) return curr;
            curr=curr.next;
        }
        return null;
    }
}

//Time Complexity -O(n)
//Space complexity- O(n)