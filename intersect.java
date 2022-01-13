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

Time O(n)
Space O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> h1=new HashMap<>();
        ListNode temp=headA;
        while(temp!=null){
            h1.put(temp,temp.val);
            temp=temp.next;
        }

        while(headB!=null){
            if(h1.containsKey(headB)){
                return headB;
            }

            headB=headB.next;
        }
        return null;
    }
}