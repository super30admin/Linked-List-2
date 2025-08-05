// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* 
    First, find the middle of the linked list using the slow and fast pointer technique.
    Reverse the second half of the linked list.
    Merge the first half and the reversed second half node by node to achieve the desired reordering.
    This reorders the list in-place without using additional memory for storing nodes.
 
 */



class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}



public class ReorderList {
    public void solve(ListNode head){
        if(head==null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        fast = reversedList(slow.next);
        slow.next=null;
        slow=head;


        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reversedList(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode fast = head.next;

        while(fast!=null){
            cur.next = prev;
            prev = cur;
            cur = fast;
            fast = fast.next;
        }
        cur.next=prev;
        return cur;


    }

    public static void printList(ListNode head){
        while(head!=null){
            System.out.println(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[]args){
        ListNode head = new ListNode(1,
                            new ListNode(2,
                            new ListNode(3,
                            new ListNode(4))));

        
        ReorderList ob = new ReorderList();
        ob.solve(head);
        printList(head);

    }
    
}
 