# O(1) TIME AND O(1) SPACE

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteNode(self, node):
        if node.next is None:
            node = None
            return
        node.val = node.next.val
        node.next = node.next.next
