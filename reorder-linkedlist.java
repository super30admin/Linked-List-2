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
        ListNode dummy = temp;
        int count = 0;
        Stack<ListNode> st = new Stack<ListNode>();
        while(dummy != null){
            st.push(dummy);
            dummy = dummy.next;
            count +=1;
        }
        count = count/2;
        while(count > 0){
            ListNode node = st.pop();
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
            count--;
        }
        temp.next = null;
   }
}