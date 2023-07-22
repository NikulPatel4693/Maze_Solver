/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class GraphicsClass extends JFrame {
    private int[][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public GraphicsClass(){
        setTitle("Maze Solver");
        setSize(720, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);
        //System.out.println(path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(100, 100);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                
                switch(maze[i][j]){
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.RED; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(40*j, 40*i, 40, 40);
                g.setColor(Color.RED);
                g.drawRect(40*j, 40*i, 40, 40);
            }
        }
        for(int i=0; i<path.size(); i+=2){
            int xCord = path.get(i);
            int yCord = path.get(i+1);
            g.setColor(Color.GREEN);
            g.fillRect(40*yCord+5, 40*xCord+5, 30, 30);
        }
    }
    
    
    public static void main(String[] args){
        GraphicsClass view  = new GraphicsClass();
        view.setVisible(true);
    }
}
