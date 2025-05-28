public class Normal {
  // 42. Trapping Rain Water
  public int trap(int[] height) {
        int l = height.length;
        int[] leftGretest = new int[l];
        int[] rightGretest = new int[l];

        leftGretest[0] = height[0];
        for(int i = 1; i < l; i++){
            leftGretest[i] = Math.max(leftGretest[i - 1], height[i]);
        }

        rightGretest[l - 1] = height[l - 1];
        for(int i = l-2; i >= 0; i--){
            rightGretest[i] = Math.max(rightGretest[i + 1], height[i]);
        }

        int ans = 0;
        for(int i = 0; i < l; i++){
            int water = Math.min(leftGretest[i], rightGretest[i]) - height[i];
            if(water > 0){
                ans += water;
            }
        }

        return ans;
    }
}
