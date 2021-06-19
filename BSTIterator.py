# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    """controlled recursion
    Time complexity-O(1) in average case for both next and hasnext calls
next call worst case scenario would be O(n) but in average case we are traversing right side of particular node
Space complexity-O(h)"""
    def __init__(self, root: TreeNode):
        self.stack=[]
        self.dfs(root)

    def next(self) -> int:
        root=self.stack.pop()
        self.dfs(root.right)
        return root.val
        
        

    def hasNext(self) -> bool:
        if len(self.stack):
            return True
        else:
            return False
        
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root=root.left
        
    """Naive approach(uncontrolled recursion) inserting all elements into stack in inorder using constructor and then pop one by one while calling next function.
    But this way if we have large number of nodes we end up adding all elements into stack and use up lot of space.
    def __init__(self, root: TreeNode):
        self.stack=[]
        self.dfs(root)
        self.stack.reverse()
        print(self.stack)

    def next(self) -> int:
        root=self.stack.pop()
        return root
  
    def hasNext(self) -> bool:
        if len(self.stack):
            return True
        else:
            return False
    
    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        self.stack.append(root.val)
        self.dfs(root.right)
        """
    
    


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()