// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = 0,length2 = 0;
        ListNode temp1 = headA,temp2 = headB;
        while(temp1!=null){
            length1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        while(length1 > length2){
            length1--;
            temp1=temp1.next;
        }
        temp2 = headB;
        while(length2 > length1){
            length2--;
            temp2=temp2.next;
        }
        while(temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;



    }
}