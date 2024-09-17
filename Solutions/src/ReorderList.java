// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        int c = 1;
        while(head!=null){
            map.put(c,head);
            head = head.next;
            c+=1;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int i=1, j = map.size();i<=j;i++,j--){
            current.next = map.get(i);
            if(i!=j){
                map.get(i).next = map.get(j);
            }
            map.get(j).next = null;
            current = map.get(j);
        }
    }
}
