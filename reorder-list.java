// Solution -1

// TimeComplexity: O(n)
// SpaceComplexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        // 1. Find the middle
        // 2. Reverse the second half
        // 3. Merge both of them
        ListNode slow = head;
        ListNode fast = head;

    while(fast.next!=null && fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode curr = slow.next;
    ListNode prev = null;
    while(curr !=null) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    slow.next = null;
    fast = prev;
    slow = head;

    while(fast!=null){
        ListNode temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }
    }
}



// Solution -2

// TimeComplexity: O(n^2)
// SpaceComplexity: O(1)

class Solution {
    public void reorderList(ListNode head) {
        int n=0;
        ListNode nxt = head;
        while(nxt!=null) {
            n++;
            nxt = nxt.next;
        }
        nxt = head;

        while(nxt.next!=null && nxt.next.next !=null) {
            ListNode curr = nxt;
            ListNode fast = nxt;
            nxt = nxt.next;
            n = n-2;
            int i =0;
            while(i<n) {
                fast = fast.next;
                i++;
            }
            curr.next = fast.next;
            fast.next = null;
            curr.next.next = nxt;
        }   
    }
}