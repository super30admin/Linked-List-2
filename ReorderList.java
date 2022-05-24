public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
            if(fast==null){
                break;
            }
            fast = fast.next;
        }
        
        Stack<ListNode> st = new Stack<>();
        while(slow !=null){
            st.push(slow);
            slow = slow.next;
        }
        slow = head;
        while(!st.isEmpty()){
            ListNode temp = slow.next;
            slow.next = st.pop();
            slow = slow.next;
            slow.next = temp;
            slow = slow.next;
        }
        slow.next = null;
    }
}
