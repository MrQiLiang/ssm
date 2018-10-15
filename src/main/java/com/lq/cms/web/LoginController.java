package com.lq.cms.web;

import com.lq.cms.service.SysUserService;
import com.lq.code.entity.AjaxResult;
import com.lq.code.util.DataValidatorUtil;
import com.lq.code.util.DateUtil;
import com.lq.code.util.StringUtil;
import com.lq.code.web.BaseController;
import com.lq.entity.SysUser;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**管理后台登陆页
 * Created by qi on 2017/7/16.
 */
@Controller
@RequestMapping("/cms/login")
public class LoginController extends BaseController{

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private SysUserService sysUserService;
//    @Autowired
//    private MailService mailService;

    @RequestMapping(value = {"/index",""})
    public String toLogin(){

        return "cms/login";
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public Object doLogin(String loginName, String password, HttpSession session,String authCode){
        AjaxResult ajaxResult= this.getAjaxResult();
        String strCode=(String) session.getAttribute("strCode");
        session.setAttribute("strCode",null);
        if (StringUtil.isNotNull(strCode)&&StringUtil.isNotNull(authCode)){
            if(!authCode.equals(strCode)){
                ajaxResult.setMsg("验证码错误");
                ajaxResult.setSuccess(false);
                return ajaxResult;
            }
        }

        //判断用户是输入邮箱或者登录名
        if (DataValidatorUtil.isEmail(loginName)){
            SysUser sysUser = sysUserService.findByEmail(loginName);
            if (sysUser!=null) {
                loginName = sysUser.getLoginName();
            }
        }

        Subject subject=SecurityUtils.getSubject();
       // UsernamePasswordToken token=new UsernamePasswordToken(loginName,password.toCharArray());
        UsernamePasswordToken token=new UsernamePasswordToken(loginName,password,true);
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            ajaxResult.setMsg("账号或密码错误");
            ajaxResult.setSuccess(false);
        }
        return  ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/sendEmail")
    public Object sendEmail(String email){
        AjaxResult ajaxResult = this.getAjaxResult();
//        try {
////            mailService.sendMail("qi_liang_gz@163.com",email,"忘记密码","重新设置网址为<a href=\"#\">http://www.baidu.com</a>");
//        } catch (AddressException e) {
//            e.printStackTrace();
//        }
        //   mailService.sendMail("qi_liang_gz@163.com","565391376@qq.com","系统统计报告","内容待定");

        return ajaxResult;
    }

    /**
     *  无权访问页面
     * @param
     * @return
     */
    @RequestMapping("unauthorizedUrl")
    public String unauthorizedUrl(){

        return "error/unauthorizedUrl";
    }

    /**
     *  生成图片验证码
     */
    @RequestMapping("authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)throws IOException{
        int width=63;
        int height=37;
        Random random=new Random();
        //设置response头部信息
        //禁止缓存
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expores",0);
        //生成缓冲图片的image类
        BufferedImage image=new BufferedImage(width,height,1);
        //产生image类的graphices用于绘制操作
        Graphics g=image.getGraphics();
        //Graphice类的样式
        g.setColor(getRandColor(200,250));
        g.setFont(new Font("Times new Roman",0,28));
        g.fillRect(0,0,width,height);
        //绘制干扰线
        for (int i=0;i<40;i++){
            g.setColor(getRandColor(130,200));
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            g.drawLine(x,y,x+x1,y+y1);
        }
        //绘制字符
        String strCode="";
        for (int i=0;i<4;i++){
            String rand=String.valueOf(random.nextInt(10));
            strCode=strCode+rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,28);
        }
        //将字符保存的session中用于前端的验证
        session.setAttribute("strCode",strCode);
        g.dispose();

        ImageIO.write(image,"JPEG",response.getOutputStream());
        //清理输出流中的缓冲
        response.getOutputStream().flush();
    }

    //创建颜色
    private Color getRandColor(int fc,int bc){
        Random random=new Random();
        if(fc>255){
            fc=255;
        }
        if (bc>255){
            bc=255;
        }
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }



    /**
     *  退出登陆
     * @param modelAndView
     * @return
     */
//    @RequestMapping("loginOut")
//    public String loginOut(){
//        Subject subject=SecurityUtils.getSubject();
//        SysUser sysUser= (SysUser) subject.getPrincipal();
//        if (sysUser!=null){
//            subject.logout();
//        }
//        Session session1=subject.getSession();
//        System.out.println("session状态：");
//        System.out.println(session1.getId()+":"+ DateUtil.getDateToStr(session1.getStartTimestamp()));
//        return "cms/login";
//    }




}
