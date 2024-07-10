# Time Complexity :
# O(1)
# space complexity : O(1)

# Approach :

#  store the value of the next node
# update the current node's value to next node
# update the current node's next to current node . next .next

class Solution:
    # Function to delete a node without any reference to head pointer.
    def deleteNode(self, del_node):
        # code here

        if not del_node:
            return None

        nextNodeVal = del_node.next.data
        del_node.data = nextNodeVal
        del_node.next = del_node.next.next

        return del_node
