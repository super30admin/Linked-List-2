// Time Complexity : O(2N) = O(N)
// Space Complexity : O(N) because of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            st.add(curr);
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            ListNode endNode = st.pop();

            curr.next = endNode;
            endNode.next = temp;
            curr = temp;

            if(curr != null && curr.next == endNode) {
                curr.next = null;
                break;
            }
        }
    }
}
