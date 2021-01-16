# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    #Approach: Controlled Recursion
    #Time Complexity: O(1) // O(h) for the worst case - but that doesn't happen a lot
    #Space Complexity: O(h) // recursion stack

    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root)

    def next(self) -> int:
        popped = self.st.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return True if self.st else False
        
    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left
        return

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()