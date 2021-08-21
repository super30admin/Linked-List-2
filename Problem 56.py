"""
Time complexity: O(n)
Space complexity: O(1)
Approach:
1. Maintain a queue and append the root node to the queue
2. whlie size of queue is greater than zero
3. maintain the number of elements in that level
4. within this loop while there are more elements in that level
5. add that element to a list and check if it has children, if it does add it to the queue
6. pop the current element.
7. at the end of each loop add the list elements to a result list.

"""

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        " if root node is none return none"
        if root == None:
            return None
        else:
            "initialize a queue and append the root node to the queue"
            queue = list()
            queue.append(root)
            levelsize, size = 0, 1
            result = list()
            "while queue is not empty iterate over the queue"
            while (len(queue) != 0):
                "update the current level size to the size of the next "
                levelsize = size
                size = 0
                levelElements = list()

                "add elements of the current level to the  list and add their children to the queue."
                while (levelsize):
                    levelElements.append(queue[0].val)

                    if queue[0].left:
                        queue.append(queue[0].left)
                        size += 1
                    if queue[0].right:
                        queue.append(queue[0].right)
                        size += 1
                    queue.pop(0)
                    levelsize -= 1
                result.append(levelElements)

            return result