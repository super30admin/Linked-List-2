class Solution:
    def deleteNode(self, node):
        node.data = node.next.data
        
        node.next = node.next.next
