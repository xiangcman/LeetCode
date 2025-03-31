package com.xc.leetcode.array;

public class TestArrayCopy {
    public static void main(String[] args) {
        int index =0;
        int[] array = new int[]{1,2,3};
        int count = array.length;
        int[] newArray = array;
        System.out.println("array.hashCode() = " + array.hashCode());
        System.out.println("newArray.hashCode() = " + newArray.hashCode());
        //System.arraycopy不会创建新的数据，newArray的地址不会变
        System.arraycopy(newArray,index+1,newArray,index,count-index-1);
        //Arrays.copyOf其实也是调用的System.arraycopy，像ArrayList.toArray就是通过Arrays.copyOf实现的
        for (int i : newArray) {
            System.out.println("i = " + i);
        }
        System.out.println("newArray.hashCode() = " + newArray.hashCode());

    }
}
