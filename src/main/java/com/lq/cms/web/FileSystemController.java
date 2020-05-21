package com.lq.cms.web;

import com.lq.code.entity.AjaxResult;
import com.lq.code.util.DateUtil;
import com.lq.code.web.BaseController;
import com.lq.entity.SysFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *  @author qi
 *  文件系统控制类
 */

@Controller
@RequestMapping("/cms/file")
public class FileSystemController extends BaseController{

    public static final Logger LOGGER = LoggerFactory.getLogger(FileSystemController.class);

    public static final String UPLOAD_FILE_PATH="/Users/qi_liang/java/fileManger";

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(@RequestParam("files")MultipartFile[] files, HttpServletRequest request) throws IOException {
        AjaxResult ajaxResult = AjaxResult.getSuccessInstance();
        Date nowTime=new Date();
        if (files!=null&&files.length>0){
            for (MultipartFile file:files){
                if (!file.isEmpty()){
                    SysFile sysFile=new SysFile();
                    String fileName = file.getOriginalFilename();
                    String nowTimeStr = DateUtil.getDateToStr(nowTime,"yyyyMMdd");
                    File filePath = new File(UPLOAD_FILE_PATH+File.separator+nowTimeStr,fileName);
                    //判断路径是否存在，如果不存在就创建一个
                    if (!filePath.getParentFile().exists()){
                        filePath.getParentFile().mkdirs();
                    }
                    file.transferTo(new File(UPLOAD_FILE_PATH+File.separator+nowTimeStr+File.separator+fileName));
                    sysFile.setFileName(fileName);
                    sysFile.setCreateTime(nowTime);
                    sysFile.setPath(nowTimeStr+File.separator+fileName);
                    sysFile.setFileType("image");
//                    sysFileService.save(sysFile);
                }
            }
        }

        return  ajaxResult;
    }


}
