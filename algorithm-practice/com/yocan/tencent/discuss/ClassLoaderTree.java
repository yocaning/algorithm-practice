package com.yocan.tencent.discuss;

/**
 * @author liuyongkang
 * 实践类加载器结构
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
