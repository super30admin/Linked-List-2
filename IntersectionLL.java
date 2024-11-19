// Time Complexity : O(m+n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - we figure out the 
//length of both LL, then we start equidistant from the intersection node based 
//on the difference in length of the lists. And if the nodes are equal at any
//point then we found our intersection


public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode currA = headA, currB = headB;
        while(currA != null){
            currA = currA.next;
            countA++;
        }
        while(currB != null){
            currB = currB.next;
            countB++;
        }
        currA = headA;
        currB = headB;
        while(countA > countB){
            currA = currA.next;
            countA--;
        }
        while(countB > countA){
            currB = currB.next;
            countB--;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
