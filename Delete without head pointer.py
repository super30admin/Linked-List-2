# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(1)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - since we can't access the node previous to the one to be deleted
    - we copy the value of next node to current
    - link the current node to the next of next, and delete next node
    '''
    def deleteNode(self, node):
        if node is None or node.next is None:
            return
        temp = node.next
        node.data = temp.data
        node.next = temp.next
        temp.next = None