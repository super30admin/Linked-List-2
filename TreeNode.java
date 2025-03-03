// problem 1
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
       TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
            this.left = left;
            this.right = right;
       }
     }
class BSTIterator {

    Stack <TreeNode> st;

    public BSTIterator(TreeNode root) {

        st = new Stack<>();

        TreeNode node = root;

        dfs(node);

    }

    

    /** @return the next smallest number */

    public int next() {

        TreeNode node = st.pop();

        dfs(node.right);

        return node.val;

    }

    

    /** @return whether we have a next smallest number */

    public boolean hasNext() {

        return !st.isEmpty();

    }

    private void dfs(TreeNode node){

        while(node != null){

            st.push(node);

            node = node.left;

        }

    }
}

//problem 2
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {

    public void reorderList(ListNode head) {
   
    /// find mid 
   
    ListNode slow = head;
   
    ListNode fast = head;
   
    while(fast.next != null &&  fast.next.next != null){
   
               slow = slow.next;
   
               fast = fast.next.next;
   
           }
   
    // slow will at my proverbial mid
   
           fast = reverse(slow.next);
   
    slow.next = null;
   
           slow = head;
   
    // merge the lists
   
    while(fast != null){
   
    ListNode temp = slow.next;
   
    slow.next = fast;
   
               fast = fast.next;
   
    slow.next.next = temp;
   
               slow = temp;
   
           }
   
       }
   
    private ListNode reverse(ListNode head){
   
    ListNode prev= null;
   
    ListNode curr = head;
   
    while(curr != null){
   
    ListNode temp = curr.next;
   
    curr.next = prev;
   
               prev = curr;
   
               curr = temp;
   
           }
   
    return prev;
   
       }
   
   }

   //problem 4
// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 
        ListNode curA=headA;
 
        ListNode curB=headB;
 
        while(curA!=null && curB!=null){
 
            curA=curA.next;
 
            curB=curB.next;
 
        }
 
        while(curB!=null){
 
            curB=curB.next;
 
            headB=headB.next;
 
        }
 
        while(curA!=null){
 
            curA=curA.next;
 
            headA=headA.next;
 
        }
 
        while(headA!=headB){
 
            headA=headA.next;
 
            headB=headB.next;
 
        }
 
        return headA;
 
    }
 
 }