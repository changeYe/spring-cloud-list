package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/25
 */
public class StringAdd {

    /**
     * stack=2, locals=4, args_size=1
     *          0: bipush        10  // 加载
     *          2: istore_1   // 保存到本地变量1
     *          3: sipush        400 //加载
     *          6: istore_2  // 保存到本地变量2
     *          7: iload_1 // 局部变量表1 压栈
     *          8: iload_2 // 局部变量表2 压栈
     *          9: iadd
     *         10: istore_3
     *         11: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         14: iload_3
     *         15: invokevirtual #3  // 方法调用                 // Method java/io/PrintStream.println:(I)V
     *         18: return  //返回结束
     *       LineNumberTable:
     *         line 10: 0
     *         line 11: 3
     *         line 12: 7
     *         line 13: 11
     *         line 14: 18
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0      19     0  args   [Ljava/lang/String;
     *             3      16     1     a   I
     *             7      12     2     b   I
     *            11       8     3     c   I
     * @param args
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 400;
        double d = 100.01;
        User u = new User();
        int c = a+ b;
        System.out.println(c);
    }

    /**
     *  stack=1 栈深度, locals=3 局部变量表, args_size=0 参数个数
     *          0: ldc           #5                  // String Hello
     *          2: astore_0
     *          3: aload_0
     *          4: astore_1
     *          5: ldc           #6                  // String world
     *          7: astore_0
     *          8: aload_0
     *          9: areturn
     *         10: astore_2
     *         11: ldc           #6                  // String world
     *         13: astore_0
     *         14: aload_0
     *         15: areturn  //返回结束
     * @return
     */
//    public static String r(){
//        String str = "Hello";
//        try {
//            int a = 1/0;
//            return str;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            str = "world";
//        }
//        return str;
//    }

}
