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
        double d = this.contents;
        this.contents=0;
        return d;
    }
    public void add(double amount){
        if(amount+this.contents<this.capacity){
            this.contents+=amount;
        }else{
            this.contents=this.capacity;
        }
    }

    public static void main(String[] args) {
        Bucket big=new Bucket(10.0);
        Bucket small=new Bucket(1.0);
        big.add(20.0);
        small.add(20.0);
        System.out.println(small.contents);
        System.out.println(big.contents);
        big.getContents();
        small.getContents();
        big.empty();
        big.add(small.contents);
        small.empty();
        System.out.println(small.contents);
        System.out.println(big.contents);

    }

}
