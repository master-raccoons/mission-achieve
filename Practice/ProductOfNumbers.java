/*
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such
 * that prod[i] is equal to the product of all the elements of arr[] except arr[i].
 * Solve it without division operator in O(n) time.
 * Example :
 * Input: arr[]  = {1,2,3,4,5}
 * Output: prod[]  = {120,60,40,30,24}
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


public class ProductOfNumbers {

    public static void main(String ar[])
    {

        int nums[]={1,2,3,4,5};
        int output[]=calculateProduct(nums);
       for(int i=0;i<output.length;i++)
        {
            System.out.print(output[i]+",");
        }
    }

    /*This is the first approach where auxiliary space is O (n) */
    private static int[] calProduct(int nums[])
    {

        int output[]=new int[nums.length];
        int left=1;
        for(int i=0;i<nums.length;i++)
        {
            output[i]=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            output[i]=right*output[i];
            right*=nums[i];
        }
        return output;
    }


    /*Second Approach for same problem with o(2n)-> O(n) space complexity  */
private static int[] calculateProduct(int nums[])
{
    int leftNum[]=new int[nums.length];
    int rightNum[]=new int[nums.length];
    int left=1;
    int right=1;
    int len=nums.length;
    for(int i=0;i<len;i++)
    {

        leftNum[i]=left;
        left*=nums[i];
        rightNum[len-i-1]=right;
        right*=nums[len-i-1];

    }

    for(int i=0;i<len;i++)
    {
        nums[i]=leftNum[i]*rightNum[i];
    }

return nums;

}

}
