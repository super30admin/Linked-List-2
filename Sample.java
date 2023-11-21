// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1.Intersection between 2 list
//Using no space
//Time Complexity -> O(n+m) or O(max(n,m))
//Space Complexity -> O(1)
public class Solution {
    //Without Extra Space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if(headA == null || headB == null) return null;
           int lenA = 0;
           ListNode curr = headA;
           while(curr!= null){
               lenA++;
               curr = curr.next;
           }
           int lenB = 0;
           curr = headB;
           while(curr!=null){
               lenB++;
               curr = curr.next;
           }

           while(lenA>lenB){
              headA = headA.next;
              lenA--;
           }
           while(lenB > lenA){
               headB = headB.next;
               lenB --;
           }
           //here headA list and headB list are at same level
           while(headA!=headB){
               headA = headA.next;
               headB = headB.next;
           }

           return headA;
         
    }
}
//Using extra Space
//Time Complexity -> O(n+m) -> O(max(n,m))
//Space Complexity -> O(n + m) -> O(max(n,m))
public class Solution {
    //With Extra Space Using hashSet
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if(headA == null || headB == null) return null;
           Set<ListNode> set = new HashSet();
           ListNode curr = headA;
           while(curr!=null){
               set.add(curr);
               curr = curr.next;
           }

           curr = headB;
           while(curr!=null){
               if(set.contains(curr)){
                   return curr;
               }
               curr = curr.next;
           }

           return null;
         
    }
}

//2.Reorder List
//Time Complexity -> O(n)
//because getMid ->o(n/2)
//reverse linked List -> O(n/2)
//merge -> O(n/2)
//Total = n/2 + n/2 + n/2 = 3n/2 -> O(n)
//Space Complexity -> O(1)
class Solution {
    public void reorderList(ListNode head) {
        //if the list has no element,or 1 element,or 2 elements then we don't need to reorder list just return 
        if(head == null || head.next == null || head.next.next ==null) return;
        ListNode mid = getMid(head);
        ListNode list2 = reverseList(mid.next);
        mid.next = null;
        ListNode curr1 = head;
        ListNode curr2 = list2;     
        while(curr2!=null){
            ListNode temp = curr1.next;
            curr1.next = curr2;
            curr2 = curr2.next;
            curr1.next.next = temp;
            curr1 = temp;
            
            
        }
        
    }
    
    //if length is odd then we can send usual getMid
    //if length is even ex: 1->2->3->4->5->6 then in usual mid will be 4 but will make the mid as 3
    private ListNode getMid(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }
}

//3.BST iterator
//Time Complexity -> hasNext -> O(1),next -> O(1)
//Space Complexity -> space of stack which is O(h)
//This is lazy loading method
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack();
        dfs(root);
        
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode root = st.pop();
        dfs(root.right);
        return root.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

//this is eager loading
class BSTIterator {
    //Using eager loading or storing all the elements of the tree at the starting
    List<Integer> result;
    int index;
    public BSTIterator(TreeNode root) {
        index = 0;
        result = new ArrayList();
        inorder(root);
        
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        int val = result.get(index);
        this.index++;
        return val;
        
    }
    
    public boolean hasNext() {
        return index!=result.size();
    }
}