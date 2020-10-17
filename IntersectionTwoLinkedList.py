#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov  7 10:14:15 2019

@author: tanvirkaur
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Approach : we will iterate through both the linked list, substract the length of longer linked list from the smaller one and move the head pointer of the longer link list to move forward as many steps as the difference.
# Time complexity = O(n)
# Space complexity = O(1)
# Leetcode acceptance yes

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        ha = headA
        hb = headB
        countA = 0
        countB = 0
        while ha:
            countA += 1
            ha = ha.next
            
        while hb:
            countB += 1
            hb = hb.next
            
        mx = None
        mn = None
        
        diff = max(countA,countB) - min(countA,countB)
        if countA > countB:
        
            mx = headA
            mn = headB
        else:
            mx = headB
            mn = headA
        while diff!= 0:
            mx = mx.next
            diff += -1
            
        while (mx != mn):
            mx = mx.next
            mn = mn.next
        return mx
        