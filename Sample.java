class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty()) return true;
        return false;
    }
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // fast = reverseList(slow.next);
        // System.out.print(""+fast.val);
        // slow.next = null;
        // slow = head;
        // ListNode temp = slow;
        
        ListNode prev = null;
        ListNode curr = slow.next;
        fast = slow.next.next;
        while(fast!=null){
            curr.next = prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next = prev;
        slow.next = null;
        fast = curr;
        slow = head;
        ListNode temp = head;
        
        while(fast != null){
            temp = temp.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow =temp;           
        }        
    }
    
    // private ListNode reverseList(ListNode head){
    //     if(head == null || head.next == null) return head;
    //     ListNode node = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     System.out.print(""+ node.val);
    //     return node;
    // }
}



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode A = headA;
        ListNode B = headB;
        while(A != null){
            A = A.next;
            lenA++;
        }
        while(B != null){
            B = B.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!= headB){
            headA = headA.next;
            headB = headB.next;
            
        }
        
        return headA;
        
    }
}


