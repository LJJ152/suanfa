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
//        shellSort(array);
//        for(int i : array){
//            System.out.print(i + "  ");
//        }
        //5,堆排序
        heapSort(array);
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

    /**
     * 堆排序
     * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
     * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     * 思路：a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
     * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     * @param arr
     */
    public void heapSort(int [] arr){
        //1.构建大顶堆
        for(int i = arr.length / 2-1; i >= 0; i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length-1; j > 0; j--){
            SortUtil.swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    public void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k = i*2+1; k < length; k = k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < length && arr[k] < arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
}