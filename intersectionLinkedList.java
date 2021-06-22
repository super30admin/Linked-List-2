//time complexity: O(n)
//space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr=headA;
        int lenA=0;
        int lenB=0;
        while(curr!=null)
        {
            lenA++;//find the lenght of first linked list
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null)
        {
            lenB++;//find the length of second linked list
            curr=curr.next;
        }
        while (lenA>lenB)
        {
            headA=headA.next;//if length of A is more then 
            //move the headA untill the difference between the length is 
            //zero
            lenA--;
        }
        while(lenB>lenA)
        {
            headB=headB.next;//if length of B is more then 
            //move the headB untill the difference between the length is 
            //zero
            lenB--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;//when headA and headB are at the same node then return 
        //headA or headB
    }
}
