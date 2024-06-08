// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
find mid using slow and fast pointers
reverse the second half, from mid.next
merge the LL using one from slow side and one from reversed mid side
*/

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
        ListNode temp = head;
        Deque<ListNode> queue = new ArrayDeque<>();
        while(temp!=null){
            queue.add(temp);
            temp = temp.next;
        }
        Boolean move = true;
        while(!queue.isEmpty()){
            if(move){
                head.next=queue.removeFirst();
            }else{
                head.next = queue.removeLast();
            }
            head = head.next;
            move = !move;
        }
        head.next = null;
    }
}
