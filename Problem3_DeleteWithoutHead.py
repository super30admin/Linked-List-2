'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# Delete without head pointer
# https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1#

#-----------------
# Time Complexity: 
#-----------------
# O(1) - 2 step operation with constant time
#------------------
# Space Complexity: 
#------------------
# O(1): Variables used in-place. Constant space. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if not curr_node:
            return
        else:
            if curr_node.next:
                curr_node.data = curr_node.next.data
                curr_node.next = curr_node.next.next