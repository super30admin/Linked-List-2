##Time Complexity : O(1)
##Space Complexity : O(1)
##Did this code successfully run on Leetcode : Yes
class Solution:
    def deleteNode(self, node):
        
        node.val=node.next.val
        node.next=node.next.next