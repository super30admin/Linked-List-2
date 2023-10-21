//Time Complexity: O(n)

//Space Complexity: O(1)
public
  class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_a = 0; int len_b=0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            len_a++;
        }
        curr = headB;
        while(curr!=null){
            curr = curr.next;
            len_b++;

        }
        while(len_a>len_b){
            headA = headA.next;
            len_a--;
        }
        while(len_a<len_b){
            headB = headB.next;
            len_b--;
        }
        while(headA !=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
