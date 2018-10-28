package com.lq.wap.web;

import com.lq.code.util.FileUtil;
import com.lq.wap.vo.UeditorVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


/**
 * 百度富文本编辑器 图片上传
 *
 */
@Controller
@RequestMapping("/ueditor")
public class UmUeditorFileController {

    @Value("${file.upload}")
    private String FILE_LOAD_PATH;


    @RequestMapping(value = "/fileupload",method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(@RequestParam("upfile") MultipartFile[] files) throws IOException {
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        UeditorVo vo = null;
        if (files!=null&&files.length>0){
            File fileDir = new File(FILE_LOAD_PATH+"images/"+sdf.format(nowTime));
            if (!fileDir.exists()){
                fileDir.mkdirs();
            }
            for (MultipartFile file:files){
                Random random = new Random();
                Integer uuid = random.nextInt(1000000000);
                String fileType = FileUtil.fileFormat(file.getOriginalFilename());
                File file1 = new File(fileDir.getPath()+"/"+uuid.toString()+"."+fileType);
                if (!file1.exists()){
                    file.transferTo(file1);
                }
                vo = new UeditorVo();
                vo.setName(file1.getName());
                vo.setSize(file.getSize());
                vo.setType("."+fileType);
                vo.setState("SUCCESS");
                vo.setUrl("images/"+sdf.format(nowTime)+"/"+file1.getName());
                vo.setOriginalName(file.getOriginalFilename());
            }

        }
        String resultStr = "{\"name\":\""+vo.getName()+"\", \"originalName\": \""+vo.getOriginalName()+"\", \"size\": "+vo.getSize()+", \"state\": \""+vo.getState()+"\", \"type\": \""+vo.getType()+"\", \"url\": \""+vo.getUrl()+"\"} ";
        return resultStr;
    }
}
