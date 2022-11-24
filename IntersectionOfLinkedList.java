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
 //Time complexity is O(N)
 //Space complexity is O(N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> li = new ArrayList();
        while(headA!=null){
            li.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(li.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}