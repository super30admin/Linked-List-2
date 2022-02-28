// space complexity - o(1)
      //time - o(n) where n is length of linked list
      //Ran on Leetcode successfully : Yes
      // Problem faced  : No
// Iterative approach : getLengthOfList, breakAndGetSecondHalfHead, reverseSecondHalf , mergeTwoList
class Solution {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        int len = getLengthOfList(head);
        ListNode secondHead = breakAndGetSecondHalfHead(head, len);
        secondHead = reverseSecondHalf(secondHead);
        mergeTwoList(head, secondHead);
    }

    public void mergeTwoList(ListNode headA, ListNode headB){

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        while(headA != null || headB != null){

            if(headA != null){
                dummy.next = headA;
                headA = headA.next;
                dummy = dummy.next;
                dummy.next = null;
            }
            if(headB != null){
                dummy.next = headB;
                headB = headB.next;
                dummy = dummy.next;
                dummy.next = null;
            }
        }
    }

   public int getLengthOfList(ListNode head){
        int res = 0 ;
        while(head != null){
            head = head.next;
            res++;
        }
        return res;
    }

    public ListNode breakAndGetSecondHalfHead(ListNode head, int len){
        int res = len/2 ;
        while(res > 1){
            head = head.next;
            res--;
        }
        ListNode headB = head.next;
        head.next = null;
        return headB;
    }

    public ListNode reverseSecondHalf(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
