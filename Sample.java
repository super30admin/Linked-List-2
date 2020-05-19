// Prob-1: binary-search-tree-iterator

// Time Complexity : Average O(1)
// Space Complexity : O(h) where h is the height of the stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/** Iteration with controlled recursion*/
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack();
        helper(root);
    }
    
    private void helper(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode root = s.pop();
        int ret = root.val;
        helper(root.right);
        return ret;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!s.isEmpty()){
            return true;
        }
        
        return false;
    }
}
// Iterative solution. TC = O(n) where n is the number of nodes in tree SC = O(h)

class BSTIterator {
    List<Integer> ls;
    int index =0;
    public BSTIterator(TreeNode root) {
        
        Stack<TreeNode> s = new Stack();
         ls = new ArrayList<>();
        while(root != null || !s.isEmpty()){
            
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            ls.add(root.val);
            root = root.right;  
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        int num = -1;
        if(!ls.isEmpty() || index < ls.size()){
            num = ls.get(index++);
        }
        return num;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index < ls.size()) return true;
        return false;
    }
}

// Prob-2: reorder-list

// Time Complexity : O(n+n/2+n) = n where n is the num of nodes in LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

/**
This is a two step algorith where we first find the mid of the LL, and reverse the mid +1 to n. Secondly, merge the flipped array with 0 to mid to get the desired order
*/
class Solution {
    public void reorderList(ListNode head) {
        
        //edge
        if(head == null || head.next == null) return;
        
        // slow and fast pointer to find the mid of the LL
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next; // 1x speed
            fast = fast.next.next; // 2x speed;
        }
        
        fast = reverse(slow.next);
        slow.next = null; // putting the end to the first half of the LL
        slow = head; // and resetting the slow to start from the begenning
        
        //merging of the reversed and the original left half of the LL
        ListNode cur;
        while(fast != null){
            cur = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = cur;
            slow = cur;
        }
        
    }
    
    private ListNode reverse(ListNode root){
        ListNode prev=null, cur=root, fast=root.next;
        
        while(fast != null){
            cur.next = prev; 
            prev = cur;
            cur = fast;
            fast = fast.next;
        }
        
        //fliping the last two positions
        cur.next = prev;
            
    return cur; // head of the flipped LL
    }
}


// Prob-4: Intersection-of-two-linked-list

// Time Complexity :O(m+n) where m is the len of headA and n is the len of headB
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        
        if( headA.next==null && headB.next==null){
            if(headA==headB){
                return headA;
            }else{
                return null;
            }
        }
        
        ListNode tempA= headA;
        ListNode tempB= headB;
        int lenA=0;
        int lenB=0;
        
        while(tempA!=null){
            lenA+=1;
            tempA= tempA.next;
        }
        
        while(tempB!=null){
            lenB+=1;
            tempB= tempB.next;
        }
        
        int start= Math.max(lenA, lenB)- Math.min(lenA, lenB);
        
        
            while(start!=0){
                if(lenA > lenB){
                    headA= headA.next;
                    start--;
            }else{
                    headB= headB.next;
                    start--;
            }
        }
        
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            if(headA.next==headB.next){
                return headA.next;
            }
            headA= headA.next;
            headB= headB.next;
        }
        
        return null;
        
    }
}
