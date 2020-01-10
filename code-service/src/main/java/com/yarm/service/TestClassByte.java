package com.yarm.service;

/**
 * @program: base-parent
 * @description: 测试
 * @author: yarm.yang
 * @create: 2020-01-09 17:32
 */
public class TestClassByte {

    private static native void registerNatives();

    static {

    }

     public String testSync(){
         String out = new String();
//         synchronized (this){
//             System.out.println("ok");
//             String in = new String();
//         }
         new Throwable();
         return out;
    }

    public static void main(String[] args) {
        registerNatives();
         TestClassByte testClassByte = new TestClassByte();
        int nativeHashCode = testClassByte.getNativeHashCode();
        int nativeHashCode2 = testClassByte.getNativeHashCode();
        System.out.println(nativeHashCode);
        System.out.println(nativeHashCode2);
        int i = testClassByte.hashCode();
        System.out.println(i);

    }

    private int getNativeHashCode(){
         Object o = new Object();
        int i = o.hashCode();
        return i;
    }
    public native int  hashCode();



}
