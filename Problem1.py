# https://leetcode.com/problems/binary-search-tree-iterator/

# Time Complexity: O(n)
# Space Complexity: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.s = deque()
        self.helper(root)

    def helper(self, root):
        while root is not None:
            self.s.append(root)
            root = root.left 

    def next(self) -> int:
        temp = self.s.pop()
        self.helper(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.s) > 0
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()