package main;

import main.ga.GA;
import main.ga.Individual;
import main.ga.SubChromosome;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.Problem.maxVehicles;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<ArrayList<Integer>> routeList = new ArrayList<ArrayList<Integer>>();
        String problemCodeName;
        Scanner input = new Scanner(System.in);
        problemCodeName = input.nextLine();
        // Cập nhật đường dẫn đến file chứa dữ liệu test
        Problem.load_input_data("C:\\Users\\ThisPC\\IdeaProjects\\AI_Intro_Project\\src\\main\\data\\"+problemCodeName+".txt");
        System.out.println("Address no.1 is the starting point, or the depot");
        long startTime = System.nanoTime();
        Individual best = new Individual();
        int iter=0;
      //  while(!best.feasible&&iter<50){
       GA solver=new GA();
      //  if(best.fitness==-1){
        best=solver.run();
       // }
      // else{
       //     if(best.fitness>solver.run().fitness){
       //         best=solver.run();
      //      }
      //  }
      //  iter++;
      //  }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        int[] cost = new int[maxVehicles];
        int current = 1;
        while (current < maxVehicles+1) {
            ArrayList<Integer> destilist = new ArrayList<>();
            int size = best.chromosome.size();
            for (int i = 0; i < size; i++) {
                if (best.chromosome.get(i) == current)
                    destilist.add(i + 1);
            }
            SubChromosome desti = new SubChromosome(destilist);
            int capacity = desti.calculateCapacity();
            cost[current-1]=desti.calculate_fitness();
            routeList.add(desti.route);
            System.out.print("Route for vehicle "+current+" is: ");
            for(int id: desti.route){
                id=id+1;
                System.out.print(id+" ");
            }
            System.out.println();
            System.out.println("The cost being "+cost[current-1]+" and its capacity is "+capacity);
            current++;
        }
        int sum=0;
        for(int i=0;i<maxVehicles;i++){
            sum+=cost[i];
        }
        System.out.println("And the total cost is "+sum);
        System.out.println("The optimal Result is "+Problem.optiRes);
        System.out.println("The Genetic Algorithm finished in approximately "+ duration/1000000000+" seconds");
        JFrame frame = new JFrame("Solution Graph");
        frame.setSize(1000,1000);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new SolutionDisplay(routeList));
        frame.setVisible(true);
    }
}
