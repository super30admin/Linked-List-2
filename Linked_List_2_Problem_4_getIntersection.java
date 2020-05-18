//Time complexity : O(n)
//Space complexity : O(1)
//Runs successfully on leetcode
//No problem

//Here we will be checking length of two lists
//We will traverse ahead in the longer list so that both the lists have equal elements left
//No we will traverse ahead in both lists at the same time
//If they arrive at a single node, that'll be the intersection 


public class Linked_List_2_Problem_4_getIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA =0;
        int lengthB =0;
        ListNode head = headA;
        while(head!=null)
        {
            head = head.next;
            lengthA++;
        }
        head = headB;
        while(head!=null)
        {
            head = head.next;
            lengthB++;
        }
        while(lengthA>lengthB)
        {
            headA = headA.next;
            lengthB++;
        }
        while(lengthB>lengthA)
        {
            headB = headB.next;
            lengthA++;
        }
        while(headA!=headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}
