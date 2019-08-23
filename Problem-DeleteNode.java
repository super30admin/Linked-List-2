// Time Complexity : 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void deleteNode(ListNode node) {

//         ListNode n1=null;
        
//         n1=node.next;
//         while(n1!=null){
//             if(n1.val==node.val){
//                 node.next=n1.next;
//             }
//         }
        
        
       if(node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
}

