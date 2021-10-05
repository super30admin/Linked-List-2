
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        System.out.println(arr);
        n = arr.size();
        while(cur != 0){
            
        }         
        
    }
}