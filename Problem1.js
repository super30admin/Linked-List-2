// Time Complexity : next - Worst Case -O(h), Avg O(1), hasNext O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var stack;
var BSTIterator = function (root) {
    stack = [];
    dfs(root)
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function () {
    let result = stack.pop();
    dfs(result.right);
    return result.val;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function () {
    return (!(stack.length === 0));
};

var dfs = function (root) {
    while (root) {
        stack.push(root);
        root = root.left;
    }
}

