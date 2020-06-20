/*

    Time complexity : O(N)
    Space Complexity : O(N)
    is worked on leetcode :  YES
*/

public class ReOrderList {

    public void reorderList(ListNode head) {
        
        Stack<ListNode> st =  new Stack<ListNode>();
        
        ListNode temp = head;
        
        while(temp != null){
            st.add(temp);
            temp = temp.next;
        }
        ListNode _next;
        ListNode node;
       
        int cnt=(st.size()-1)/2;
        
        while(cnt-- > 0){
            _next = head.next;     
            node = st.pop();
            head.next = node;
            node.next = _next;
            head = _next;
       }
        if(!st.isEmpty()){st.pop().next=null;}
        
    }
    
}