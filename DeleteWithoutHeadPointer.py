# Time Complexity :
# O(1)

# Space Complexity :  
# O(1)  





# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteNode(self, node: ListNode) -> None:
        if node is None or node.next is None:
            return 
        # Copy the data from the next node to the current node 
        node.val = node.next.val 
        # Delete the next node 
        node.next = node.next.next 