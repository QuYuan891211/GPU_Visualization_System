package com.nmefc.GPUVisual.service.imp;

import com.nmefc.GPUVisual.entity.MLResultData;
import com.nmefc.GPUVisual.entity.ResponseInfo;
import com.nmefc.GPUVisual.entity.Result;
import com.nmefc.GPUVisual.service.PyRuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@RunWith(SpringRunner.class)
@Service("pyRuntimeService")
public class PyRuntimeServiceImp implements PyRuntimeService{

    @Override
    public int runPythonProcess() {
        Process process;
        int resultCode = 1;
        try{
            process = Runtime.getRuntime().exec("python E:\\projects\\IDEA\\GPUVisualization\\test\\testMatrix.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();
            resultCode = process.waitFor();
            System.out.println("result: " + resultCode);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultCode;
    }
}
