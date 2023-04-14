public class homework_1 {
    public static void showTriangle(int n){
        System.out.println("showtTriangle:");
        int cnt = n-1;
        for(int i=0;i<n;i++){
            for(int j=cnt;j>=0;j--){
                System.out.print(" ");
            }
            cnt--;
            for (int k=0;k<2*i+1;k++){//0 1/1 3/2 5
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void reverseString(String s){
        System.out.println("reverseString:");
        char[] chars = s.toCharArray();
//        System.out.println(s.length());
//        for(char a : chars){
//            System.out.print(" "+a);
//        }
        char[] new_char = new char[s.length()];
        for(int i=0;i<s.length();i++){
            new_char[s.length()-i-1] = chars[i];
        }
        System.out.println("before:"+s);
        System.out.println("after:"+new String(new_char));
//        System.out.println();
    }

    public static void isPalindrome(int num){
        System.out.print("isPalindrome:");
        int cnt;
        int sum = 0;
        Boolean flag = false;
        int num_1 = num;
        int num_2 = num;
        for(cnt=1;num_1/10!=0;cnt++){num_1/=10;}
        int[] num_c = new int[cnt];
        for(int i=0;i<cnt;i++){
            num_c[i] = num_2%10;
            num_2/=10;
        }
        for(int i=0;i<cnt;i++){
            sum+=num_c[num_c.length-i-1]*Math.pow(10,i);
        }
        flag = num==sum;
        if(flag){
            System.out.println("是的");
        }else{
            System.out.println("不是");
        }
//        System.out.println();

//        System.out.println("num = "+num+","+"sum="+sum);
    }

    public static void ShuiXianHua(){
        System.out.print("ShuiXianHua:");
        int num = 3;
//        System.out.print("have:");
        for(int i=100;i<=999;i++){
            int[] num_c = new int[num];
            int num_h = i;
            for(int j=0;j<num;j++){
                num_c[num-j-1] = num_h%10;
                num_h/=10;
            }
            if(num_c[0]*num_c[0]*num_c[0]+num_c[1]*num_c[1]*num_c[1]+num_c[2]*num_c[2]*num_c[2]==i){
                System.out.print(" "+i);
            }
        }
        System.out.println();
    }

    public static void arraysDemo(int[] num_c){
        System.out.print("arraysDemo:");
        int max = num_c[0];
        int min = num_c[0];
        int cnt = 10;
        for(int i=0;i<cnt;i++){
            if(num_c[i]>max){
                max = num_c[i];
            }else if(num_c[i]<min){
                min = num_c[i];
            }
        }
        System.out.println(" max = "+max+",min = "+min+",max+min="+(max+min));
    }


    public static void main(String[] args){
        System.out.println("1、 B,2、 B,3、 D,4、 B,5、 D");
        int[] num_c = {11,23,34,187,980,76,65,45,78,-9};
//        n_1(1);
        showTriangle(6);
        System.out.println();
//        n_2("hell0");
        reverseString("Hello World!");
        System.out.println();
//        n_3(122);
        isPalindrome(13431);
        System.out.println();
//        n_4();
        ShuiXianHua();
        System.out.println();
//        n_5(num_c);
        arraysDemo(num_c);
    }


}
