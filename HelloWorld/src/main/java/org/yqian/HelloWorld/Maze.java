package org.yqian.Recursive;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
public class Maze {
 private static final Logger LOGGER = LoggerFactory.getLogger(Maze.class);  private int endX = 9; private int endY = 9; private int[][] maze = new int[10][10]; private boolean[][] wasHere = new boolean[10][10]; private boolean[][] path = new boolean[10][10];
 public void initializeMaze() {  generateMaze();  for (int i = 0; i < 10; i++)   for (int j = 0; j < 10; j++) {    wasHere[i][j] = false;    path[i][j] = false;   } }
 public boolean solveRecursively(int x, int y) {
  if (x == endX || y == endY)   if (maze[x][y] == 1) {    LOGGER.info("[" + x + "][" + y + "]");    return true;   }  if (maze[x][y] == 0 || wasHere[x][y])   return false;
  wasHere[x][y] = true;
  if (x != 0) {   if (solveRecursively(x - 1, y)) {    path[x][y] = true;    LOGGER.info("[" + x + "][" + y + "]");    return true;   }  }
  if (x != 9) {   if (solveRecursively(x + 1, y)) {    path[x][y] = true;    LOGGER.info("[" + x + "][" + y + "]");    return true;   }  }
  if (y != 0) {   if (solveRecursively(x, y - 1)) {    path[x][y] = true;    LOGGER.info("[" + x + "][" + y + "]");    return true;   }  }
  if (y != 9) {   if (solveRecursively(x, y + 1)) {    path[x][y] = true;    LOGGER.info("[" + x + "][" + y + "]");    return true;   }  }  return false; }
 private void generateMaze() {  maze[0] = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1 };  maze[1] = new int[] { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 };  maze[2] = new int[] { 0, 1, 0, 1, 0, 1, 1, 0, 1, 1 };  maze[3] = new int[] { 0, 1, 1, 1, 0, 0, 1, 0, 1, 0 };  maze[4] = new int[] { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 };  maze[5] = new int[] { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 };  maze[6] = new int[] { 0, 0, 0, 1, 1, 1, 0, 1, 1, 0 };  maze[7] = new int[] { 0, 0, 1, 0, 0, 1, 0, 1, 1, 0 };  maze[8] = new int[] { 0, 0, 1, 0, 0, 1, 1, 1, 0, 0 };  maze[9] = new int[] { 0, 0, 1, 0, 1, 0, 0, 0, 1, 0 }; }
 public static void main(String[] args) {  Maze maze = new Maze();  maze.initializeMaze();  boolean solved = maze.solveRecursively(0, 0);  if (solved)   LOGGER.info("The maze is solvable"); }}
