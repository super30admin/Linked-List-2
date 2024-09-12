# Time Complexity : Add - O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used Swapping to copying data of nextodelete node, and adress its poiinting to
'''

def deleteNode(curr_node):
    #code here
    temp = curr_node.next
    curr_node.data = temp.data
    curr_node.next = temp.next
    temp = None