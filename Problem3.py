#First, I check if the given node is the last node, which shouldn't happen according to the problem statement, but it's good to handle this edge case. Then, I copy the data from the next node into the current node, essentially overwriting the value we want to "delete". Finally, I update the next pointer of the current node to skip over the next node, effectively removing it from the list. This approach works because it maintains the order of the remaining elements, decreases the number of nodes by one, and doesn't require access to the head of the list. It's an O(1) time and space complexity solution.

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def deleteNode(self, del_node):
        # Check if the node to be deleted is the last node
        if del_node.next is None:
            # This case should not occur as per the problem statement
            return
        
        # Copy the data of the next node to the current node
        del_node.data = del_node.next.data
        
        # Update the next pointer to skip the next node
        del_node.next = del_node.next.next