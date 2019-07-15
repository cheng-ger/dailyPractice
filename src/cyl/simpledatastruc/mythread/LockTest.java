package cyl.simpledatastruc.mythread;

/**
 * @author chengyuanliang
 * @desc synchronized的基本规则总结为下面3条
 * 第一条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，
 *        其他线程对该对象的该synchronized方法或者synchronized代码块的访问将被阻塞。
 *
 * 第二条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，
 *       其他线程仍然可以访问该对象的非同步代码块。
 *
 * 第三条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，
 *       其他线程对该对象的其他的synchronized方法或者synchronized代码块的访问将被阻塞。
 *
 *实例锁：锁在某个实例对象上。如果该类是单例，那么该锁也是具有全局锁的概念。
 *       实例锁对应的就是synchronized关键字。
 *
 * 全局锁：该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
          全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。

    pulbic class Something {
        public synchronized void isSyncA(){}  实例锁
        public synchronized void isSyncB(){}  实例锁
        public static synchronized void cSyncA(){} 全局锁
        public static synchronized void cSyncB(){} 全局锁
    }
 * @since 2019-06-30
 */
public class LockTest {


     static class Something{

         public  void isA(){
             for(int i=0;i<5;i++){
                 try {
                     Thread.sleep(100);
                     System.out.println(Thread.currentThread().getName()+" : isA");
                 } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
             }
         }

         public  void isB(){
             for(int i=0;i<5;i++){
                 try {
                     Thread.sleep(100);
                     System.out.println(Thread.currentThread().getName()+" : isB");
                 } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
             }
         }


        public synchronized void isSyncA(){
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : isSyncA");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public synchronized void isSyncB(){
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : isSyncB");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public static synchronized void cSyncA(){
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName()+" : cSyncA");
                }
            }catch (InterruptedException ie) {
            }
        }

        public static synchronized void cSyncB(){
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName()+" : cSyncB");
                }
            }catch (InterruptedException ie) {
            }
        }
    }

    Something x = new Something();
    Something y = new Something();

    private void test1(){

        Thread nonSynchronized = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isA();
                //x.cSyncA();
            }
        },"t11");

        Thread t11 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncA();
                //x.cSyncA();
            }
        },"t11");

        Thread t12 = new Thread(new Runnable(){
            @Override
            public void run() {
                x.isSyncB();
                //y.isSyncA();
                //y.cSyncB();
                //Something.cSyncA();
            }
        },"t12");

        t11.start();
        t12.start();
    }


    public static void main(String[] args) {


        LockTest lockTest1 = new LockTest();
        lockTest1.test1();
    }
}
