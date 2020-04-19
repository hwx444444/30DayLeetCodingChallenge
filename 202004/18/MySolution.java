/*
 *  Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

import java.util.Arrays;

public class MySolution {
    public static String string;
    public static void main(String[] args) {
        // char[][] islands = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
            };
        // System.out.println(Arrays.deepToString(grid));
        for(int i = 0; i < grid.length; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        System.out.println("");
        // min value for 1st row
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        // min value for 1st column
        for(int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
        // min value for the rest
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                if(grid[i][j-1] < grid[i-1][j]){
                    grid[i][j] += grid[i][j-1];
                }else{
                    grid[i][j] += grid[i-1][j];
                }
            }
        }
        // print the new grid
        for(int i = 0; i < grid.length; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}