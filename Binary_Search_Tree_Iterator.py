# Created by Aashish Adhikari at 10:06 AM 1/20/2021

'''
Time Complexity:
hasnext() : O(1)
next() : O(h)

Space Complexity:
O(h) because in the worst case, we have h number of nodes in the recursive stack.
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        from collections import deque
        self.recursive_stack = deque()
        self.dfs(root)





    def next(self):
        """
        :rtype: int
        """
        # get the node on top of the recursive stack
        node = self.recursive_stack.pop()

        # if it has a right child, need to store those to the recursive stack as well before returning itself since inorder traversal
        self.dfs(node.right)


        return node.val



    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.recursive_stack) != 0:
            return True
        return False

    def dfs(self, node):


        # the inner while loop of iterative implementation of inorder traversal

        while node is not None:
            # add the parent to the stack and then go to the left chile
            self.recursive_stack.append(node)
            node = node.left




# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()