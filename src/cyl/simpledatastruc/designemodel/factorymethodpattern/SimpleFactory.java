package cyl.simpledatastruc.designemodel.factorymethodpattern;

/**
 * @author chengyuanliang
 * @desc  简单工厂
 * @since 2019-07-16
 */
public class SimpleFactory {

    public  static  IFactoryBuild getWay(String type){

        if ("car".equals(type)) return new Car();
        else if("moto".equals(type)) return new Moto();
        throw new IllegalArgumentException("非法参数");
    }

    public static void main(String[] args) {

        IFactoryBuild car = getWay("car");
        car.run();

    }
}
