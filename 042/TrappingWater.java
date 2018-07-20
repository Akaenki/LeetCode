public class TrappingWater {
    public static int trap(int[] height) {
        int h = 0, t = height.length-1;
        int count = 0, cmax = 0;

        while(h < t){
            cmax = Math.max(cmax, Math.min(height[h], height[t]));
            if(height[h] < cmax) count += cmax-height[h];
            if(height[t] < cmax) count += cmax-height[t];
            if(height[h] < height[t]) h++;
            else t--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}
