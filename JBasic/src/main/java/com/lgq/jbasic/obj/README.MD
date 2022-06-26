## JOL工具计算Java对象的大小

JOL全称为Java Object Layout，是用来分析JVM中对象布局的工具，可以在运行时计算某个对象的大小。

官网： http://openjdk.java.net/projects/code-tools/jol/

JOL依赖：
```java
<dependency>
    <groupId>org.openjdk.jol</groupId>
    <artifactId>jol-core</artifactId>
    <version>0.10</version>
</dependency>
```