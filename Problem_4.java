// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
        HashMap<ListNode,ListNode> hash=new HashMap<ListNode,ListNode>();
        ListNode temp=headA;
        while(temp!=null){
            hash.put(temp,temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(hash.containsKey(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}