'''
Time Complexity : next() - O(1)
                  hasNext() - O(1)
Space Complexity : O(h) where is h is the height of the tree
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):
        curr = root
        while curr != None:
            self.stack.append(curr)
            curr = curr.left

    def next(self) -> int:
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self) -> bool:
        if len(self.stack) != 0:
            return True
        return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
