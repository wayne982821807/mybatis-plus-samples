package com.baomidou.mybatisplus.samples.wrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 算法相关代码
 * @author: wangyz
 * @date: 2020/4/21 11:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmTest {
    @Test
    public void  swordToOffer1(){
        int a = 2;
        int b = a++ << ++a + ++a;
        System.out.println(b);
        System.out.println(2<<4+5);

    }



    //测试 try catch finally return

    public static  int testtrycatchreturn(int i){
        try {
            throw new Exception("exception");
        }catch (Exception e){
            System.out.println("catch...");
            return i;
        }
        finally {
            System.out.println("finally...");
            i++;
            return i;

        }
    }
    public static  int testTryCatchReturn2(int i){
        try {
            throw new Exception("Exception");
        }catch (Exception e){
            System.out.println("catch...");
            return i;
        }
        finally {
            System.out.println("finally...");
            i++;
//            return i;

        }
    }

    public boolean Find(int target, int [][] array) {
        //用rowCount、colCount分别代表数组的行数和列数
        int rowCount = array.length;
        int colCount = array[0].length;
        /*判断是否比数组最小的值小，或者比最大的值大，这样在数组很大时可以提高效率。
          数组长度为0也是合法的，所以为了避免越界加上列长为0的判断*/
        if(colCount == 0 || target < array[0][0] || target > array[rowCount-1][colCount-1]){
            return false;
        }
        //当row大等于0且col小于列长colCount时，查找数组中是否有target
        for(int row = rowCount-1, col = 0; row >= 0 && col < colCount;){
            if(target == array[row][col]){
                return true;
            }else if(target < array[row][col]){
                row--;
            }else if(target > array[row][col]){
                col++;
            }
        }
        return false;
    }

    /**
     * do-while
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int [][] array) {
        //用rowCount、colCount分别代表数组的行数和列数
        int rowCount = array.length;
        int colCount = array[0].length;
        if (colCount==0||target>array[rowCount-1][colCount-1]||target<array[0][0])
            return false;
        int row=0;
        int col=colCount-1;
        do{
            if (array[row][col]==target) {
                return true;
            }
            else if (array[row][col]<target) {
                row++;
            }
            else {
                col--;
            }
        }
        while (row<=rowCount-1&&col>=0);
        return false;

    }

    /**
     * while
     * @param target
     * @param array
     * @return
     */
    public boolean Find3(int target, int [][] array) {
        //用rowCount、colCount分别代表数组的行数和列数
        int rowCount = array.length;
        int colCount = array[0].length;
        if (colCount==0||target>array[rowCount-1][colCount-1]||target<array[0][0])
            return false;
        for (int row=0;row<rowCount;row++){
            for (int col=0;col<colCount;col++){
                if (target==array[row][col])
                    return true;
            }
        }
        return false;



    }

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        return str.toString().replaceAll("","%20");

    }

}