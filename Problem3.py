# Time Complexity = O(1) | Space Complexity = O(1)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteNode(self, node: ListNode):
        # Copy the value of next to del node and point next of del node to next's next
        node.val = node.next.val
        node.next = node.next.next

