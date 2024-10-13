# Approach
# If the head node is not given just copy the deletenode next value to deletenode
# then point deletenode.next = deletenode.next.next


#Complexities
#Time :O(1)
#Space:O(1)

class Solution:

    def delete(selfself,node):
        node.data = node.next.data
        node.next = node.next.next

