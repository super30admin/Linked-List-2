// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
We will get the lengths of both the lists and see whihc one is bigger
we wil move the list that much amount and then we move one step, they will meet at a point
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode aPtr = headA;
    ListNode bPtr = headB;

    while(aPtr!=null && bPtr!=null){ // move both one step at a time until anyone reaches null
        if(aPtr == bPtr) break; // if they both pointing to same, then it is an intersection so break of
        aPtr = aPtr.next;
        bPtr = bPtr.next;
        
    }

    if(aPtr == bPtr && aPtr==null) return null; // if they both point to null, there is no intersection

    // check which one is null, so that other one is smaller
    
    if(aPtr == null){ // A reached first , it means b is smaller
        ListNode temp = bPtr; // taking ref from b
        bPtr = headB; // starting from head and move the diff steps
            
        while(temp!=null){
        temp = temp.next;
        bPtr= bPtr.next;
        }
        aPtr = headA; // resetting A
    }
    else if(bPtr == null){ // B reached first , it means a is smaller
        ListNode temp = aPtr; // taking ref from a
        aPtr = headA; // starting from head and move the diff steps
     while(temp!=null){
        temp = temp.next;
        aPtr= aPtr.next;
        }
        bPtr = headB; // resetting b
    }

    // now we will start and move them one step, so they will  meet at the intersection

    while(aPtr!=bPtr){
        aPtr =aPtr.next;
        bPtr = bPtr.next;
    }

    return bPtr; // return anyone of them

       
    }

}