"""
BST Iterator

What are Iterators?
Iterators handle dynamic changes better than static data structures
For Iterator details :https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Iterators_and_generators
Iterators are only concerned about the next index and check if it exists or not, where as a loop is used to traverse through the entire array

Loops cannot handle dynamic changes to the data structure whereas iterators can take care of those. Changes to the data structure while iteration is in progress can be handled

Modify, edit, delete, add - all the functions can be performed dynamically while using iterators

Approch 1 -
Making the list from the given BST is not the correct approach as a valid iterator needs to be able to handle dynamic nature of underlying data
structure

Approach 2 - Controlled recursion using external stack

We will be using a physical stack to control the recursion.

Use a dynamic iterator. We need to do inorder traversal for this iterator implementation. So use DFS to go to left subtree leaf. 
When user does call for next(), we check if stack hasNext() and then pop that value, push its right to stack using self.dfs(r.right)
and return value of r

This way if anything apart from initial left subtree changes, iterator can still handle that dynamically, as it is at most storing just
one left most path and everything else is not stored in the stack. 

** since Iterator is a data structure, we are considering the amortized time and space complexity: 
Time complexity - O(1) - for both next and hasNext()

Space complexity - O(1) - for both next and hasNext()

for 75% of the nodes, we are processing O(1) right nodes are processed
    leaf nodes - n/2 - no right nodes to be processed - O(1)
    second level - only one right node is processed : therefore 75%
    rest of them will have more nodes

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        
        self.stack = []
        self.dfs(root)
        
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left
            
    def next(self) -> int:
        if self.hasNext():
            node = self.stack.pop()
            self.dfs(node.right)
            return node.val
        
    def hasNext(self) -> bool:
        return len(self.stack)!=0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()