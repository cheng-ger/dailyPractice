package cyl.simpledatastruc.designemodel.factorymethodpattern;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-16
 */
public class MotoFactory implements  IFactory {
    @Override
    public   IFactoryBuild getFactory() {
        return new Moto();
    }
}
