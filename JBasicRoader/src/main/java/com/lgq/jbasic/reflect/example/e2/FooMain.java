package com.lgq.jbasic.reflect.example.e2;

/**
 * Created by eric on 2019/11/10.
 *
 * @author lgq
 */
public class FooMain {

    public static void main(String[] args) {
        Foo foo = new Foo();

        // 第一种表示方式--->任何一个类都有一个隐含的静态成员变量class
        Class fooV1 = Foo.class;
        // 第二种表示方式--->已经知道该类的对象通过getClass方法
        Class fooV2 = foo.getClass();

        // 第三种表达方式--->通过Class.forName方法动态加载类
        Class fooV3 = null;
        try {
            fooV3 = Class.forName("com.lgq.jbasic.reflect.example.e2.Foo");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // 官网 fooV1 ,fooV2 表示了Foo类的类 类型(class type)
        // 万事万物皆对象， 类也是对象，是Class类的实例对象

        // fooV1 or fooV2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(fooV1.equals(fooV2));
        System.out.println(fooV2.equals(fooV3));
        System.out.println(fooV1 == fooV2);
        System.out.println(fooV2 == fooV3);

        //通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Foo的实例对象
        try {
            Foo fooNew = (Foo) fooV1.newInstance();
            fooNew.print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
