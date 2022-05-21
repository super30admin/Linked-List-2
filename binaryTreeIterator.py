'''
time complexity: O(1)
space complexity: O(h)
h is height of tree
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
        self.root = root
        self.dfs(root)
        
        

    def next(self) -> int:
        temp = self.stack.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        if(len(self.stack)!=0):
            return True
        return False
    def dfs(self,node):
        while(node!=None):
            self.stack.append(node)
            node=node.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()