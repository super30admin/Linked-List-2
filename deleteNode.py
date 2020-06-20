# Time Complexity : O(n)  
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def deleteNode(self,node):
        while node.next.next:
            node.data = node.next.data
            node = node.next 
        node.data = node.next.data 
        node.next = None