//import com.sun.istack.internal.localization.NullLocalizable;

import java.util.ArrayList;
import java.util.Scanner;

public class homework_2 {
    public static void main(String[] args){
        System.out.println("<-------第一题------->");
        Monkey a = new Monkey("jack");
        People b = new People("mike");
        a.speak();
        b.speak();
        b.think();
        System.out.println("<-------第二题------->");
        Car c = new Car(4,1150.0,3);
        Truck e = new Truck(6,15000.0,1,3000.0);
        Car d = new Car(4,1150.0,6);
        Truck f = new Truck(6,15000.0,1,7000.0);
        System.out.println("<-------第三题------->");
        System.out.println(getSum("13829579081298345918257","438823897418920918472193"));
        System.out.println("<-------第四题------->");
        System.out.println("3*7的网格中共有"+uniquePaths(3,7)+"条路径");
        System.out.println("<-------第五题------->");
        Scanner in = new Scanner(System.in);
        String[] g = new String[3];
        for(int i=0;i<3;i++){
            g[i] = in.next();
        }
        System.out.println(longestCommonPrefix(g));
    }
    public static String getSum(String a, String b){
        ArrayList<Integer> la= new ArrayList<Integer>();
        ArrayList<Integer> lb= new ArrayList<Integer>();
        int flag = 0;
        int min = Math.min(a.length(),b.length());
        int max = Math.max(a.length(),b.length());
        StringBuffer result = new StringBuffer();
        for(int i = a.length()-1;i>=0;i--){
            la.add(a.charAt(i)-'0');
        }
        for(int i = b.length()-1;i>=0;i--){
            lb.add(b.charAt(i)-'0');
        }
        for(int i = 0;i<min;i++){
            if(la.get(i)+lb.get(i)+flag>=10){
                result.append((la.get(i)+lb.get(i))%10+flag);
                flag = 0;
                flag++;
            }else{
                result.append(la.get(i)+lb.get(i)+flag);
                flag = 0;
            }
        }
        if(a.length()>b.length()){
            for(int i=min;i<a.length();i++){
                result.append(la.get(i));
            }
        }else if(a.length()<b.length()){
            for (int i=min;i<b.length();i++){
                result.append(lb.get(i));
            }
        }
        return result.reverse().toString();
    }

    public static int uniquePaths(int a,int b){
        if(a==1&&b==1){
            return 1;
        }else if(a==1&&b!=1){
           return uniquePaths(a,b-1);
        }else if(a!=1&&b==1){
           return uniquePaths(a-1,b);
        }
        return uniquePaths(a-1,b)+uniquePaths(a,b-1);
    }

    public static String longestCommonPrefix(String[] strs){
        String ans = "";
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j< strs.length;j++){
                if(strs[j].length()==i||strs[j].charAt(i)!=strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return ans;
    }
}
class Monkey{
    private String name = null;
    public Monkey(String s){
        this.name = s;
    }
    public void speak(){
        System.out.println("咿咿呀呀");
    }
}
class People extends Monkey{
    public People(String s) {
        super(s);
    }

    @Override
    public void speak() {
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话！认真思考！");
    }
}
class Vehicle{
    Integer wheels = 0;
    Double weight = null;

    public Vehicle(Integer wheels,Double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }
}
class Car extends Vehicle{
    Integer loader = 0;

    public Car(Integer wheels, Double weight,Integer loader) {
        super(wheels, weight);
        this.loader = loader;
        System.out.println("车轮的数量是："+wheels+" 车重："+weight);
        if(loader<6){
            System.out.println("这是一俩小车，能载6人，实载"+loader+"人");
        }else{
            System.out.println("这是一俩小车，能载6人，实载"+loader+"人，你超员了！！！");
        }
    }
}
class Truck extends Vehicle{
    Integer loader = 0;
    Double payload = null;

    public Truck(Integer wheels, Double weight,Integer loader,Double payload) {
        super(wheels, weight);
        this.loader = loader;
        this.payload = payload;
        System.out.println("车轮的数量是："+wheels+" 车重："+weight);
        if(loader<3){
            System.out.println("这是一俩卡车，能载3人，实载"+loader+"人");
        }else{
            System.out.println("这是一俩卡车，能载3人，实载"+loader+"人，你超员了！！！");
        }
        if(payload<5000){
            System.out.println("这是一俩卡车，核载5000kg，你已装载"+payload+"kg");
        }else{
            System.out.println("这是一俩卡车，核载5000kg，你已装载"+payload+"kg，你超载了！！！");
        }
    }
}


