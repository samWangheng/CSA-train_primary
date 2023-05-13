import java.util.HashMap;
import java.util.Scanner;

public class homework_3 {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        new Test().test();
        System.out.println("<-------第二题------->");
        try {
            new Grade(100);
            new Grade(101);
        } catch (grade_Exception e) {
            System.out.println("Error,your grade should in 0-100.");
        }
        System.out.println("<-------第三题------->");
        try {
            new average().cnt(-1);
        } catch (average_Exception e) {
            System.out.println("必须是正数或者0，请重新输入1");
            try {
                System.out.println("average="+new average().cnt(9));
            } catch (average_Exception ex) {}
        }
        System.out.println("<-------第四题------->");
        System.out.println(new Employyee() {
            @Override
            public void earnings() {

            }
        });
        System.out.println("<-------第五题------->");
        compare a = new compare("abcde");
        a.flush(4);
        System.out.println(a.com());;
    }
}
interface Compute{
    public int computer(int n,int m);
}
class Compute_add implements Compute{

    @Override
    public int computer(int n, int m) {
        return n+m;
    }
}
class Compute_subtract implements Compute{

    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class Compute_multiply implements Compute{

    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class Compute_divide implements Compute{

    @Override
    public int computer(int n, int m) {
        return n/m;
    }
}
class UseCompute{
    public void useCom(Compute com,int one,int two){
        System.out.println(com.computer(one ,two));
    }

}
class Test{
    public void test(){
        UseCompute a = new UseCompute();
        a.useCom(new Compute_add(),12,4);
        a.useCom(new Compute_divide(),12,4);
        a.useCom(new Compute_multiply(),12,4);
        a.useCom(new Compute_subtract(),12,4);
    }

}

class Grade{
    public Grade(int a) throws grade_Exception {
        if(a>=0&&a<=100){
            System.out.println("Your Grade is "+a);
        }else{
            throw new grade_Exception();
        }
    }
}
class grade_Exception extends Exception{}

class average{
    public int cnt(int N) throws average_Exception {
        int sum = 0;
        if(N>=0){
            Scanner in = new Scanner(System.in);
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                sum+=a[i];
            }
        }else {
            throw new average_Exception();
        }
        return sum/N;
    }
}
class average_Exception extends Exception{}

class MyData{
    @Override
    public String toString() {
        return "MyData{"+"birthday"+"}";
    }
}
abstract class Employyee{
    private String name,number;
    private MyData birthday = new MyData();
    public abstract void earnings();

    @Override
    public String toString() {
        return "Employyee{" +
                "name='" + '\'' +
                ", number='"  + '\'' +
                ", birthday="  +birthday+
                '}';
    }
}

class compare{
    private String s = null;
    private HashMap<Integer,String> words = new HashMap<Integer,String>();

    public compare(String s) {
        this.s = s;
    }

    public void flush(int n){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            words.put(i,in.next());
        }
    }

    public int com(){
        int count = 0;
        boolean flag = false;
        for(int i=0;i<words.keySet().size();i++){
            int k = 0;
            for(int j=0;j<s.length();j++){
                if(words.get(i).charAt(k)==s.charAt(j)){
                    k++;
                    if(k==words.get(i).length()){
                        flag = true;
                        k = 0;
                    }else{
                        continue;
                    }
                }
            }
            if(flag==true){
                count++;
                flag = false;
            }
        }
        return count;
    }
}