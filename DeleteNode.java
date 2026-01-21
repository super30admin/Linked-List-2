//As we don't have access to prev node, we cannot delete curr node. Current node can be deleted only if previous node is present.
//Because curr node is a local varible --> stays in stack memeory
//link to next node points to reference present in heap memory
//If we modify curr to null, it changes only in local
//If we modify curr.next to null, it changes the one in heap memory
//As we don't know prev node, don't try to delete it. Just modify it
//TC: O(n); SC:O(1)
class Solution {
    public void deleteNode(Node del) {
        // code here
       while(del.next!=null && del.next.next!=null){
           del.data=del.next.data;
           del=del.next;
           
       }
       
       del.data=del.next.data;
       del.next=null;
        
    }
}
