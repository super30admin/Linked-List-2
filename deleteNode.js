// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

var deleteNode = function(node){
    
    node.data = node.next.data
    node.next = node.next.next
}
