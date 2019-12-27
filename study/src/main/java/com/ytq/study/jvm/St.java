package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/22
 */
public class St {

    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };


    }
 static int a=0;
    static {
        // 静态方法块可以复制定义在它之后的类变量,但是不放访问
         i = 10;
//        System.out.println(i);
    }
    static int i = 1;
//


//    private int age ;
//    private String name;
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//

}
