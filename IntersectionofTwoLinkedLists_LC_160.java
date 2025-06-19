/* Approach : two pointers
Space complexity - O(1)
Time complexity - O(m+n)
*/
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 public class IntersectionofTwoLinkedLists_LC_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1= 0;
        int l2= 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a!= null){
            a= a.next;
            l1++;
        }
        while(b!= null){
            b = b.next;
            l2++;
        }
        //l1 = 5 l2 = 3
        while(l1 > l2) {
            headA = headA.next;
            l1--;
        }
        while(l2 > l1) {
            headB = headB.next;
            l2--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}