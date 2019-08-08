package cn.bk998.arithmetic;


import java.util.Arrays;
import java.util.Random;

/**
 * @author XY
 * @DESCRIPTION
 * @create 2019/8/7
 */
public class Arithmetic {

    public static void main(String[] args) {
        int[] num;
        Arithmetic arithmetic = new Arithmetic();
        num = getInts();
        System.out.println(Arrays.toString(num));
        long start = System.currentTimeMillis();
        int[] bubbling = arithmetic.bubbling(num);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbling));
        System.out.println("冒泡耗时：" + (end - start));
        System.out.println("-----------------------------");
        num = getInts();
        System.out.println(Arrays.toString(num));
        start = System.currentTimeMillis();
        int[] select = arithmetic.select(num);
        end = System.currentTimeMillis();
        System.out.println(Arrays.toString(select));
        System.out.println("选择耗时：" + (end - start));
        System.out.println("-----------------------------");
        num = getInts();
        System.out.println(Arrays.toString(num));
        start = System.currentTimeMillis();
        int[] insert = arithmetic.insert(num);
        end = System.currentTimeMillis();
        System.out.println(Arrays.toString(insert));
        System.out.println("插入耗时：" + (end - start));
    }

    private static int[] getInts() {
        int x = 10000;
        Random random = new Random();
        int[] num = new int[x];
        for (int i = 0; i < x; i++) {
            num[i] = random.nextInt(x);
        }
        //int[] num = {5,5,6,9,8,1,2,3,4,8,7,6,8,11,10,12,15,16,18,19,17,11,2,12};
        return num;
    }

    /**
     * 冒泡算法
     *
     * @param arr
     * @return
     */
    public int[] bubbling(int[] arr) {
        int[] num = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        for (int i = 0; i < num.length; i++) {
            flag = true;
            for (int x = 0; x < num.length - i - 1; x++) {
                if (num[x] > num[x + 1]) {
                    num[x] = num[x] ^ num[x + 1];
                    num[x + 1] = num[x] ^ num[x + 1];
                    num[x] = num[x] ^ num[x + 1];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }
        return num;
    }

    /**
     * 选择算法
     *
     * @param arr
     * @return
     */
    public int[] select(int[] arr) {
        int[] num = Arrays.copyOf(arr, arr.length);

        int min;
        for (int i = 0; i < num.length; i++) {
            min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[min]) {
                    min = j;
                }
            }
            if (num[i] != num[min]) {
                num[i] = num[i] ^ num[min];
                num[min] = num[i] ^ num[min];
                num[i] = num[i] ^ num[min];
            }

        }


        return num;
    }

    /**
     * 插入算法
     *
     * @param arr
     * @return
     */
    public int[] insert(int[] arr) {
        int[] num = Arrays.copyOf(arr, arr.length);
        int temp, j;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];
            j = i;
            while (j > 0 && temp < num[j - 1]) {
                num[j] = num[j - 1];
                j--;
            }
            if (j != i) {
                num[j] = temp;
            }
        }
        return num;
    }


}
