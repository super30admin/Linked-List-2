//Problem 1
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class BSTIterator {

    Stack<TreeNode> st; //stack for storing the values
    
    public BSTIterator(TreeNode root) {
        
        st = new Stack<>();
        
        dfs(root); // initially root.left 
    }
    
    public int next() {
        TreeNode node = st.pop(); //return the top element of the stack 
        dfs(node.right); //go right
        return node.val; //return 

    }
    
    public boolean hasNext() {
        return !st.isEmpty(); 
    }
    
    private void dfs(TreeNode root){
        
        while(root != null){
            st.push(root); //continue adding the elements into the stack until root is not equal to null 
            root = root.left;
        }
    }
    
}

//Problem 2
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return; 
        
        //find the middle
        ListNode slow = head;
        ListNode fast = head; 
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        
        //find the reverse of the second half and set the first half last element next to null
        fast = reverse(slow.next); 
        slow.next = null; 
        
        
        //merge the two LL
        slow = head;
        
        while(fast != null){
            ListNode temp = slow.next; 
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp; 
            slow = temp;
        }
    }
    
    //reverse of the linked list using 3 pointers
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next; 
        
        while(fast != null){      
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;    
        }
        
        curr.next = prev; 
        return curr; 
    }
}

//Problem 3
prev.next = prev.next.next


//Problem 4
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curr = headA; 
        
        int lenA = 0;
        int lenB = 0;
        
        //Calculate the length of list A
        while(curr != null){
            lenA++;
            curr = curr.next; 
        }
        
        curr = headB;
        
        //Calculate the length of List B
        while(curr != null){
            lenB++;
            curr = curr.next; 
        }
        
        //if length of list A is greater than B, bring the head pointer to equi-distance. 
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        //if length of list B is greater than A, bring the head pointer to equi-distance.
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        //increase the pointers until we find the intersection 
        while(headA != headB){
            headA = headA.next;
            headB = headB.next; 
        }
        
        return headA; 
    }
}