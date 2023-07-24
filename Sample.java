//Problem 1: BST Iterator
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// class BSTIterator {
//     private List<Integer> li;
//     private int i;
//     public BSTIterator(TreeNode root) {
//         this.i=0;
//         this.li=new ArrayList<>();
//         inorder(root);
//     }

//     private void inorder(TreeNode root){
//         //base
//         if(root==null) return;
//         //logic
//         inorder(root.left);
//         li.add(root.val);
//         inorder(root.right);
//     }
    
//     public int next() {
//         return li.get(i++);
//     }
    
//     public boolean hasNext() {
//         return i!=li.size();
//     }
// }

//Actual Iterator -> better for data Accuracy
class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        //base
        if(root==null) return;
        //logic
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    public int next() { //O(h) -> mostly O(1)
        TreeNode cur= stack.pop();
        dfs(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() { //O(1)
        return !stack.isEmpty();
    }
}


//Problem 2: Reorder List
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : merge linkedlist issue, but solved after understanding 


// Your code here along with comments explaining your approach
 //step 1: Find middle O(n/2)
 //step 2: reverse other half O(n/2)
 //step 3: merge two parts O(n/2)
 //Total TC: O(n)
 //Space : O(1)
class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null || head.next.next==null) return;

        ListNode slow=head;
        ListNode fast= head;
        //step1 -> find middle of list (Low middle in case of Even node list)
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //step2
       fast = reverse(slow.next); // reverse other half of list
       //last pointer link break
        slow.next=null;
        //slow from start
        slow=head;

        //step3 -> fast at end or list, slow at head, join links accordingly
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=curr.next;

        while(temp!=null){
            curr.next=prev;
            prev=curr;
            curr=temp;
            temp=temp.next;
        }
        //for last link
        curr.next=prev;
        prev=curr;
        return prev;
    }
}

//Problem 3: Delete withour Head Pointer
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         //copy next node data to deletion node data and delete next node.
         Node front= del.next;
         del.data=front.data;
         del.next=front.next;
         front.next=null;
    }
}

//Problem 4: Intersection of 2 LinkedList
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0, lengthB=0;

        ListNode curr = headA;
        //calculate length of headA
        while(curr!=null){
            curr=curr.next;
            lengthA++;
        }
        //calculate length of headB
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            lengthB++;
        }
        //if lengthA is greater, get headA to equidistant position from intersection along with headB
        while(lengthA>lengthB){
            headA=headA.next;
            lengthA--;
        }
        //if lengthB is greater
        while(lengthB>lengthA){
            headB=headB.next;
            lengthB--;
        }
        //Now HeadA, HeadB are equidistant from intersection point, traverse until same.
        //increment both until they meet at intersection point.
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headB; //return any head because both at same position if there is intersection.
    }
}