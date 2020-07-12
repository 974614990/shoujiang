package day12;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程
 * 进程：正在运行的一个程序 系统会为这个进程分配独立的内存资源
 * 线程：具体执行任务的最小单位，一个进程最少拥有一个线程（主线程  运行起来就以要执行的线程）
 *          线程之间是共享内存资源的（进程申请的）   一个线程就是独立完成一个小任务
 *          线程之间可以通信（数据传递的）多数情况下，多数为主线程和子线程之间传递
 *          每一个线程都有自己的运行回路（生命周期）
 *          线程里面的运行结果是不唯一的
 *  线程的生命周期 （线程的状态）：
 *  NEW：新建  线程刚被创建好
 *          RUNNABLE：就绪状态  只要抢到时间片就可以运行这个程序
 *          BLOCKED ：阻塞状态 sleep 时间片结束 wait sleep时间结束notify就重新回到就绪状态
 *          WAITING：等待 wait
 *          TIMED_WAITING
 *          TERMINATED  终止
 *      为什么要创建子线程
 *          如果在主线程中存在比较耗时的操作：下载视频 上传文件  数据处理
 *          这些操作会阻塞主线程，后面的任务必须等这些任务执行完毕之后才能执行，用户的体验比较差
 *        为了不阻塞主线程，需要将好事的任务存方法子线程中去处理
 *  如何创建一个子线程
 *  1、协议类继承于Thread  实现run方法
 *  2、实现Runnable接口 实现run方法
 *          a、创建任务 创建类实现Runnable接口
 *          b、使用Thread 为这个任务分配线程
 *          c、开启任务start
 *
 *  线程方法：
 *  join：让当前这个线程阻塞 等join的线程执行完毕在执行
 *  setName：设置线程名称
 *  getName：获取线程名称
 *  currentThread：获取当前运行的线程对象
 *  start：开启线程
 */
public class MyClass {
    static TestThread tt2;
    public static void main(String [] args){
        //创建Thread对象开启任务
        //main 方法里面执行的代码都是在主线程里面执行的
        /*
        TestThread tt = new TestThread();
        tt.start();
        */
        /*
       String name=  Thread.currentThread().getName();
        System.out.println(name);

        //创建Thread对象
        TestThread tt = new TestThread();
        //设置线程的名称
        tt.setName("子线程");
        //开启任务
        tt.start();

*/
        /*
        TestThread tt2 = new TestThread();
        //设置线程的名称
        tt2.setName("子线程2");
        //开启任务
        tt.start();
        for(int i = 0; i < 5 ;i++){
            System.out.println("main:"+(i+1));
        }

        //1、接口 抽象方法
        //创建一个任务： 创建一个类实现Runnable 接口
        PXDThread pt = new PXDThread();

        //使用Thread操作这个任务
        Thread t = new Thread(pt);
        t.setName("子线程1");
        t.start();

        Thread t2 = new Thread(pt);
        t2.setName("子线程2");
        t2.start();
        */

        /*
        //这个任务只需要使用一次
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i <=100;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        });
        t.setName("子线程1");
        t.start();
        */

        /*
        //创建线程的同时 直接开启线程任务
        //不需要操作线程对象本身
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i <=100;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }).start();
        */
        /*使用Lambda表达式 ，创建任务简洁 不建议：阅读性太差
        new Thread(()->{
            for(int i = 1;i <=100;i++){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }).start();
        */
        //线程安全 Synchronized同步   Lock 加锁解锁
        /*
        Synchronized 同步监听器 需要一把锁
        任何一个对象都有自己的一把锁
        如果多个线程操作同一个代码块，必须需要同步
        那么必须操作同一哥对象/同一把锁
        synchronized(){
                需要同步的代码
           }
         */
        //1、同步代码块
        /*
        synchronized(监听器、对象、锁){
            需要同步的代码
        }
        */
        //2、同步方法
        /*
        必须确保多个对象调用的同方法时操作的同一个对象
          public synchronized void test() {
          本质就是同步代码块
          等价于
          synchronized(this){
                test();
               }
         */
        /*
            死锁
            A -> B
            B -> A
            Lock
            ReentraintLock 可重入锁


            使用接口实现线程之间数据回调
            Person类
            线程里面 Agent类
         */
        //买票
        /*
        Ticket ticketCQ = new Ticket("重庆");
        Thread t1 = new Thread(ticketCQ);
        t1.start();

        Ticket ticketSH = new Ticket("上海");
        Thread t2 = new Thread(ticketSH);
        t2.start();

*/
        Person zs = new Person();
        zs.needHouse();
        /*
             1、如何创建一个线程 Thread Runnable
             2、线程同步 synchronized  ReentrantLock
             3、主线程和子线程之间使用接口是回调数据
             4、线程间的通讯：synchronized (wait  notify  notifyAll)
                               ReentrantLock  lock;
                               Condition c =lock.newCondition()
                               await single singleAll
         */
    }
}

//用于买票的任务
class Ticket implements Runnable {
    //定义所有车票的数量
    public static int num = 100;
    String name;

    public Ticket(String name) {
        this.name = name;
    }

   static final Object obj = new Object();

    //创建一个可重入的锁
    static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //判断有没有票
          //  synchronized (obj) {
                //需要同步的代码
            lock.lock();
                if (num > 0) {
                    System.out.println(name + "出票：" + num);
                    num--;
                    /*
                    try {
                        //当前线程等待
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //通知其他线程执行
                        obj.notify();
                    }
                    */
                } else {
                    break;
                }
            lock.unlock();

        }

    }
    /*
    test();
    public synchronized void test() {
        for (int i = 1; i <= 100; i++) {
            //需要同步的代码
            if (num > 0) {
                System.out.println(name + "出票：" + num);
                num--;
            } else {
                break;
            }
        }
    }*/

}

class PXDThread implements Runnable {
    public void run() {
        for(int i = 1;i <=100;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
class TestThread extends Thread {
    //实现run方法
    //方法里面就是具体需要执行的代码

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(this != MyClass.tt2) {
                if (i == 20) {
                    try {
                        MyClass.tt2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + 1);
                }
            }
            super.run();
        }
    }
}