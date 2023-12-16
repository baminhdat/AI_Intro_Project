package main.ga;

import java.util.ArrayList;
import static main.Problem.distance;
import static main.Problem.demand;
public class SubChromosome {
    public ArrayList<Integer> chromosome;

    public int fitness;

    public ArrayList<Integer> route;

    public SubChromosome(ArrayList<Integer> chromosome){
        this.fitness=0;
    //    this.chromosome=new ArrayList<>();
        this.chromosome=chromosome;
    //    this.chromosome.addAll(chromosome);
        this.route=new ArrayList<>();
    }
    public int calculateCapacity(){
        int temp=0;
        for(int i=0;i< chromosome.size();i++){
            temp+=demand[chromosome.get(i)];
       //     System.out.println(demand[chromosome.get(i)]+" "+chromosome.get(i));
        }
        return temp;
    }
    public int calculate_fitness(){
        int index=0;//Địa điểm hiện tại của xe, bắt đầu từ kho
        route.add(0);
        int sum=0;
        while(!chromosome.isEmpty()){ //Khi còn chưa thăm hết các địa điểm xe phải đi
            int size = chromosome.size();
            int minDistance=10000; //Cho khoảng cách gần nhất rất lớn
            int min=chromosome.get(0);
            int position=0;
            for(int i=0;i<size;i++){ //Duyệt SubChromosome
                if(minDistance>distance[index][chromosome.get(i)] && chromosome.get(i)!=index){
                    minDistance=distance[index][chromosome.get(i)];
                    min=chromosome.get(i);//Tìm địa điểm gần nhất với địa điểm hiện tại
                    position=i;
                }
            }
            sum+=minDistance;
            index=min; //Thêm địa điểm gần nhất và cập nhật
            route.add(index);
            chromosome.remove(position);
        }
        route.add(0);
        sum+=distance[index][0];
        this.fitness=sum;
        return sum;
    }
}
