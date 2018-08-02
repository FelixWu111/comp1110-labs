package comp1110.lab2;

public class Extension {
    public static void main(String[] args) {
        int[] array=new int[] {11,22,33,44,5,66,77,88,99,100};
        int a =0;
        for (int i=0;i<array.length;i++){
            if (array[i]==5) {
                a=5;
                break;
            }else{a+=array[i];}
        }
        int counter =0;
        System.out.println(a);
        for (int j=1;j<=100;j++){
            if (j%3==0){
                continue;
            }else{counter=counter+j;}
        }
        System.out.println(counter);
    }
}
