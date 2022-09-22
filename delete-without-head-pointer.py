

# TC : O(n)
# SC : O(1)
class Solution:
    def deleteNode(self,curr_node):
        if curr_node.next:
            p1 = curr_node
            p2 = curr_node.next
            p1.data = p2.data
        while p2.next:
            p1 = p1.next
            p2 = p2.next
            p1.data = p2.data
        p1.next = None