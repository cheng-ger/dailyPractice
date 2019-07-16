package cyl.simpledatastruc.designemodel.singletonpattern;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-16
 */

// 懒汉模式
public class Singleton2 {

    private static Singleton2 singleton;


    private Singleton2() {
    }
    //在多线程并发的情况下 ，有多个线程同时执行到if(null ==  singleton) 那么这几个都会为true
    public  static synchronized Singleton2 getInstance(){
        if(null ==  singleton)  singleton = new Singleton2();
        return singleton;
    }
}
