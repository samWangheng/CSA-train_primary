package JDBC_demo;

import java.util.Random;

public class homework_7 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }
    public static void main(String[] args) {
//        test();
//        task1("abbc","dog cat cat fish");
//        task2(new int[]{1,2,2,3,0});
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
//        task3(new int[]{0,4,5,6,8},4);
    }
    public static boolean task1(String pattern, String str) {
//第一题代码
        //        String patern = "abba";
        boolean res=true;
        String flag = "a";
//        String str = "dog dog dog dog";
        int num_fla = 'a';
        String[] numstr = str.split(" ");
        String[] mark = new String[numstr.length];
        mark[0] = numstr[0];
//        for(String i : mark){
//            System.out.println(i+" ");
//        }

        for(int i=0;i< numstr.length-1;i++){
//            System.out.println(numstr[i]==numstr[i+1]);
            if(!numstr[i].equals(numstr[i+1])){
//                System.out.println(numstr[i]+"**"+numstr[i+1]);
                mark[i+1] = numstr[i+1];
            }
        }
//        for(String i : mark){
//            System.out.println(i+" ");
//        }

        for(int i=0;i<mark.length-1;i++){
            if(mark[i]!=null&&mark[i+1]!=null){
                num_fla++;
                flag+=(char)num_fla;
            }else if(mark[i]!=null&&mark[i+1]!=null){
                flag+=(char)num_fla;
            }else if(mark[i]==null){
                num_fla++;
                flag+=(char)num_fla;
            }else if(mark[i+1]==null){
                flag+=(char)num_fla;
            }

        }
        if(!flag.equals(pattern)){
            res = false;
        }
        System.out.println(flag);
//        boolean res=true;
        return res;
    }
    public static int task2(int[] nums) {
//第二题代码
//        int[] nums ={2, 3, 1, 0, 2, 5, 3};
//        int  = 0;
        int res=0;
        boolean flag = false;
//        int[] nums_mark = new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    res = nums[i];
                    System.out.println(nums[i]);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return res;
    }
    public static int task3(int[] nums,int target){
//第三题代码
//        int[] nums = {0,3,5,6,8,9};
        int head = 0;
        int tail = nums.length-1;
//        System.out.println(tail);
        int res=0;
//        int target = 5;
//        int target = 7;
        while(head<tail){
            int mid = (head+tail)/2;
//            System.out.println("mid="+mid);
            if(target>nums[mid]){
                head = mid+1;
            }else if(target<nums[mid]){
                tail = mid-1;
            }else{
                res = mid;
                System.out.println(mid);
                break;
            }
//            System.out.println("head="+head+" tail="+tail);
//            System.out.println("mid="+nums[mid]);
            if(head==tail&&nums[head]!=target){
                res = -1-mid;
                System.out.println(res);
            }
        }
        return res;
    }
}

