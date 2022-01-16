'''
TC: O(n)
SC: O(1)

'''
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        prev = curr_node
        curr = curr_node.next
        
        while curr.next:
            prev.data = curr.data
            prev = prev.next
            curr = curr.next
        
        prev.data = curr.data
        prev.next = None