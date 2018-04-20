package com.sery.labmon.wechat;

import com.sery.labmon.wechat.utils.AesException;
import com.sery.labmon.wechat.utils.HttpRequestUtils;
import com.sery.labmon.wechat.utils.WXBizMsgCrypt;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created by SleepingMoon on 2017/3/27.
 * 微信相关方法
 */
public class WechatHelper {

    private String token;

    private String corpid;

    private int agentid;

    private String sEncodingAESKey;

    private static Logger log = LoggerFactory.getLogger(WechatHelper.class);


    /******************************************************************************************************************
     * 个人公众号
     *******************************************************************************************************************
     */

    /**
     * 接入微信平台
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    public boolean joinup(String echoStr, String timestamp, String nonce, String signature) {

        ArrayList<String> list = new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(token);
        Collections.sort(list);
        String mysignature = DigestUtils.shaHex(list.get(0) + list.get(1) + list.get(2));

        if (echoStr != null && mysignature.equals(signature)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取token，有效期为7200秒
     *
     * @return
     */
    public String getToken(String appid, String secret) {

        String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";

        String accessToken;

        log.info("getAccessToken start.{appid=" + appid + ",secret:" + secret + "}");
        try {
            String url = MessageFormat.format(getTokenUrl, appid, secret);
            JSONObject jsoninfo = HttpRequestUtils.httpGet(url);
            accessToken = jsoninfo.getString("access_token");
        } catch (Exception e) {
            log.error("get access token exception", e);
            accessToken = "";
        }
        return accessToken;
    }

    /**
     * 获取来自用户的信息转换成map
     *
     * @return
     */
    public Map<String, String> getUserMsg() {
        return null;
    }

    /**
     * 获取被动回复的信息。
     *
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgType
     * @param content
     * @return
     */
    public String relpyMsg(String toUserName, String fromUserName, String createTime, String msgType, String content) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + createTime + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + content + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 主动_添加自定义菜单
     *
     * @param jsonParam
     * @param accessToken
     */
    public void addMenu(JSONObject jsonParam, String accessToken) {
        String addMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
        String url = MessageFormat.format(addMenuUrl, accessToken);
        HttpRequestUtils.httpPost(url, jsonParam);
    }

    /**
     * 主动_查询菜单
     *
     * @return
     */
    public String queryMenu() {
        String queryMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
        return "";
    }

    /**
     * 删除菜单 ，另请注意，在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单。
     *
     * @param accessToken
     * @return
     */
    public boolean deleteMenu(String accessToken) {

        String deleteMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={0}";
        String url = MessageFormat.format(deleteMenuUrl, accessToken);
        JSONObject jsonParam = JSONObject.fromObject("");
        HttpRequestUtils.httpPost(url, jsonParam);
        return true;

    }

    /**
     * 发送消息--广播
     */
    public void sendMsg() {

    }

    /**
     * 发送模板消息
     *
     * @param accessToken
     * @param jsonParam
     * @return
     */
    public boolean sendTemplateMsg(String accessToken, JSONObject jsonParam) {

        String url = " https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={0}";

        url = MessageFormat.format(url, accessToken);

        HttpRequestUtils.httpPost(url, jsonParam);

        return true;

    }


    /**
     * 设置模板消息行业ID
     *
     * @param num1
     * @param num2
     * @param accessToken
     * @return
     */
    public boolean setIndustryNum(String num1, String num2, String accessToken) {

        String url = " https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token={}";
        url = MessageFormat.format(url, accessToken);
        JSONObject jsonParam = JSONObject.fromObject("{ 'industry_id1':'" + num1 + "','industry_id2':'" + num2 + "'}");
        HttpRequestUtils.httpPost(url, jsonParam);
        return true;

    }


    /******************************************************************************************************************
     * 企业公众号
     ******************************************************************************************************************
     */

    /**
     * 企业的微信平台接入
     *
     * @return
     */
    public String corpJoinup(String sVerifyMsgSig, String sVerifyTimeStamp, String sVerifyNonce, String sVerifyEchoStr) {
        String sEchoStr = null;
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, sEncodingAESKey, corpid);
            sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return sEchoStr;
    }

    /**
     * 获取企业的accessToken；
     *
     * @param corpid
     * @param corpsecret
     * @return
     */
    public String getCorpToken(String corpid, String corpsecret) {
        String accessToken;
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={0}&corpsecret={1}";
        log.info("getAccessToken start.{appid=" + corpid + ",secret:" + corpsecret + "}");
        try {
            url = MessageFormat.format(url, corpid, corpsecret);
            JSONObject jsoninfo = HttpRequestUtils.httpGet(url);
            accessToken = jsoninfo.getString("access_token");
        } catch (Exception e) {
            log.error("get access token exception", e);
            accessToken = "";
        }
        return accessToken;
    }

    /**
     * 获取来自客户端的信息，map
     *
     * @param sReqMsgSig
     * @param sReqTimeStamp
     * @param sReqNonce
     * @param sReqData
     * @return
     */
    public Map<String, String> getMapMsg(String sReqMsgSig, String sReqTimeStamp, String sReqNonce, String sReqData) {

        Map<String, String> map = new HashMap<String, String>();
        try {
            //消息解密 以及验证
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, sEncodingAESKey, corpid);
            String sMsg = wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
            System.out.println("after decrypt msg: " + sMsg);
            Document doc = DocumentHelper.parseText(sMsg);

            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element e : list) {
                map.put(e.getName(), e.getText());
                System.out.println(e.getName() + "--->" + e.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public String getCorpXmlMsg(String toUserName, String fromUserName, String createTime, String msgType, String content, String msgId, String agentID) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + createTime + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + content + "]]></Content>");
        // sb.append("<MsgId><![CDATA[" + msgId + "]]></MsgId>");
        // sb.append("<AgentID><![CDATA[" + agentID + "]]></AgentID>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 获取被动回复的信息，添加相关的签名。
     *
     * @param replyMsg
     * @param sReqTimeStamp
     * @param sReqNonce
     * @return
     */
    public String getReplyMsg(String replyMsg, String sReqTimeStamp, String sReqNonce) {
        String sEncryptMsg = "";
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, sEncodingAESKey, corpid);
            sEncryptMsg = wxcpt.EncryptMsg(replyMsg, sReqTimeStamp, sReqNonce);
            System.out.println("after encrypt sEncrytMsg: " + sEncryptMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sEncryptMsg;
    }


    public boolean sendCorpMsg(String accessToken, JSONObject jsonParam) {

        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";
        url = MessageFormat.format(url, accessToken);
        HttpRequestUtils.httpPost(url, jsonParam);
        return true;
    }

    /**
     * 创建菜单
     *
     * @param accessToken
     * @param jsonParam
     * @return
     */
    public boolean createEntMenu(String accessToken, JSONObject jsonParam) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token={0}&agentid={1}";
        url = MessageFormat.format(url, accessToken, agentid);
        HttpRequestUtils.httpPost(url, jsonParam);
        return true;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public void setsEncodingAESKey(String sEncodingAESKey) {
        this.sEncodingAESKey = sEncodingAESKey;
    }
}
