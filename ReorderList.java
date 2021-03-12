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
class ReorderList {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode dummy = head;
        
        while(dummy != null){
            list.add(dummy);
            dummy = dummy.next;
        }
        
        int i = 1, left = 1, right = list.size() - 1;
        dummy = head;
        
        while(i < list.size()){
            if(i % 2 == 0)
                dummy.next = list.get(left++);
            else 
                dummy.next = list.get(right--);
            dummy = dummy.next;
            i++;        
        }
        dummy.next = null;
    }
}