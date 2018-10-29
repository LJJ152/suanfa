package top.ljjapp.suanfa.sort;

import org.junit.jupiter.api.Test;
import top.ljjapp.suanfa.utils.SortUtil;

public class Sort {

    @Test
    public void test(){
        int [] array = new int[]{4,98,132,5,14,652,34,9,45,6};
        //1,简单排序
//        selectSort(array);
//        for(int i : array){
//            System.out.print(i + "  ");
//        }
        //2,冒泡排序
//        bubbleSort(array);
//        for(int i : array){
//            System.out.print(i + "  ");
//        }
        //3,插入排序
//        insertSort(array);
//        for(int i : array){
//            System.out.print(i + "  ");
//        }
        //4,希尔排序
        shellSort(array);
        for(int i : array){
            System.out.print(i + "  ");
        }
    }

    /**
     * 简单选择排序
     * 每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素
     * 思路：因为简单排序从头开始挨个比较，所以设置个变量存放最小（大）值位置，每次比较得到最小（大）的位置后，进行排序。如果次值有变化才进行排序。
     * 时间复杂度O(n^2)
     * @param arr
     */
    public void selectSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++){
            //每次记录最小数的位置
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            //如果顺序有变化换位置
            if (min != i) {
                SortUtil.swap(arr, min, i);
            }
        }
    }

    /**
     * 冒泡排序
     * 对相邻的元素进行两两比较，顺序相反则进行交换，这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
     * 思路：每次比较相邻的位置，把小（大）的排后（前）面，这样就实现了冒泡。给定一个标记，当有排序没有变化时说明已经排好序，直接跳出排序循环。
     * 时间复杂度O(n^2)
     * @param arr
     */
    public void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            boolean flag = true;
            //排序完，每次比较次数减1
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
     * 思路：每次取一个数（从第二个开始）然后给定个标记，将此数和之前放的数比较下，如果此数比之前的小就排序。以此为循环
     * @param arr
     */
    public void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                SortUtil.swap(arr,j,j-1);
                j--;
            }
        }
    }

    /**
     * 希尔排序
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 图示https://www.cnblogs.com/chengxiao/p/6104371.html
     * 思路：
     * @param arr
     */
    public void shellSort(int [] arr){
        //增量gap，并逐步缩小增量
        for(int gap = arr.length/2; gap>0; gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i < arr.length; i++){
                int j = i;
                while(j-gap >= 0 && arr[j] < arr[j-gap]){
                    //插入排序采用交换法
                    SortUtil.swap(arr, j, j-gap);
                    j -= gap;
                }
            }
        }
    }
}