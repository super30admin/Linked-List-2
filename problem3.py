#delete without header pointer
# // Time Complexity : O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def deleteNode(curr_node):
    curr_node.data = curr_node.next.data            #replace the data from the next node to this one
    curr_node.next = curr_node.next.next            #disregard the next node by setting the next node of current node to next.next