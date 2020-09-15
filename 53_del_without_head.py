# S30 Big N Problem #53 {Medium}

# Delete without header node

# Time Complexity : O(n) n=no. of nodes in the linked list
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Copy the value of next node to the current node (node to be deleted)
# do this till you reach the end of the list
# remove the last node of the linked list 


def deleteNode(curr_node):
    #code here
    
    p=curr_node
    
    while p.next!=None:
        p.data=p.next.data
        p=p.next
    
    p=curr_node
    
    while p.next.next!=None:
        p=p.next 
    
    p.next=None


    

