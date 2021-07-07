// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Delete a node without head reference
//Time o(1)
//space o(1)
private void deleteNode(ListNode node) {
        if(node == null)
            return;

        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
            return;
        }
}

//Intersection of two linkedlists

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode trav = headA;
        int lenA = 0, lenB = 0;
        //length of the first linkedlist
        while(trav != null){
            trav = trav.next;
            lenA++;
        }
        //length of the second linkedlist
        trav = headB;
        while(trav != null){
            trav = trav.next;
            lenB++;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

//reorder a list
//time o(n)
//space o(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        //middle node of the list
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    private ListNode reverse(ListNode ptr){
        ListNode prev = null;
        ListNode cur = ptr;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

//BST Iterator

class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
            TreeNode temp = st.pop();
            dfs(temp.right);
            return temp.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}


