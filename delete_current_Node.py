# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
    # started copying values backwards, using slow and fast pointer, fast is always one step ahead


class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if(curr_node==None):
            return
        if(curr_node.next.next==None):
            curr_node.data=curr_node.next.data
            curr_node.next=None
            return 
            
        slow=curr_node
        fast=slow.next
        prev=None
        while(fast):
            slow.data=fast.data
            prev=slow
            slow=slow.next
            fast=fast.next
        prev.next=None