import java.util.Stack;

public class day31 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSL = new int[n]; // Nearest Smaller to Left
        int[] NSR = new int[n]; // Nearest Smaller to Right

        // Calculate NSL (Nearest Smaller to Left)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack to reuse for NSR
        stack.clear();

        // Calculate NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        HistogramWithNSLNSR solution = new HistogramWithNSLNSR();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("The largest rectangle area is: " + solution.largestRectangleArea(heights));
    }
}