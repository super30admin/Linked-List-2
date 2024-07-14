// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach

int count(struct ListNode *headA){
    int count=0;
    while(headA!=NULL){
        headA=headA->next;
        count++;
    }
    return count;
}
struct ListNode *diff1(struct ListNode *A, struct ListNode *B, int diff){
    int i;
    for(i=0;i<diff;i++){
        A=A->next;
    }
    
        while(A!=B){
            A=A->next;
            B=B->next;
        }
            return A;
}
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
        int k=count(headA);
        int k2=count(headB);
        int diff=abs(k-k2);
        struct ListNode *ans;
        if(k>k2)
            ans=diff1(headA,headB,diff);
        else
            ans=diff1(headB,headA,diff);
        return ans;
}

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
class Solution
{
    void deleteNode(Node del_node)
    {
         // Your code here
         Node temp = del_node.next;
         
         del_node.data = temp.data;
         
         del_node.next = temp.next;
         
         temp = null;
         
    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class Solution {
    public ListNode reverse(ListNode start) {
        if (start == null || start.next == null) return start;

        ListNode prev = null, curr =start, next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode n = reverse(slow.next);
        slow.next = null;

        ListNode m =head;

        while (m!=null && n!=null){
            ListNode tempM = m.next;
            ListNode tempN = n.next;

            m.next = n;
            n.next = tempM;
            m = tempM;
            n = tempN;
        }        
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode poppedElement = st.pop();
        dfs(poppedElement.right);
        return poppedElement.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}



