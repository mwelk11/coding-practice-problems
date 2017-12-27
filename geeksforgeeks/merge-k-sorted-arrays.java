/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

// Problem Statement: https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

// Summary: Give an array of sorted arrays, return a list of the sorted arrays in increasing order.

/*Complete the function below*/
class GfG
{
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        int size = 0;
        for(int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
        }
        int[] output = new int[size];
        
        int idx = 0;
        for(int i = 0; i < arrays.length; i++) {
            for(int j = 0; j < arrays[i].length; j++) {
                output[idx] = arrays[i][j];
                idx++;
            }
        }
        
        Arrays.sort(output);
        return convertToList(output);
    }
    
    private static ArrayList<Integer> convertToList(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        return arrList;
    }
}
