/*O(N), space - O(1)
 * calcuate the length of lists, move the pointer of the list which is larger to the ones of the length of smaller, so we are comparing and compare the 2 lists's corresponding elements
 *
 * */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA= 0 ;
        int lenB= 0 ;

        ListNode first = headA;
        ListNode second  = headB;
        while(first != null){
            lenA +=1 ;
            first = first.next;
        }

         while(second != null){
            lenB +=1 ;
            second = second.next;
        }

        if (lenA > lenB){
            for (int i = 0 ; i < (lenA-lenB); i++){
                headA = headA.next;
            }
        }
        if (lenA < lenB){
            for (int i = 0 ; i < (lenB-lenA); i++){
                headB =  headB.next;
            }
        }



        while(headA != headB){
            headA = headA.next;
            headB  = headB.next;
        }

        return headA;
    }
}
