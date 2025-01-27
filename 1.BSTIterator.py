# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    """
    Time Complexity: 0(1) for 75% of the tree -- avg complexity
    Space Complexity: 0(h) -- h is height of tree
    Approach: 
        1. Add root to none node till LHS of the BST, during contructor call
        2. In hasNext() call check if stack if empty
        3. In Next() call, pop the node from the stack, update node to node.right
        and add remaining to the stack
    """

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []

        # preorder traversal -- all lhs to the stack till node is None
        self.__traversal(root)
        
    def __traversal(self, node: Optional[TreeNode]) -> None:
        
        while node != None:
            self.stack.append(node)
            node = node.left
        
        return

    def next(self) -> int:

        # pop the node from the stack
        node = self.stack.pop()
        result = node.val

        # add rest of the elements to the stack
        node = node.right

        self.__traversal(node)

        return result

    def hasNext(self) -> bool:
        
        if len(self.stack) == 0:
            return False
        
        return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()