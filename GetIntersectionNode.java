public class GetIntersectionNode {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //initializing length of list A and List B --> 2 pointer approach
        int lenA=0;
        int lenB=0;
        ListNode curr=headA;
        while(curr!=null){
            curr=curr.next;
            lenA++; //Length of A
        }
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            lenB++; //Length of B
        }
        //if length of A is greater than length of B then change headA to match length of B
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }

        //if length of B is greater than length of A then change headB to match length of A
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        //while headA is not equal to headB keep going to next, until they're equal (that is your intersection)
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }
}

//TC: O(m+n)
//SC: O(m+n)