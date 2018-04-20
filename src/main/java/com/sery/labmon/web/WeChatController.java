package com.sery.labmon.web;

import com.sery.labmon.wechat.WechatHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WeChatController {

    WechatHelper wechatHelper;

    WeChatController() {
        this.wechatHelper = new WechatHelper();
        wechatHelper.setToken("labmon");
        wechatHelper.setCorpid("wxa59b84a6fc62bbcb");
        wechatHelper.setAgentid(1000003);
        wechatHelper.setsEncodingAESKey("MxjP8PGDbfOp4kSdIxTzCNnp3aWcr1lctPcSM5qCnNY");
    }

    @RequestMapping(value = "wechat", method = RequestMethod.GET)
    public String joinUp(HttpServletRequest request) {
        String sVerifyMsgSig = request.getParameter("msg_signature");
        String sVerifyTimeStamp = request.getParameter("timestamp");
        String sVerifyNonce = request.getParameter("nonce");
        String sVerifyEchoStr = request.getParameter("echostr");
        String sEchoStr = wechatHelper.corpJoinup(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        return sEchoStr;
    }

    @RequestMapping(value = "wechat/set", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request) {
        String name = "123456789GOODBYE";
        return name;
    }
}
