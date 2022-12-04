# Time Complexity: O(N)
# Space Complexity: O(h) - height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = list()
        self.dfs(root)

    def next(self) -> int:
        popped = self.stack.pop()
        #when next is called we need to add the next element to be iterated and for that
        # we need to append the right element and its left children to the stack
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return len(self.stack)!=0

        #will append all the left elements of the root to the stack
    def dfs(self,root):
        while root!=None:
            self.stack.append(root)
            root=root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()