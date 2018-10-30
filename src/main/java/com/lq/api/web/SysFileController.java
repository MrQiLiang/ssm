package com.lq.api.web;

import com.lq.api.service.SysFileService;
import com.lq.cms.emun.StatusTypeEnum;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.FileUtil;
import com.lq.entity.SysFile;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/file")
public class SysFileController {


    @Value("${file.upload}")
    private String FILE_LOAD_PATH;
    @Autowired
    private SysFileService sysFileService;


    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("files")MultipartFile[] files) throws IOException {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg("上传成功");
        Date nowTime = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        File fileDir = new File(FILE_LOAD_PATH+sdf.format(nowTime));
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        List<SysFile> sysFileList = new ArrayList<>();
        for (MultipartFile multipartFile:files){
            String originalFileName = multipartFile.getOriginalFilename();
            Path path = FileSystems.getDefault().getPath(FILE_LOAD_PATH+sdf.format(nowTime),originalFileName);
            //上传文件
            multipartFile.transferTo(path);
            //保存文件信息
            SysFile sysFile = new SysFile();
            sysFile.setCreateTime(nowTime);
            String fileType = FileUtil.getFileType(originalFileName);
            sysFile.setFileType(fileType);
            sysFile.setFileName(originalFileName);
            sysFile.setPath(sdf.format(nowTime)+"/"+originalFileName);
            sysFile.setStatus(StatusTypeEnum.STATUS_ACTIVITY_YES.getValue());
            sysFileService.save(sysFile);
            sysFileList.add(sysFile);
        }
        ajaxResult.setData(sysFileList);
        return ajaxResult;
    }




}
