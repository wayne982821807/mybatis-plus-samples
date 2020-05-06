package com.baomidou.mybatisplus.samples.wrapper;

import com.github.botaruibo.xvcode.generator.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wangyz
 * @date: 2020/4/26 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XVodeTest {
    private static final ReentrantLock LOCK=new ReentrantLock(true);
    @Test
    public void test1()throws IOException {
        String path = "D:/";//图片存储路径 path for image save
        Integer height = 40;//image 高度。  image height. count as pixel
        Integer width = 200;//image 宽度。 image width. count as pixel
        Integer count = 5;	// validation code length.
        String validCode = null; //验证码
        Generator generator = new PngVCGenerator(width, height, count);
        generator.write2out(new FileOutputStream(path + "/1.png")).close();
        validCode = generator.text(); //get the validation code as 'String'
        System.out.println(validCode);
        generator = new GifVCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream(path + "/1.gif")).close();
        validCode = generator.text();
        System.out.println(validCode);
        generator = new Gif2VCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream(path + "/2.gif")).close();
        validCode = generator.text();
        System.out.println(validCode);
        generator = new Gif3VCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream(path + "/3.gif")).close();
        validCode = generator.text();
        System.out.println(validCode);
    }

    @Test
    public void test2() {
        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put("a", "aa");
        table.put("b", "bb");
        table.put("c", "cc");
        table.remove("c");
        Iterator<Map.Entry<String, String>> iterator = table.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
            //采用iterator直接进行修改 程序正常
            iterator.remove();

            //直接从hashtable增删数据就会报错
            table.put("d", "dd");

            //直接从hashtable增删数据就会报错，hashtable，hashmap等非并发集合，如果在迭代过程中增减了数据，就是快速失败
            table.remove("c");

        }
    }
    @Test
    public void test3() {
        LOCK.lock();
        int i=0;
        try {
            while (!LOCK.tryLock()){
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println(i++);
            }
            System.out.println("答应中...");

        } catch (InterruptedException e) {
            e.printStackTrace(); //当前线程被中断时(interrupt)，会抛InterruptedException
        }
        finally {
            LOCK.unlock();
        }

    }


}