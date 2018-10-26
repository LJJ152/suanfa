package top.ljjapp.suanfa.utils;

public class SortUtil {

    /**
     * 交换数组元素，按照位置进行交换
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int [] arr, int a, int b){
        //利用异或进行交换
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}