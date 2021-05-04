import java.util.*;




/**
 * This code will implement the maximum subarray sum using the divide and conquer method. 
 */

public class App {


    /**
     * 
     * @param low
     * @param high
     * @param A
     * @return a list containing the indices marking the largest contiguous subarrays sums
     * on each side as well as the maximum subarray sum crossing the mid point of the locations.
     */
    public static int maxCrossingMidPoint(int low, int high, int [] A){
        int mid = (low + high)/2;
        int leftsum = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = 0; 
        for(int i = mid; i >= 0; i--){
            sum += A[i];
            if(sum > leftsum){
                leftsum = sum;
            }
        }

        int rightIndex = 0;
        sum = 0;
        int rightsum = Integer.MIN_VALUE;

        for(int i = mid+1; i <= high; i++){
            sum += A[i];
            if(sum > rightsum){
                rightsum = sum;
            }
        }

        return leftsum + rightsum;
    }

    /**
     * 
     * @param A
     * @param low
     * @param high
     * @return the maximum subarray sum within the array
     */

    public static int findMaximumSubarray(int []A, int low, int high){
        /**
         * procedure:
         * base case: if the high and low are the same index I.E a subarray of a single number
         * the function returns the number.
         * divide-conquer/Recursive step:
         * solve for the left half subarray
         * solve for the right half subarray
         * solve for the cross of the left and right
         * 
         * Combine step: 
         * find the subArray sum that is the greatest among the three calculated subarray sums
         */
        if(high == low){
            return A[low];
        }
        int mid = (low+high)/2; 
        int maxLeft = findMaximumSubarray(A, low, mid);
        int maxRight = findMaximumSubarray(A, mid+1, high);
        int crossMid = maxCrossingMidPoint(low, high, A);
        if(maxLeft >= maxRight && maxLeft >= crossMid)
            return maxLeft;
        else if(maxRight >= maxLeft && maxRight >= crossMid)
            return maxRight;
        
        return crossMid;
    }


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in the size of the array");
        int size = in.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = in.nextInt();
        }
        System.out.println(findMaximumSubarray(array, 0, array.length-1));

    }
}
