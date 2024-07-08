package Mine2024.RottenOranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution1 {
  public static void main(String[] args) {
    int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; //4
//    int[][] grid = {{2, 1, 1}, {0,1,1}, {1,0,1}}; //-1
//    int[][] grid = {{0,2}}; //-1
    Solution1 s = new Solution1();
    System.out.println(s.orangesRotting(grid));
  }

    public int orangesRotting(int[][] grid) {
      // this is a BFS problem
      //check all the cells and put cell with value 2 in the queue
      // process the q and mark everything connected to 2
      //

      int minutes = 0;

      boolean[][] marked = new boolean[grid.length][grid[0].length];
      Queue<Cell> q = new LinkedList<>();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 2) {
            q.add(new Cell(i, j));
          }
        }
      }
      minutes = processNeighborsOfAllNodesInTheQueue(q,minutes, grid, marked);

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 1) {
            return -1;
          }
        }
      }

      return minutes;
    }

    int processNeighborsOfAllNodesInTheQueue(Queue<Cell> q, int minutes, int[][] grid, boolean[][] marked){
      Queue<Cell> newNeighbors = new LinkedList<>();
      boolean colorChanged = false;

      while(!q.isEmpty()){
        Cell current = q.remove();
        List<Cell> neighbors = neighbors(current, grid);
        for (Object cell : neighbors) {
          Cell c = (Cell) cell;
          if (!marked[c.getX()][c.getY()]) {
            newNeighbors.add(c);
            grid[c.getX()][c.getY()] = 2;
            colorChanged = true;
          }
        }


      }
      if(colorChanged){
        minutes++;
      }
      if(newNeighbors.isEmpty()){
        return minutes;
      }else{
        return processNeighborsOfAllNodesInTheQueue(newNeighbors, minutes, grid, marked);
      }

    }

    List neighbors(Cell cell, int[][] grid) {
      //x+1, x-1
      //y+1, y-1
      int x = cell.getX();
      int y = cell.getY();
      List neighbors = new ArrayList<Cell>();
      if (isValid(x - 1, y, grid)) {
        neighbors.add(new Cell(x - 1, y));
      }
      if (isValid(x + 1, y, grid)) {
        neighbors.add(new Cell(x + 1, y));
      }
      if (isValid(x, y - 1, grid) ){
        neighbors.add(new Cell(x, y - 1));
      }
      if (isValid(x, y + 1,  grid) ){
        neighbors.add(new Cell(x, y + 1));

      }
      return neighbors;
    }

    Boolean isValid(int i, int j, int[][] grid) {
      return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j]==1;
    }



}





