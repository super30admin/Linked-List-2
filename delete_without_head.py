# Time Complexity :
# O(1)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We copy the next element's data into our current element and remove the next element from the linked list
#we can do this because we are assured that we will not be asked to delete the last element

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):

        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next
