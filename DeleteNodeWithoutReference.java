//Problem:54 -Delete without head pointer
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

/*
 Just update the value of the node to be deleted from the next node and then just put next node.next pointer in the node to be deleted.
*/

class DeleteNode{

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }


    private void deleteNodeWithoutReferenec(ListNode node){

        node.val = node.next.val;
        node.next = node.next.next;

    }

}