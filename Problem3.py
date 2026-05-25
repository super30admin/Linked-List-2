# Time Complexity --> O(1)
# Space Complexity --> O(1)
class Solution:
    def deleteNode(self, del_node):
        # code here
        del_node.data = del_node.next.data
        temp = del_node.next
        del_node.next = del_node.next.next
        temp = None
