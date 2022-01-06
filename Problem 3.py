# Time: O(n)
# Space: O(1)
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        prev = curr_node
        curr = prev.next
        while curr != None:
            prev.data = curr.data
            if curr.next != None:
                prev = curr
            curr = curr.next
        prev.next = None
