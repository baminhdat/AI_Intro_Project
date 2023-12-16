package main.ga;


import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.max;
import static main.Problem.maxVehicles;
import static main.Problem.N;
import static main.Problem.capacity;
public class Individual  {

    public ArrayList<Integer> chromosome;

    public double fitness;
    public boolean feasible;

    public Individual(){
        this.chromosome = new ArrayList<>();
        this.fitness = -1;
        this.feasible=false;
    }

    public Individual(ArrayList<Integer> chromosome){
        this.chromosome = new ArrayList<>(chromosome);
        this.fitness = -1;
    }

    public void random_init(){
        ArrayList<Integer> randomChromosome = new ArrayList<>();
        Random rand = new Random();


        // Tạo các phần tử trong chromosome
        for (int i = 0;i < N-1; i++) {
            randomChromosome.add(rand.nextInt(maxVehicles)+1); // chọn ngẫu nhiên từ 1 đến maxvehicles
        }
        this.chromosome = randomChromosome; // gán chromosome của this Individual bằng chromosome ngẫu nhiên vừa tạo
    }
    //Phần tử thứ i của Chromosome mang giá trị n tức là địa chỉ thứ i+1 do phương tiện n đảm nhận
    //Do địa chỉ 0 là địa chỉ xuất phát, tức là địa chỉ của kho
    //Hàm fitness là độ dài quãng đường lớn nhất mà 1 phương tiện phải đi
    public void calculateFitness(){
        boolean feasible=true;
        int max = 0;
        int currentVehicle = 1;
        while (currentVehicle < maxVehicles+1) {
            ArrayList<Integer> destilist = new ArrayList<>();
            int size = chromosome.size();
            for (int i = 0; i < size; i++) {
                if (chromosome.get(i) == currentVehicle)
                    destilist.add(i+1);
            }
            SubChromosome desti = new SubChromosome(destilist);
            if(desti.calculateCapacity()>capacity) feasible=false;
            int temp=max(desti.calculateCapacity()-capacity,0)*capacity+desti.calculate_fitness();
           // if (max< temp){
           //     max = temp;
           // }
            max+=temp;
            currentVehicle++;
        }

        this.fitness = (double)1.0/max;
        this.feasible=feasible;
    }

    public void swapMutate(){
        Random rand = new Random();
        int index1 = rand.nextInt(N-1);
        int index2 = rand.nextInt(N-1);

        // swap 2 index trong chromosome của this Individual
        int tmp = chromosome.get(index1);
        chromosome.set(index1, chromosome.get(index2));
        chromosome.set(index2, tmp);

    }

    double getFitness(){
        return -this.fitness;
    }



}
