package day3;

public class Utils {

    //输出一行数据 不换行
    public static void showTest(String test){
        System.out.print(test);
    }
    //输出一行数据  换行
    public  static  void showTestln (String test){
        System.out.println(test);
    }

    /**
     * 输出一行数据 可以设置分隔符
     * @param hasStar
     * @param test
     */
    public static void showTest(boolean hasStar,String test){
        if(hasStar){
            System.out.println("************************");
        }
        System.out.println(test);
        if(hasStar){
            System.out.println("************************");
        }
    }
    public static void showTest(String...tests){
        System.out.println("************************");
        //下注  自动给每个选项添加编号
        for(int i = 1; i <= tests.length;i ++ ){
            String str = tests[i-1];
            System.out.println(i+". " +str);
        }
        System.out.println("************************");
    }
}

