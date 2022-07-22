# Time Complexity: O(V+E)
# Space Complexity: O(V+E)

import collections


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True

        indegree = []
        hashmap = {}
        for req in prerequisites:
            incoming = req[0]
            outgoing = req[1]
            indegree[incoming] += 1
            if outgoing not in hashmap:
                hashmap[outgoing] = [incoming]
            else:
                hashmap[outgoing].append(incoming)
        
        q = collections.deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append[i]

        while q:
            curr = q.popleft()
            edges = hashmap[curr]
            if edges is None:
                continue
            for edge in edges:
                indegree[edge] -= 1
                if indegree[edge] == 0:
                    q.append(edge)

        for i in range(numCourses):
            if indegree[i] != 0:
                return False


        return True
