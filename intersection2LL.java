//Time Complexity : O(m+n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //base case
        if(headA==null || headB==null)
            return null;
        //initialize length of A and B
        int a=0,b=0;
        //to note the current position
        ListNode c=headA;
        //iterate over the list
        while(c!=null){
            //move current pointer to next and increment the length
            c=c.next;
            a++;
        }
        //to find the len of B
        c=headB;
        while(c!=null){
            //move current pointer to next and increment the length
            c=c.next;
            b++;
        } 
        //checking len of lists
        while(a>b){
            //decrement the len of a and move to next node
            a--;
            headA=headA.next;            
        }
        while(b>a){
            b--;
            headB=headB.next;
        }
        //check if 2lists are at same position, if not move the pointer to next nodes
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headB;
    }
}