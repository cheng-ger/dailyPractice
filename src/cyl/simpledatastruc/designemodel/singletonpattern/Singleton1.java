package cyl.simpledatastruc.designemodel.singletonpattern;

/**
 * @author chengyuanliang
 * @desc    确保一个类只有一个实例 ，而且执行实例化后并向整个系统提供这个实例
 *          单例模式
 *          饿汉模式  ：在类加载到内存时就已经创建好了对象
 *          懒汉模式  ：在第一次使用时 加载创建实例
 * @since 2019-07-16
 */
//饿汉模式
public class Singleton1 {

    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }


    public  static Singleton1 getInstance() {

        return singleton;
    }
}
