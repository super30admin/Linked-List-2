# next 
# TC : O(n)
# SC : O(h)

# hasNext
# TC : O(1)
# SC : O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.left_most_inorder(root)
        # print("printing stack everytime", (self.stack))
    
    def left_most_inorder(self, root):
        while root:
            self.stack.append(root)
            # print(self.stack,"             ok             ")
            root = root.left

    def next(self) -> int:
        top_node = self.stack.pop()
        # print("printing top most node", top_node, "          ", self.stack)
        if top_node.right:
            self.left_most_inorder(top_node.right)
        return top_node.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()