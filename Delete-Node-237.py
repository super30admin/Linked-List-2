# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach class Solution(object):

#Just change the value of the current node with the next node and the pointer
class Solution(object):
    def deleteNode(self, node):
        if node and node.next:
            node.val, node.next = node.next.val, node.next.next
            
