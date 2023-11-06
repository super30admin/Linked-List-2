# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#do inorder in constructor, bst traversal == inorder
#TC: O(n), n is no of nodes in tree
#SC: O(n), n recursive calls
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.li = []
        self.idx = 0
        
        def inorder(root):
            if root is None: 
                return 
            inorder(root.left)
            self.li.append(root)
            inorder(root.right)
            
        inorder (root)

    def next(self) -> int:   
        curr = self.li[self.idx]
        self.idx += 1
        return curr.val
        
    def hasNext(self) -> bool:
        return True if self.idx != len(self.li) else False

#lazy loading - controlled recursion
#TC: O(1) for hasnext and O(1) for next
#SC: O(n) , n is no od nodes in stack
#problem: genius, how does one even think of this?
class BSTIterator:
    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left
            
    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)
        print(self.st)

    def next(self) -> int:   
        popped = self.st.pop()
        self.dfs(popped.right)
        return popped.val
        
    def hasNext(self) -> bool:
        return True if len(self.st) > 0 else False



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()