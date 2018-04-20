package com.sery.labmon.wechat;

import com.sery.labmon.wechat.utils.HttpRequestUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.text.MessageFormat;

@Component("getAccessToken")
public class GetAccessTokenJob {
    private static Logger log = LoggerFactory.getLogger(GetAccessTokenJob.class);
    private String corpid = "wxa59b84a6fc62bbcb";
    private String secret = "Qza0O9lqMWDV5a0-q0gjPDb-EZJ5hwP6S0k5-aIxMIo";

    public void task() {

        String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={0}&corpsecret={1}";

        String accessToken = "";
        try {
            log.info("getAccessToken start.{appid=" + corpid + ",secret:" + secret + "}");
            String url = MessageFormat.format(getTokenUrl, corpid, secret);
            JSONObject jsoninfo = HttpRequestUtils.httpGet(url);
            accessToken = jsoninfo.getString("access_token");
            ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
            servletContext.setAttribute("accessToken", accessToken);
            System.out.println("accessToken为："+accessToken);
            System.out.println(jsoninfo);
        } catch (Exception e) {
            log.error("get access token exception:", e);
        }
    }
}
