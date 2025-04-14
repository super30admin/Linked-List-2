// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null) {
            return null;
        }
        if (headB == null) {
            return null;
        }
        int countA=0;
        int countB=0;
        int i=0;

        ListNode ptrA = headA;
        ListNode ptrB = headA;
        while (ptrA != null){
            countA++;
            ptrA= ptrA.next;
        }
        ptrB = headB;
        while(ptrB != null) {
            countB++;
            ptrB= ptrB.next;
        }

        if (countA<countB) {
            int diff= countB-countA;
            ptrB = headB;
            while(i<diff) {
                ptrB = ptrB.next;
                i++;
            }
            ptrA = headA;
        }

        if (countB<countA) {
            int diff= countA-countB;
            ptrA = headA;
            while(i<diff) {
                ptrA= ptrA.next;
                i++;
            }
            ptrB = headB;
        }
        if (countB == countA) {
            ptrB = headB;
            ptrA = headA;
        }

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                break;
            }
            ptrA=ptrA.next;
            ptrB=ptrB.next;
        }

        return ptrA;
    }
}



For Input: 
10 20 4 30
10
Your Output: 
20 4 30
Expected Output: 
20 4 30



10 20 4 30
20
Your Output: 
10 4 30
Expected Output: 
10 4 30

10 20 4 30
4
Your Output: 
10 20 30
Expected Output: 
10 20 30



    
/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        // Your code here
        if (node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }
}



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
        

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp=null;
        ListNode prev=null;
        ListNode curr=null;

        while (fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        fast=slow.next;
        slow.next = null;
        slow=head;
        curr=fast;
        while(curr != null) {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        fast = prev;
        while (fast != null) {
            
            temp = slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }

    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> s= new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    public int next() {
        TreeNode popped = s.pop();
        if (popped == null ){
            System.out.println("what");
        }
        if (popped.right != null) {
            dfs(popped.right);
        }

        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            s.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
