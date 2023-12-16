package main.ga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import main.Configs;

public class Population {

    public ArrayList<Individual> individuals;

    public Individual best;

    public Population(){
        individuals = new ArrayList<Individual>();
        best = null;
    }

    public void randomInit(){
        int i=0;
      //  for(int i = 0; i < Configs.POPULATION_SIZE; i++){
        while(i<Configs.POPULATION_SIZE){
            Individual individual = new Individual();
            individual.random_init();
        //    if(individual.calculateFitness()==true){
            individuals.add(individual);
            i++;
         //   System.out.println(i);
         //   }
        }
    }
    
    public ArrayList<Individual> crossover(Individual p1,Individual p2) {
        ArrayList<Individual> offsprings = new ArrayList<Individual>();

        for (int i = 0; i < 2; i++) {
            Individual offspring = new Individual();
            ArrayList<Integer> chromosome = new ArrayList<Integer>();

            for (int j = 0; j < p1.chromosome.size(); j++) {
                if (Math.random() < 0.5) {
                    chromosome.add(p1.chromosome.get(j));
                } else {
                    chromosome.add(p2.chromosome.get(j));
                }
            }

            offspring.chromosome = chromosome;
        //    if (offspring.calculateFitness() == true) {
                offsprings.add(offspring);
        //        }
            }

            return offsprings;
        }

    public void executeSelection (){
        this.individuals.sort(Comparator.comparingDouble(Individual::getFitness));
//        best=individuals.get(0);
        int len=individuals.size();
        while(individuals.size()>Configs.POPULATION_SIZE){
             individuals.remove(len-1);
             len--;

        }
        int i=0;
     //   do{
        best=individuals.get(i);
      //  if(best.feasible) break;
      //  else i++;
      //  }while(true&&(i<Configs.POPULATION_SIZE));
    }
}
