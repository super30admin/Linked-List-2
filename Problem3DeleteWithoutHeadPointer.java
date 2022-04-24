// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO

public class DeleteNode {
    public static void deleteNode(ListNode delete){
       if(delete.next==NULL){
           delete=NULL;
       }
       else{
           delete.data=delete.next.data;
           delete.next=delete.next.next;
       }
    }
}