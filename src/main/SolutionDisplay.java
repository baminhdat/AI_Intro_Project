package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static main.Problem.coord;
public class SolutionDisplay extends JPanel {
    ArrayList<ArrayList<Integer>> routeList;
    public SolutionDisplay(ArrayList<ArrayList<Integer>> a){
        this.routeList=a;
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        int colorR;
        int colorG;
        int colorB;
        g.setColor(Color.BLACK);
      //  for(int i=0;i<=1000;i+=7){
       //     g.drawLine(50,i+50,1050,i+50);
       //     g.drawLine(i+50,50,i+50,1050);
      //  }
        for(ArrayList<Integer> i:routeList){
        //do {
            colorR = (int) (Math.random() * 256);
            colorG = (int) (Math.random() * 256);
            colorB = (int) (Math.random() * 256);
        //}while((colorR==255&&colorG==255&&colorB==255)&&(colorR==0&&colorG==0&&colorB==0));
            g.setColor(new Color(colorR,colorG,colorB));
            int j;
            for(j=0;j<i.size()-1;j++){
                g.drawOval(coord[i.get(j)].x*7+50-2,coord[i.get(j)].y*7+50-2,4,4);
                g.drawLine(coord[i.get(j)].x*7+50,coord[i.get(j)].y*7+50,coord[i.get(j+1)].x*7+50,coord[i.get(j+1)].y*7+50);
            }
        }
        g.setColor(new Color(0,123,167));
    //    g.drawString("Depot",coord[0].x*7+50,coord[0].y*7+50);
        g.drawOval(coord[0].x*7+50-2,coord[0].y*7+50-2,4,4);
        g.drawOval(coord[0].x*7+50-3,coord[0].y*7+50-3,6,6);
        g.drawOval(coord[0].x*7+50-4,coord[0].y*7+50-4,8,8);
        g.drawOval(coord[0].x*7+50-5,coord[0].y*7+50-5,10,10);
    }
}
