package com.lq.api.web;

import com.lq.code.entity.AjaxResult;
import com.lq.code.util.FileUtil;
import com.lq.entity.SysFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
@RequestMapping("/file")
public class SysFileController {


    @Value("${file.upload}")
    private String FILE_LOAD_PATH;


    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("files")MultipartFile[] files){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg("上传成功");
        Date nowTime = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        File fileDir = new File(FILE_LOAD_PATH+sdf.format(nowTime));
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        for (MultipartFile multipartFile:files){
            SysFile sysFile = new SysFile();
            sysFile.setCreateTime(nowTime);
            String fileType = FileUtil.getFileType(multipartFile.getName());
            sysFile.setFileType(fileType);
            sysFile.setFileName(multipartFile.getName());

        }
        return ajaxResult;
    }
}
