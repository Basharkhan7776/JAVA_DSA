public class TrappedRainwater 
{
    public static int trappedRainWaterOne(int height[])//Time Complexity ------> O(n^2)
    {
        if (height.length <= 2)
            return 0;

        int trapWater=0;

        for (int i = 0; i < height.length; i++)
        {
            int wl=0,maxleft=0,maxright=0;

            for (int j = i; j < height.length; j++)
                maxright=(maxright<height[j])?height[j]:maxright;

            for (int j = i; j >=0 ; j--)
                maxleft=(maxleft<height[j])?height[j]:maxleft;
            
            wl=Math.min(maxleft, maxright);

            trapWater += Math.max(0, wl - height[i]);
        }
        return trapWater;
    }
    public static int trappedRainWaterTwo(int height[])//Time Complexity ------> O(n)
    {
        int n = height.length;
        if (n <= 2)
            return 0; 

        int trapWater = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);

        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);

        for (int i = 0; i < n; i++) 
        {
            int wl = Math.min(maxLeft[i], maxRight[i]);
            trapWater += Math.max(0, wl - height[i]);
        }

        return trapWater;
    }
    public static void main(String[] args) 
    {
        int h[]={4,2,0,6,3,2,5};
        System.out.println(trappedRainWaterOne(h));
        System.out.println(trappedRainWaterTwo(h));
    }
}
