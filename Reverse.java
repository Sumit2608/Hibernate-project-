package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Reverse {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of elements to be added");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.next());
        }
        for(String a:list){
            System.out.println(a);
        }
        for(int j=0;j<n/2;j++){
            String Temp;
            Temp=list.get(j);
            list.set(j,list.get(n-1-j));
            list.set(n-1-j,Temp);



        }
        System.out.println(list);


    }
}
