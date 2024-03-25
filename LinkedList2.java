
//#52 Time complexity O(1) and space complexity O(1)
class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {

        stack = new Stack<>();
        helper(root);
    }


    //inorder traversal
    public void helper(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode val = stack.pop();
        helper(val.right);
        return val.val;
        
    }
    
    public boolean hasNext() {  
        return !stack.isEmpty();
        
    }
}

//#53 Time Complexity O(N) and space complexity O(1)
class Solution {
    public void reorderList(ListNode head) {

        //find the mid element
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow = slow.next;
        }
        
        // System.out.println(slow.val);
        //reverse from mid node to the end node
        fast = reverse(slow.next);

        
        
        
        slow.next=null;
        

        slow = head;
        // System.out.println(slow.val);
        // System.out.println(fast.val);
        ListNode temp = null;
        while(fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

//#55 Time complexity O(N) and space complexity O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA =0;
        int lenB =0;
        ListNode copyA=headA;
        ListNode copyB= headB;
        while(copyA!=null){
            copyA= copyA.next;
            lenA++;
        }
        

        while(copyB!=null){
            copyB = copyB.next;
            lenB++;
        }

        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }

        while(lenB>lenA){
            headB= headB.next;
            lenB--;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
