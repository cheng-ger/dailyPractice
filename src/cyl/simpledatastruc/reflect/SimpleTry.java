package cyl.simpledatastruc.reflect;

import cyl.simpledatastruc.model.UserInfoModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-06-26
 */
public class SimpleTry {

    public static void main(String[] args) {
        System.out.println("<<<<<<<<<<<<<============>>>>>>>>>>>>>");
        getModelClass();
        System.out.println("<<<<<<<<<<<<<============>>>>>>>>>>>>>");
        getModelConstructor();
        System.out.println("<<<<<<<<<<<<<============>>>>>>>>>>>>>");
        getModelMethod();
        System.out.println("<<<<<<<<<<<<<============>>>>>>>>>>>>>");
        getModelField();
    }

    //获取class的方式
    // 所谓反射，就是java运行时动态修改，或者获取数据。
    // 动态语言，静态语言，但是反射赋予它动态能力
    // Class 也是对象，字节码，意味着拿到了一切
    public static void getModelClass()  {
        System.out.println("获取class++++++++++++++++++++++++++++");
       //方法一  通过.class获取字节码
        Class clazz1 = UserInfoModel.class;
        System.out.println("通过.class获取字节码：" + clazz1);

        //方法二  通过new对象获取
        UserInfoModel userInfoModel = new UserInfoModel();
        Class clazz2 = userInfoModel.getClass();
        System.out.println("通过new对象获取:" + clazz2);

        //方法三 通过 Class.forName获取  推荐使用
        String path = "cyl.simpledatastruc.model.UserInfoModel";

        try {
            Class clazz = Class.forName(path);
            System.out.println("通过 Class.forName获取:"+clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void getModelConstructor() {
        System.out.println("获取构造器+++++++++++++++++++++++++++++++++++");
        Class clazz = null;
        try {

            clazz =  Class.forName("cyl.simpledatastruc.model.UserInfoModel");

            //获取所有构造器  包括私有的
            Constructor[] clazzConstructors = clazz.getDeclaredConstructors();

            for (Constructor constructor : clazzConstructors) {
               // constructor.setAccessible(true);
                System.out.println(constructor.isAccessible() +":"+ constructor.getParameterCount());
            }

            //获取所有构造器  不包括私有的
            clazzConstructors = clazz.getConstructors();
            for (Constructor constructor : clazzConstructors){
                System.out.println(constructor.isAccessible() +":"+ constructor.getParameterCount());

            }

            Constructor noParameterPublicConstructor = clazz.getDeclaredConstructor();

            UserInfoModel noParameterPublicConstructorInstance = (UserInfoModel)noParameterPublicConstructor.newInstance();
            noParameterPublicConstructorInstance.setName("noParameterPublicConstructorInstance");
            System.out.println(noParameterPublicConstructorInstance.getName());


            Constructor oneParameterPrivateConstructor = clazz.getDeclaredConstructor(String.class);
            if(!oneParameterPrivateConstructor.isAccessible()) oneParameterPrivateConstructor.setAccessible(true);

            UserInfoModel  oneParameterPrivateConstructorInstance=  (UserInfoModel)oneParameterPrivateConstructor.newInstance("oneParameterPrivateConstructorInstance");

            System.out.println(oneParameterPrivateConstructorInstance.getName());


            Constructor threeParameterPublicConstructor = clazz.getDeclaredConstructor(String.class, Integer.class, String.class);
            UserInfoModel threeParameterPublicConstructorInstance= (UserInfoModel)threeParameterPublicConstructor.newInstance("threeParameterPublicConstructorInstance ", 18, "female");
            System.out.println(threeParameterPublicConstructorInstance.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    private static void getModelMethod(){
        System.out.println("获取方法++++++++++++++++++++++++++++++++++");
        Class clazz = null;
        UserInfoModel userInfoModel = new UserInfoModel();

        try {
            clazz  = Class.forName("cyl.simpledatastruc.model.UserInfoModel");
            //获取所有方法  包括私有的方法
            Method[] clazzDeclaredMethods = clazz.getDeclaredMethods();

            for (Method method : clazzDeclaredMethods){
                System.out.println(method.getName() + "中parameterCount:" + method.getParameterCount());
            }

            //获取所有方法  不包括私有的方法
            System.out.println("clazzMethods 获取所有方法  不包括私有的方法");
            Method[] clazzMethods = clazz.getMethods();
            for (Method method : clazzMethods){
                System.out.println(method.getName() + "中parameterCount:" + method.getParameterCount());
            }

            Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
            setNameMethod.invoke(userInfoModel, "setNameMethod");

            System.out.println(userInfoModel.getName());

            Method getNameMethod = clazz.getDeclaredMethod("getName");

            System.out.println(getNameMethod.getName() +":" + getNameMethod.invoke(userInfoModel));

            Method printAllFiledMethod = clazz.getDeclaredMethod("printAllFiled" );

            if(!printAllFiledMethod.isAccessible()) printAllFiledMethod.setAccessible(true);

            printAllFiledMethod.invoke(userInfoModel);

            System.out.println(userInfoModel.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static  void getModelField(){
        System.out.println("获取属性++++++++++++++++++++++++++++++++++");
        Class clazz = null;
        UserInfoModel userInfoModel = new UserInfoModel();

        try {
            clazz =  Class.forName("cyl.simpledatastruc.model.UserInfoModel");

            //获取所有属性  包括私有属性
            Field[] declaredFields = clazz.getDeclaredFields();

            for (Field field : declaredFields){
                System.out.println(field.getName() + ":" + field.getType());
            }

            Field attrField = clazz.getDeclaredField("attr");

            if (!attrField.isAccessible())  attrField.setAccessible(true);

            attrField.set(userInfoModel , "attr=aaa" );


            Field nameField = clazz.getDeclaredField("name");

            if(!nameField.isAccessible()) nameField.setAccessible(true);

            nameField.set(userInfoModel, "name-field");
            System.out.println(userInfoModel.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
