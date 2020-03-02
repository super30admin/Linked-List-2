'''
Solution:
1.  Put current node's next value into current node and delete current node's next value.

Time Complexity: O(1) and Space Complexity: O(1)

--- Passed testcases available on GeeksForGeeks
'''

class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None


class DeleteWithoutHead(object):
    def deleteNode(self, curr_node):
        #   edge case check
        if (curr_node == None or curr_node.next == None):
            return None

        #   Put current node's next value into current node and delete current node's next value.
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next

        return


