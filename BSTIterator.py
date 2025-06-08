"""
Use stack to for recursive inorder traversal
Initially push all left children from root
For every next(), pop the top, push right child's left branch
"""
"""
Time Complexity: O(1) amortized
Space Complexity: O(H) – height of the tree 
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        top = self.stack.pop()
        if top.right:
            self._leftmost_inorder(top.right)
        return top.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


if __name__ == "__main__":

    root = TreeNode(7)
    root.left = TreeNode(3)
    root.right = TreeNode(15)
    root.right.left = TreeNode(9)
    root.right.right = TreeNode(20)

    iterator = BSTIterator(root)
    print(iterator.next())   
    print(iterator.next())   
    print(iterator.hasNext()) 
    print(iterator.next())   
    print(iterator.hasNext()) 
    print(iterator.next())    
    print(iterator.hasNext()) 
    print(iterator.next())    
    print(iterator.hasNext()) 
