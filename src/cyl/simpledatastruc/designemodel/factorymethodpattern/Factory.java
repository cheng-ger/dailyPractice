package cyl.simpledatastruc.designemodel.factorymethodpattern;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-16
 */
public class Factory {

    public static void main(String[] args) {
        IFactory factory = new CarFactory();
         factory.getFactory().run();
    }
}
