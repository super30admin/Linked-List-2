""" Explanation: In order to implement a BST Iterator, a stack is an optimal choice since it's an
    LIFO data structure. Using a stack can make can check if the next node exists and inserting a left most node
    both an O(1) operation and next an O(n) operation.
    Time Complexcity: Mentioned above
    Space Complexcity: O(1)
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.push_left_nodes(root)

    def push_left_nodes(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self):
        """
        :rtype: int
        """
        # move the pointer to the right and return the number at the top of the stack
        if not self.hasNext():
            return None
        
        current_node = self.stack.pop()
        # push the left nodes
        self.push_left_nodes(current_node.right)

        return current_node.val     

    def hasNext(self):
        """
        :rtype: bool
        """
        return bool(self.stack)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()