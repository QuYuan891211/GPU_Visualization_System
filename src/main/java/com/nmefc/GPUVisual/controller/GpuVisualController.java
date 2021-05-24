package com.nmefc.GPUVisual.controller;

import com.nmefc.GPUVisual.entity.MLResultData;
import com.nmefc.GPUVisual.entity.Result;
import com.nmefc.GPUVisual.enums.ResultCodeEnum;
import com.nmefc.GPUVisual.enums.ResultMsgEnum;
import com.nmefc.GPUVisual.service.PyRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders ="*" )
@RestController
@RequestMapping(value = "/gpu")
public class GpuVisualController {
    @Autowired
    private PyRuntimeService pyRuntimeService;
    /**
     *@Description: （1）启动机器学习python程序
     *@Param: []
     *@Return: com.nmefc.GPUVisual.entity.Result<com.nmefc.GPUVisual.entity.MLResultData>
     *@Author: QuYuan
     *@Date: 2021/5/24 10:46
     */
    @GetMapping(value = "/start")
    public Result<MLResultData> startML(){
        Result<MLResultData> result = new Result<MLResultData>();
        //先不加返回值判断
        if(0 == pyRuntimeService.runPythonProcess()){
            result.setMessage(ResultMsgEnum.SUCCESS.getMsg());
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
        }else {

            result.setMessage(ResultMsgEnum.FAIL.getMsg());
            result.setCode(ResultCodeEnum.FAIL.getCode());
        }

//        List<MLResultData> resultDataList = new ArrayList<>();
//        resultDataList.add(resultData);
//        result.setData(textDataList);
        return result;

    }
}
