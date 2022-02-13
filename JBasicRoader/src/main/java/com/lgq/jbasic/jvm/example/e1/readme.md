# JVM-Boolean

```java
public class Foo {
  static boolean boolValue;
  public static void main(String[] args) {
    boolValue = true; // 将这个true替换为2或者3，再看看打印结果
    if (boolValue) System.out.println("Hello, Java!");
    if (boolValue == true) System.out.println("Hello, JVM!");
  }
}
```
当替换为2的时候无输出
当替换为3的时候打印HelloJava及HelloJVM
猜测是因为将boolean 保存在静态域中,指定了其类型为'Z',当修改为2时取低位最后一位为0,当修改为3时取低位最后一位为1
则说明boolean的掩码处理是取低位的最后一位