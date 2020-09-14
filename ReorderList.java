// Time Complexity : O(n) since finding middle takes (n/2)+ reversing takes O(n/2) + merging takes O(n/2)
// Space Complexity : O(1) since we are using constant space but other soln will require O(n/2)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//  the first approach uses the stack (LIFO ) which will store second half in reverse manner 
// then we make head of left half point to st.pop..move head  to head.next(using itr).. then make st.pop point to head.next(itr)and move itr++and curr head++  
// if anything is still left in the stack.. empty the stack
class Solution {
    public void reorderList(ListNode head) {

        // if(head==null||head.next==null) return;

        // //Find the middle of the list
        // ListNode p1=head;
        // ListNode p2=head;
        // while(p2.next!=null&&p2.next.next!=null){
        // p1=p1.next;
        // p2=p2.next.next;
        // }

        // ListNode midNext= p1.next;
        // p1.next=null;

        // Stack<ListNode> st = new Stack<ListNode>();
        // while(midNext != null){
        // st.push(midNext);
        // midNext=midNext.next;
        // }

        // ListNode p3=head;
        // ListNode itr = head.next;

        // while(itr!=null){
        // p3.next =st.pop();
        // p3=p3.next;
        // p3.next = itr;
        // itr=itr.next;
        // p3=p3.next;
        // }

        // if (!st.empty()){
        // p3.next=st.pop();
        // p3=p3.next;
        // p3.next=null;
        // }

        // Alternate solution
        // Here using flyods algo we find the mid . create a reverse function to reverse
        // the list from mid to end and delink the end of first half from the second
        // half

        // starting from head of both the normal list and the reversed list, now
        // alternatively select head1 and link to head2.. move head1 to its next
        // ptr(which is stored already)
        // select head2 and make it link to the new head1.. move head2 to its nxt
        // ptr(which is stored already)

        if (head == null) {
            return;
        }

        // Find the middle node
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode head2 = reverse(slow.next);
        // delink the first half
        slow.next = null;

        // Link the two halves together
        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tmp2;
        }

    }

    private ListNode reverse(ListNode n) {
        ListNode prev = null;
        ListNode cur = n;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}