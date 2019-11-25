package com.ytq.study.jvm;

/**
 * @author yuantongqin
 * 2019/11/25
 */
public class StringAdd {

    public static void main(String[] args) {
        System.out.println(r());
    }

    /**
     *  stack=1, locals=3, args_size=0
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
     *         15: areturn
     * @return
     */
    public static String r(){
        String str = "Hello";
        try {
            int a = 1/0;
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            str = "world";
        }
        return str;
    }

}
