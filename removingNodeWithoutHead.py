#TimeComplexity:O(n)
#SpaceComplexity:O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
# We can solve this problem by simply overwriting the required element value with the next node 

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        
        curr = curr_node
        
        
        temp = curr.next
        
        curr.data = temp.data
        curr.next = temp.next
        