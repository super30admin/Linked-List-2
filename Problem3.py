#Time complexity: O(n)
#Space complexity: O(1)

#Accepted on GFG

#Approach
#We know that we cannot directly delete current node
#Since current node is guaranteed not to be the last node, shift all values from cur_node to end ahead by 1
#Finally, delete the last node

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        cur = curr_node
        
        while cur.next.next != None:
            cur.data = cur.next.data
            cur = cur.next
        cur.data = cur.next.data
        cur.next = None
