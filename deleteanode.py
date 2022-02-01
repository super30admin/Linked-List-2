# Time Complexity : O(1)
 # Space Complexity : O(1)
 # Did this code successfully run on Leetcode :
 # Any problem you faced while coding this :


 # Your code here along with comments explaining your approach

 # copy over next element into given node. Effectively deleting current node.
 # then delete the next element. So, elegant!

 class Solution:
     def delete(node):
         # for this to work a node.next must exist
         node.val = node.next.val
         node.next = node.next.next