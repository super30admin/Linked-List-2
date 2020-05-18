class Sample {

    // Time Complexity : O(H) while creating the BSTIterator object, O(1) for hasNext method, O(1) for next method
    // Space Complexity : O(H) H is height of the tree
    // Did this code successfully run on GFG : Yes
    // Any problem you faced while coding this : No


    // Problem 1
    /**
     * 1. Maintain a stack with minimum node at the top.
     * 2. Since, it is BST, minimum node is left most child of the tree.
     * 3. Once the left child is popped out, check if there is any right node for it and add in into stack. This
     * right node is next smaller element after the previous left child.
     */

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

        Stack<TreeNode> stack;
        
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            dfs(root);
        }
        
        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            dfs(node.right);
            return node.val;
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        private void dfs(TreeNode node) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

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


    // Time Complexity : O(N) N is size of the list
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Problem 2
    /**
     * 1. Find the middle of the list.
     * 2. Reverse the second half of the list.
     * 3. And merge the first and second part alternately. 
     */

    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode next1 = head, next2 = fast;
        
        
        ListNode p1 = head, p2 = fast;

        while(p1 != null && p2 != null) {
            next1 = p1.next;
            next2 = p2.next;
            p2.next = next1;
            p1.next = p2;
            p1 = next1;
            p2 = next2;
        }

    }
    
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev= current;
            current = next;
        }
        
        return prev;
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Did this code successfully run on GFG : Yes
    // Any problem you faced while coding this : No


    // Problem 3
    /**
     * 1. Since the node is not last element in the list, we can copy the next node's data into this node.
     * 2. Then point its next as next node's next.
     */
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
         return;
    }

    // Time Complexity : O(Max(M, N))
    // Space Complexity : O(1)
    // Did this code successfully run on GFG : Yes
    // Any problem you faced while coding this : No


    // Problem 3
    /**
     * 1. Find the lengths of 2 lists.
     * 2. Move starting pointers of both lists same such as both lists can be traversed together to find 
     * the intersection.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0, lenB = 0;
        
        ListNode temp = headA;
        while(temp != null) {
            temp = temp.next;
            lenA++;
        }
        
        temp = headB;
        while(temp != null) {
            temp = temp.next;
            lenB++;
        }
        
        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
        
    }
}