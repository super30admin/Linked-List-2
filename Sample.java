// Time Complexity : O(1)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        dfs(root);
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode current = stack.pop();
        if(current.right != null) {
            dfs(current.right);
        }
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
    
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverseList(slow.next);
        
        slow.next = null;
        slow = head;
        
        while(slow != null && fast != null) {
            ListNode curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
     private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) { 
            return head;
        }
		ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;		
         
		while(fast != null) {										
            
			current.next = prev;										
			prev = current;
			current = fast;
			fast = fast.next;
		}
		current.next = prev;
		return current;											
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution
{
    void deleteNode(Node del)
    {
        while(del.next.next != null) {
            del.data = del.next.data;
            del = del.next;
        }
        del.data = del.next.data;
        del.next = null;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return headA;
        }
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int m = 0, n = 0;
        
        m = getListSize(headA);
        n = getListSize(headB);
        
        if(m > n) {
            headA = moveHead(headA, m-n);
        } else {
            headB = moveHead(headB, n-m);
        }
        
        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getListSize(ListNode head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
    private ListNode moveHead(ListNode head, int count) {
        while(count != 0) {
            head = head.next;
            count--;
        }
        return head;
    }
}