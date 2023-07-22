/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.List;

/**
 *
 * @author HP
 */
public class DepthFirst {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[x][y]==0){
            maze[x][y]=2;
            int[][] dir = {{1,0},{0,1},{-1, 0},{0,-1}};
            
            for (int i=0; i<dir.length; i++) {
                int tempx = dir[i][0];
                int tempy = dir[i][1];
                if(searchPath(maze, x+tempx, y+tempy, path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        return false;
    }
    
}
