package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Problem {
    public static class Pair {
        public int x;
        public int y;
    }
    public static Pair[] coord;
    public static int[][] distance;
    public static int capacity;
    public static int[] demand;
    public static int  N;
    public static int maxVehicles;
    public static int optiRes;
    public static void load_input_data(String filepath) throws FileNotFoundException{
        //get distance from FILE
        Scanner sc=new Scanner(new File(filepath));
        N=sc.nextInt();
        maxVehicles=sc.nextInt();
        capacity=sc.nextInt();
        coord=new Pair[N];
        distance=new int[N][N];
        demand=new int[N];
        for(int i=0;i<N;i++){
            if(i==sc.nextInt()-1){
            coord[i]=new Pair();
            coord[i].x= sc.nextInt();
            coord[i].y= sc.nextInt();
        }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                distance[i][j]=(int)sqrt(pow(coord[i].x-coord[j].x,2)+pow(coord[i].y-coord[j].y,2));
         //       System.out.print(distance[i][j]+" ");
            }
           // System.out.println();
        }
        for(int i=0;i<N;i++){
            if(i==sc.nextInt()-1){
                demand[i]=sc.nextInt();
            }
        }
        optiRes=sc.nextInt();
        sc.close();

//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.println(distance[i][j] +"\t");
//            }
//            System.out.println();
//        }
    }
}
