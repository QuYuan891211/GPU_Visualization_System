package com.nmefc.GPUVisual.service.imp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process proc;
        try {
//            String[] arg = new String[]{}
            proc = Runtime.getRuntime().exec("python E:\\projects\\IDEA\\GPUVisualization\\test\\testMatrix.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int code = proc.waitFor();
            System.out.println(code);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
