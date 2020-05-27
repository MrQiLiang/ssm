package com.lq.code.util;

/**
 * @author qi
 */
public class TestUtil {

//    public static void main(String[] args) throws IOException {
//
//     //   new TestUtil().showURL();
//    //     Document document =  Jsoup.connect("https://www.oschina.net/").get();
//        //     System.out.println(document.body());
//    //    InetAddress address = InetAddress.getLocalHost();
//    //    String ip = address.getHostAddress().toLowerCase();
//    //    System.out.println(ip);
//        new HashMap<>(8);
//    }
//
//
//    public void showURL() throws IOException, IOException {
//
//        // 第一种：获取类加载的根路径   D:\git\daotie\daotie\target\classes
//        File f = new File(this.getClass().getResource("/").getPath());
//        System.out.println(f);
//
//        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  D:\git\daotie\daotie\target\classes\my
//        File f2 = new File(this.getClass().getResource("").getPath());
//        System.out.println(f2);
//
//        // 第二种：获取项目路径    D:\git\daotie\daotie
//        File directory = new File("");// 参数为空
//        String courseFile = directory.getCanonicalPath();
//        System.out.println(courseFile);
//
//
//        // 第三种：  file:/D:/git/daotie/daotie/target/classes/
//        URL xmlpath = this.getClass().getClassLoader().getResource("");
//        System.out.println(xmlpath);
//
//
//        // 第四种： D:\git\daotie\daotie
//        System.out.println(System.getProperty("user.dir"));
//         /*
//          * 结果： C:\Documents and Settings\Administrator\workspace\projectName
//          * 获取当前工程路径
//          */
//
//        // 第五种：  获取所有的类路径 包括jar包的路径
//        System.out.println(System.getProperty("java.class.path"));
//
//    }

    public static void main(String[] args) {
        int [] a = new int[78];
        int [] b= new int[79];
        int [] result = new int[99*99];
        for (int i =0;i<a.length;i++){
            int sum = 0;
            for (int j=0;i<b.length;i++){
                int aNum = a[i];
                int bNum = b[j];
                int sumNum = aNum*bNum;
                sumNum += sum;
                if (sumNum>10){
                    sum = sumNum%10;
                }else {
                    sum = 0;
                }
                result[j]= sumNum/10;
            }
        }

    }
}
