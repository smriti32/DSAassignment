package Coursework;

import java.util.Stack;
//Question 8A
//Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s
public class MaxSquareArea {
    public static int maxSquareArea(int[][] matrix) {
        // Step 1: Compute histogram for first row of matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] histogram = new int[cols];
        int maxArea = 0;
        for (int i = 0; i < cols; i++) {
            histogram[i] = matrix[0][i];
            maxArea = Math.max(maxArea, histogram[i]);
        }

        // Step 2-3: Compute histogram for each subsequent row and update maxArea
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If cell in matrix is 0, add the value of the cell above it to histogram
                if (matrix[i][j] == 0) {
                    histogram[j] += matrix[i - 1][j];
                } else {
                    // If cell in matrix is 1, reset histogram for that column to 0
                    histogram[j] = 0;
                }
            }
            // Update maxArea using the updated histogram for current row
            maxArea = Math.max(maxArea, maxHistogramArea(histogram));
        }

        // Step 4: Return maxArea
        return maxArea;
    }

    // Helper function to compute maximum area of a histogram using a stack
    public static int maxHistogramArea(int[] histogram) {
        int n = histogram.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            // Keep popping elements from stack and calculating area until the current element is greater than the top element
            while (!stack.isEmpty() && (i == n || histogram[stack.peek()] > histogram[i])) {
                int height = histogram[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            // Push current element onto stack
            stack.push(i);
        }
        // Return max area
        return maxArea;
    }

    // Main function to test the algorithm
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1}};
        int maxArea = maxSquareArea(matrix);
        System.out.println("Maximum area of square made by 0s: " + maxArea);
    }
}
