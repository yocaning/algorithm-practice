package com.yocan.tencent.discuss;

/**
 * @author liuyongkang
 * 实践类加载器结构
 * 类加载器是双亲委派模型，loadClass方法会先由父类加载器去处理
 * 一般来说，自己开发的类加载器只需要覆写 findClass(String name)方法即可。
 * java.lang.ClassLoader类的方法 loadClass()封装了前面提到的代理模式的实现。
 * 该方法会首先调用 findLoadedClass()方法来检查该类是否已经被加载过；
 * 如果没有加载过的话，会调用父类加载器的 loadClass()方法来尝试加载该类；
 * 如果父类加载器无法加载该类的话，就调用 findClass()方法来查找该类。
 * 因此，为了保证类加载器都正确实现代理模式，在开发自己的类加载器时，最好不要覆写 loadClass()方法，而是覆写 findClass()方法。
 *
 * 类加载器会首先代理给其它类加载器来尝试加载某个类。
 * 这就意味着真正完成类的加载工作的类加载器和启动这个加载过程的类加载器，有可能不是同一个。
 * 真正完成类的加载工作是通过调用 defineClass来实现的；而启动类的加载过程是通过调用 loadClass来实现的。
 * 前者称为一个类的定义加载器（defining loader），后者称为初始加载器（initiating loader）。
 * 在 Java 虚拟机判断两个类是否相同的时候，使用的是类的定义加载器。
 * 也就是说，哪个类加载器启动类的加载过程并不重要，重要的是最终定义这个类的加载器。
 * 两种类加载器的关联之处在于：一个类的定义加载器是它引用的其它类的初始加载器。
 * 如类 com.example.Outer引用了类 com.example.Inner，
 * 则由类 com.example.Outer的定义加载器负责启动类 com.example.Inner的加载过程。
 *
 *
 * 如果自己写了两个类加载器，分别去加载同一个类，加载出来的会是两个不同的类
 * 这是因为⬇️
 * Java 虚拟机是如何判定两个 Java 类是相同的。
 * Java 虚拟机不仅要看类的全名是否相同，还要看加载此类的类加载器是否一样。
 * 只有两者都相同的情况，才认为两个类是相同的。即便是同样的字节代码，被不同的类加载器加载之后所得到的类，也是不同的
 */
public class ClassLoaderTree {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}

