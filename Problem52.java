//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem52 {
    public void reorderList(ListNode head) {
        if(head==null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        //need to find the middle of the list
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode dummy1 = head;
        ListNode dummy2;
        //reverse the second half of the list
        dummy2 = reverseList(slow.next);
        slow.next = null;

        //merge two list
        ListNode temp1;
        ListNode temp2;
        while(dummy2!=null){
            temp1 = dummy1.next;
            dummy1.next = dummy2;
            temp2 = dummy2.next;
            dummy2.next = temp1;
            dummy1 = temp1;
            dummy2 = temp2;
        }

    }

    private ListNode reverseList(ListNode curr){
        ListNode prev = null;
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
