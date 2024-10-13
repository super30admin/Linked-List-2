'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        
        curr = node
            
        while curr.next:
            curr.data = curr.next.data
            prev = curr
            curr = curr.next
            
        prev.next = None

