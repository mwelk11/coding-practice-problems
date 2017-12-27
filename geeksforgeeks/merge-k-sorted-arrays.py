'''Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.'''


# your task is to complete this function
# function should return an array/list
# arr is the 2D Matrix containing the sorted arrays

#Problem Statement: https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

#Summary: Give an array of sorted arrays, return a list of the sorted arrays in increasing order.
def mergeKArrays(arr, n):
    size = 0;
    for i in range(len(arr)):
        size += len(arr[i])
    output = [0 for x in range(size)]
    
    idx = 0
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            output[idx] = arr[i][j]
            idx += 1
            
    output.sort();
    return output
