'''
Solution
1.  The next() method should always return the next minimum element in the BST.
2.  Whenever an element is popped from the stack that is used, push that node's right element and then all its left
    elements till the leftmost [the next minimum will be present in leftmost leaf of right subtree]

Time Complexity: O(1) average case and O(height) worst case [worst case is when you put all left subtree on to the stack]
Space Complexity: O(height)

--- Passed all Testcases on Leetcode successfully
'''

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        #   push root only if exists -- edge case check
        if (root != None):
            self.stack.append(root)
            self.__dfs(root)

    def __dfs(self, node):
        #   push all left elements of the current node till the leaf node
        while (node.left != None):
            self.stack.append(node.left)
            node = node.left
        return

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        if not (self.hasNext()):
            return -1

        #   pop the top element
        topNode = self.stack.pop()

        #   push its right node and then push all the right node's left values
        if (topNode.right != None):
            self.stack.append(topNode.right)
            self.__dfs(topNode.right)

        return topNode.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return (len(self.stack) > 0)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()