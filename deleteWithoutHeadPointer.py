# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(1) no extra space.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def deleteNode(self, del_node):
        # code here
        
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next

