package comp1110.lab3;

public class Bucket {
    private final double capacity;
    private double contents;
    public Bucket(double capacity){
        this.capacity=capacity;
    }
    public double getCapacity(){
        return this.capacity;
    }
    public double getContents(){
        return this.contents;
    }
    public double empty() {
        this.contents=0;
        return this.contents;
    }
    public double add(double amount){
        if(amount+this.contents<this.capacity){
            this.contents+=amount;
        }else{
            this.contents=this.capacity;
        }
        return this.contents;
    }

    public static void main(String[] args) {
        Bucket big=new Bucket(10.0);
        Bucket small=new Bucket(1.0);
        big.add(20.0);
        small.add(20.0);
        big.getContents();
        small.getContents();
        big.empty();
        System.out.println(big.add(small.contents));

    }

}
