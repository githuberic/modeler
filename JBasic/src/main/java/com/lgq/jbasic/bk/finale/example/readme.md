# final

## 概述

final可以修饰变量、方法和类，用于表示修饰的内容一旦赋值之后就不会再改变了。例如我们熟悉的final类型的类String，一旦赋值之后，就无法再改变了。

### final的具体应用场景

#### final成员变量
- 首先每个类中的变量又可以分为类变量(static)以及实例变量。
- final变量必须要进行初始化，它不会自动初始化
- 类变量又两个赋值时机，实例变量则有三个赋值时机。分别如下：
  - 类变量
    - 静态代码块
    - 直接赋值
  - 实例变量
    - 非静态代码块
    - 构造函数
    - 直接赋初值

```java
public class FinalBasic {
    private final int x = 6;
    private final String str;
    private final static boolean b;
    private final double d;
    private final char ch;

    // 静态代码为静态变量赋值
    static {
        b = false;
    }

    // 非静态代码为实例变量赋值
    {
        d = 1.891;
    }

    // 在构造函数中赋值
    public FinalBasic() {
        str = "lgq";
        // 赋值后不能再次修改
        str = "lyy";
    }

    // 不能再实例方法中进行赋值
    public void temp() {
        ch = 'a';
    }
}
```

#### final局部变量

如果想要在成员方法中使用final局部变量，需要注意的地方是：如果没有进行初始化就必须初始化。并且只能进行一次初始化。

```java
  public void tempMethod(final int x){
      final int y = 1;
      // 再次赋值会报错
      x = 3;
  }
```

#### final基本数据类型 VS final引用数据类型

基本数据类型如果被定义为final，那么是无法修改的。

但是如果是引用数据类型，因为对象存储的是内存地址，它只能保证内存地址不会发生改变，但是不能保证其中的值不能改变。

```java
    private final static Person person = new Person("lisi", 20);

    public static void main(String[] args) {
        person.age = 25;
        System.out.println(person.toString());
    }

    static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
```

### 多线程下final

#### 写final域重排序规则
- 写final域重排序规则：禁止对final域的写重排序到构造方法之外，这个规则主要包括下面两个含义
  - JMM禁止编译器将final域的写重排序到构造方法之外。
  - 编译器会在fianl域写之后，构造方法的return语句之前插入一个storestore屏障。这个屏障可以防止对于final域的写在构造方法之外。
- 下面是程序执行的可能的一种时序图：因为变量b被修饰为final，因此不会被重排序到构造方法之外，保证了reader能够读到正确的值。但是没有被final修饰的普通域a则有可能被重排序到构造方法之外，这样可能会导致reader无法读取到正确的值。

```java
public class MThreadFinal {
    private int x;
    private final int y;
    private static MThreadFinal mThreadFinal;

    public MThreadFinal() {
        this.x = 1;
        this.y = 2;
    }

    public static void writer() {
        mThreadFinal = new MThreadFinal();
    }

    public static void reader() {
        MThreadFinal temp = mThreadFinal;
        int x1 = temp.x;
        int y1 = temp.y;
    }

    public static void main(String[] args) {
        Thread thd1 = new Thread(() -> reader());

        Thread thd2 = new Thread(() -> writer());

        thd1.start();
        thd2.start();
    }
}
```

#### 读final域重排序规则

- 读final域的重排序规则为：在一个线程中，初次读取对象引用和初次读取该对象包含的final域，JMM会禁止这两个的重排序操作。 处理器会在这两个操作前面插上LoadLoad内存屏障。
- reader方法，读取普通域a并没有限制重排序，所以可能会重排序到写普通域a之前，这样就会出现错误。而final域b会插入LoadLoad内存屏障，这样保证了可以读到对象的引用。
- 读final域的重排序规则可以确保：在读一个对象的final域之前，一定要先读取这个对象的引用。

### final域重排序规则的总结
- 基本数据类型
  - final域写：禁止在构造方法中的final域写被重排序到构造方法之外;
  - final域读：禁止初次读对象的引用域读取该对象的final域的重排序;
- 引用数据类型
  - 在上面两个规则的基础上增加的规则：禁止在构造函数中对于final域的成员变量的写与在构造方法之外的对象的引用赋值给引用变量进行重排序。

用final关键字修饰变量，保证变量初始化后的结果不被修改，这样就可以保证线程安全，防止多线程对于变量进行修改，保证线程数据处理的安全性。

#### Final在并发中的原理

禁止cpu指令集重新排序,来保证对象的安全发布,防止对象引用被其他线程在对象被完全构造完成前拿到并使用.
