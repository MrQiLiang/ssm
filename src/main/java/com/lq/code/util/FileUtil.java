package com.lq.code.util;

import com.lq.cms.emun.FileTypeEnum;

import java.io.*;

/**
 * Created by qi on 2018-1-20.
 */
public class FileUtil {

    /**
     *  读取文件内容
     * @param filePath
     * @return
     */
    public static String read(String filePath){
        StringBuffer stringBuffer=new StringBuffer();
        try {
            FileReader reader=new FileReader(filePath);
            while (reader.ready()){
                stringBuffer.append((char) reader.read());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    /**
     *  文件写入
     * @param str
     * @param filePath
     * @return
     */
    public  static boolean writer(String str,String filePath){
        boolean result=false;
        try {
            FileWriter fileWriter=new FileWriter(filePath,true);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }

    /**
     *  获取文件格式
     * @param fileName
     * @return
     */
    public static String fileFormat(String fileName){
        if (StringUtil.isNotNull(fileName)) {
            String[] strArray = fileName.split("\\.");
            return strArray[strArray.length - 1];
        }
        return null;
    }

    /**
     *  根据文件名返回文件类型
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName){
        String fileType=null;
        if (StringUtil.isNotNull(fileName)){
            String fileFormat=fileFormat(fileName);
            switch (fileFormat.toUpperCase()){
                case "BMP":
                case "JPEG":
                case "JPG":
                case "ICO":
                case "PNG":
                case "JNG":
                   fileType = FileTypeEnum.FILE_TYPE_IMAGE.getValue();break;
                case "AVI":
                case "MOV":
                case "FLV":
                case "MP4":
                case "MPG":
                    fileType = FileTypeEnum.FILE_TYPE_VIEDO.getValue();break;
                case "PDF":
                    fileType = FileTypeEnum.FILE_TYPE_PDF.getValue();break;
                default:
                    fileType = FileTypeEnum.FILE_TYPE_OTHER.getValue();break;
            }
        }

        return fileType;
    }


}
