# just swap the values till the end
# TC SC - O(n) SC(1)

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        curr = node
        while curr.next:
            curr.data = curr.next.data
            if not curr.next.next:
                curr.next = None
                break
            curr = curr.next
