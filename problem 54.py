#  https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on GFG : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach



class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node is None or node.next is None:
            return
        
        temp = node.next # store the next in temp
        node.data = temp.data # copy the data
        node.next = temp.next # point it to its next
        


