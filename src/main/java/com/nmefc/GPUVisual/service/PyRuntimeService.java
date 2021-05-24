package com.nmefc.GPUVisual.service;

import com.nmefc.GPUVisual.entity.MLResultData;
import com.nmefc.GPUVisual.entity.ResponseInfo;
import com.nmefc.GPUVisual.entity.Result;

public interface PyRuntimeService {
    /**
     *@Description:通过Runtime.getRuntime()开启进程来执行脚本文件
     *@Param: []
     *@Return: int
     *@Author: QuYuan
     *@Date: 2021/5/23 22:12
     */
    int runPythonProcess();
}
