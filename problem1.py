'''
Time Complexity: O(n) -> skewed tree
Space Complexity: O(n)->stack
Did this code successfully run on Leetcode : Yes
Explanation : Top of the stack gives the next element -> Go as left as possible adding the elements in the stack.
Pop the lowest element when .next is called. Check if the popped elements right exists, if yes add the left side of the
rightmost element. Keep doing this until all elements are seen.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        cursor = root
        while cursor != None:
            self.stack.append(cursor)
            # find the minimum element and add it to the stack
            cursor = cursor.left

    def next(self) -> int:
        """
        @return the next smallest number
        """
        result = self.stack.pop()
        cursor = result.right

        while cursor != None:
            self.stack.append(cursor)
            cursor = cursor.left

        return result.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return not len(self.stack) == 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()