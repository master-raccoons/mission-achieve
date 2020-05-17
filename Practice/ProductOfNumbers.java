public class ProductOfNumbers {

    public static void main(String ar[])
    {
        int nums[]={1,2,3,4,5};
        int output[]=new int[nums.length];
        // 1    1    2   6   24
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



        for(int i=0;i<output.length;i++)
        {
            System.out.print(output[i]+",");
        }
    }

    /* with o(n) space complexity  */
private static int[] product(int nums[])
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
