# Stream 操作

### map

map方法将对于Stream中包含的元素使用给定的转换函数进行转换操作，新生成的Stream只包含转换生成的元素。为了提高处理效率，官方已封装好了，三种变形：mapToDouble，mapToInt，mapToLong。

栗子 

```java
@Test
public void testMap(){
    Stream.of("a","b","hi").map(p -> p.toUpperCase()).forEach(System.out::println);
}
// 打印结果
// A, B, HI
```

传给map中Lambda表达式，接受了String类型的参数，返回值也是String类型，在转换行数中，将字母全部改为大写,map传入的Lambda表达式必须是Function实例，参数可以为任意类型，而其返回值也是任性类型，javac会根据实际情景自行推断。

### flatmap

flatMap方法与map方法类似，都是将原Stream中的每一个元素通过转换函数转换，不同的是，该换转函数的对象是一个Stream，也不会再创建一个新的Stream，而是将原Stream的元素取代为转换的Stream。

如果转换函数生产的Stream为null，应由空Stream取代。

flatMap有三个对于原始类型的变种方法，分别是：flatMapToInt，flatMapToLong和flatMapToDouble。

```java
@Test
public void testFlatMap() {
    Stream.of(1,2,3).flatMap(p -> Stream.of(p  * 10)).forEach(System.out::println);
}
// 打印结果
// 10，20，30
```

- 传给flatMap中的表达式接受了一个Integer类型的参数，通过转换函数，将原元素乘以10后，生成一个只有该元素的流，该流取代原流中的元素。
- flatMap传入的Lambda表达式必须是Function实例，参数可以为任意类型，而其返回值类型必须是一个Stream。 

### peek

peek方法生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数，并且消费函数优先执行。

栗子

```java
@Test
public void testPeek() {
    Stream.of(1, 2, 3).peek(p -> System.out.println("accept:" + p)).forEach(System.out::println);
}

// 打印结果
// peek:1
//  1
//  peek:2
//  2
//  peek:3
//  3
//  peek:4
//  4
```
