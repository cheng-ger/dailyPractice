package cyl.simpledatastruc.mythread;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-30
 */
public class RunnableTest {


    public static void main(String[] args) {

        class MyRunnable implements Runnable {

            private Integer ticket = 20;

            @Override
            public void run() {
                //数据共享出现问题
                for (; this.ticket  > -1; this.ticket --) {
                    System.out.println(Thread.currentThread().getName()+ "余票：" +  this.ticket);
                }

                /*for (int i = 0; i < 20; i++) {
                    if(this.ticket > 0)
                    System.out.println(Thread.currentThread().getName()+ "余票：" +  this.ticket--);
                }*/

            }
        }



        //多执行几次看结果 有什么不一样
        //一个实例
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！这说明它们是共享了MyRunnable接口的。
        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        Thread t3 = new Thread(runnable, "t3");

        t1.start();
        t2.start();
        t3.start();




    }

}
