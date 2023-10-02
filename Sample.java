         // Binary Search Tree Iterator

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class BSTIterator {

    List<Integer> l;
    int len;
    int curr;

    public BSTIterator(TreeNode root) {
        BST1 B = new BST1();
        B.inOrder(root);
        this.l = B.l;
        len = this.l.size();
        this.curr = 0;

    }

    public int next() {
        int data = -1;
        if (curr < len) {
            data = l.get(curr);
            curr++;
        }

        return data;

    }

    public boolean hasNext() {
        return curr < len;

    }
}

class BST1 {

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }
}

         // Reorder List

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        int count = 0;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode low = null;
        ListNode mid = slow.next;
        ListNode high = mid.next;
        slow.next = null;

        while(high != null){
            mid.next = low;
            low = mid;
            mid = high;
            high = high.next;
        }

        mid.next = low;

        ListNode temp1 = head;
        ListNode temp2 = mid;

        while(temp2 != null){
            ListNode temp = temp1.next; 
            temp1.next = temp2;
            temp2 = temp2.next;
            temp1.next.next = temp;
            temp1 = temp;
        } 

    }
}

         // Delete Without Head Pointer

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
         del.data = temp.data;
         del.next = temp.next;
         
    }
}

         // Intersection of two Linked Lists

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode temp = headA;
        while(temp != null){
            lenA++;
            temp = temp.next;
        }

        temp = headB;
        while(temp != null){
            lenB++;
            temp = temp.next;
        }

        while(headA != null){
            if(lenA > lenB){
                headA = headA.next;
                lenA--;
            } else if(lenB > lenA){
                headB = headB.next;
                lenB--;
            } else {
                if(headA == headB)
                    return headA;
                else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }

        return headA;
    }
}
