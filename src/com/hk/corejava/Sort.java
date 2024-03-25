package com.hk.corejava;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
		int arr[] = {4,3,5,2,5,3,2,5,5,4,2,2,4,5,1,7,9,7,5,1};
		mergeSort(arr);
        printArray(arr);
	}
    private static void mergeSort(int[] arr) {
		divide(arr,0,arr.length-1);
		
	}
	private static void divide(int arr[], int si, int ei)
    {
        if (si < ei) { 
            // Find the middle point
            int mid = si + (ei - si) / 2; 
            // divide first and second halves
            divide(arr, si, mid);
            divide(arr, mid + 1, ei); 
            // sort
            sort(arr, si, mid, ei);
        }
    }
    private static void sort(int arr[], int si, int m, int ei)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - si + 1;
        int n2 = ei - m; 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2]; 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[si + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = si;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        } 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] outputArr) {
		System.out.println(Arrays.toString(outputArr));		
	}
}