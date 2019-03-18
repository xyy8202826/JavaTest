package com.xyy.sorting;

/**
 * 冒泡排序
 * 时间复杂度：O(n2)
 * 稳定排序
 * @author XYY
 * @version Id: BubbleSortTest.java, v 0.1 2018/12/12 15:13 xuyuanye Exp $$
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] array={1,2,3,9,9};
        dubbleSort(array);
        for(int i=0;i<array.length-1;i++){
            System.out.println(array[i]);
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void dubbleSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            boolean isSorted =true;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
