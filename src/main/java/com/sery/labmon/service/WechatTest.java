package com.sery.labmon.service;

import com.sery.labmon.wechat.WechatHelper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.util.Date;

@Component("testQuartz")
public class WechatTest {

   /* public void run(){
        Date date = new Date();
        System.out.println(date+"每五秒执行一次run方法！");
    }*/
   public boolean run() {
       String msg;
       msg = "您好，实验室液氮罐组的状态出现异常，请及时处理！";
       StringBuffer sb = new StringBuffer();
       sb.append("{ 'totag': '1','msgtype': 'text', 'agentid': 1000003, 'text': {'content': '" + msg + "'}}");
       JSONObject jsonParam = JSONObject.fromObject(sb.toString());
       WechatHelper wechatHelper = new WechatHelper();
       ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
       String accessToken = (String) servletContext.getAttribute("accessToken");
       wechatHelper.sendCorpMsg(accessToken, jsonParam);
       System.out.println(accessToken+"+++++++++"+jsonParam);
       return true;
   }
}
