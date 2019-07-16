package cyl.simpledatastruc.designemodel.factorymethodpattern;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-16
 */
public class Moto implements IFactoryBuild{
    @Override
    public void run() {
        System.out.println("Moto");
    }
}
