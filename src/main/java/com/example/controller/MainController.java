package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Student;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller   //直接添加注解即可
@RequestMapping("/tmp/")
public class MainController {

    @RequestMapping({"/test111", "/main/*", "/xxx"})   //直接填写访问路径
    public ModelAndView index(HttpSession session){
        session.setAttribute("login", true); // 假设访问这个接口就认为是登录了
        ModelAndView modelAndView = new ModelAndView("index");//返回ModelAndView对象，这里填入了视图的名称
        System.out.println("我是处理controller");
        modelAndView.getModel().put("name", "aaaaaaa");
        return modelAndView; //返回后会经过视图解析器进行处理
    }

    @RequestMapping({"/home"})   //直接填写访问路径
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");//返回ModelAndView对象，这里填入了视图的名称
        System.out.println("我是处理home controller");
        modelAndView.getModel().put("name", "aaaaaaa");
        if(true) throw new RuntimeException("您的氪金力度不足，无法访问！");
        return modelAndView; //返回后会经过视图解析器进行处理
    }

    @RequestMapping(value = "/data", produces = "application/json")
    @ResponseBody
    public Student data() {
        Student student = new Student();
        student.setName("杰哥");
        student.setAge(18);
        return student;
    }


    @RequestMapping(value = "/data2", produces = "application/json")
    @ResponseBody
    public String data2(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "xxxx");
        jsonObject.put("age", 18);
        return jsonObject.toJSONString();

    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String upload(@RequestParam CommonsMultipartFile file) throws IOException {
        File fileObj = new File("test.docx");
        file.transferTo(fileObj);
        System.out.println("用户上传的文件已保存到："+fileObj.getAbsolutePath());
        return "文件上传成功！";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public void download(HttpServletResponse response){
        response.setContentType("multipart/form-data");
        try(OutputStream stream = response.getOutputStream();
            InputStream inputStream = new FileInputStream("test.docx")){
            IOUtils.copy(inputStream, stream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces = "text/html;charset=utf-8") //这里要设置一下produces不然会乱码
    @ResponseBody
    public String pay(String account,
                      int amount,
                      @SessionAttribute("login") Boolean isLogin){
        if (isLogin) return "成功转账 ￥"+amount+" 给："+account;
        else return "转账失败，您没有登陆！";
    }

}