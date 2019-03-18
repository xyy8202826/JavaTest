package com.xyy.sorting;

/**
 * 插入排序
 * 时间复杂度：
 * 稳定排序
 * @author XYY
 * @version Id: InsertionSortTest.java, v 0.1 2018/12/12 15:13 xuyuanye Exp $$
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        int[] array={5,3,4,6,1};
        insertionSort(array);
        for(int i=0;i<array.length-1;i++){
            System.out.println(array[i]);
        }
    }

    /**
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        for(int index = 1; index<array.length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftIndex = index-1;
            while(leftIndex>=0 && array[leftIndex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftIndex+1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex+1] = temp;//把temp放到空位上
        }
    }
}
