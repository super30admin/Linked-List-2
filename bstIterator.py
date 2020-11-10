# As taught in class, the iterator has concept of returning the element value only if the next elemnt exist so, I used dfs to traverse the tree and resturn the element only if requsted.
#Time Complexity: O(h)
#Space Complexity: O(1)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root):
        self.stack = list()
        self.dfs(root)
        
    def dfs(self,root):
        while (root is not None):
            self.stack.append(root)
            root = root.left

    def next(self):
        returnNode = self.stack.pop()
        if (returnNode.right is not None):
            self.dfs(returnNode.right)
        return returnNode.val
        

    def hasNext(self):
        if len(self.stack)==0:
            return True
        else:
            return False


        
