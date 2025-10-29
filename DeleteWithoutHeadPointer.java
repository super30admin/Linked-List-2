// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : As we dont know the previous node we cannot reverse and perform the delete, so we make the del node to look like del.next and pointing
// to del.next.next so that the next element is gone.


/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public void deleteNode(Node del) {
        if(del==null||del.next==null){
            return;
        }
        del.data=del.next.data; //assign next value to current
        del.next=del.next.next; //point to next.next so that .next is eliminated
    }
}