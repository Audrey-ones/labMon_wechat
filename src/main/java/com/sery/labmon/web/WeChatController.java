package com.sery.labmon.web;

import com.sery.labmon.model.AlarmInfo;
import com.sery.labmon.service.AlarmInfoService;
import com.sery.labmon.wechat.WechatHelper;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wechat")
public class WeChatController {
    @Autowired
    private AlarmInfoService alarmInfoService;

    WechatHelper wechatHelper;

    WeChatController() {
        this.wechatHelper = new WechatHelper();
        wechatHelper.setToken("labmon");
        wechatHelper.setCorpid("wxa59b84a6fc62bbcb");
        wechatHelper.setAgentid(1000003);
        wechatHelper.setsEncodingAESKey("MxjP8PGDbfOp4kSdIxTzCNnp3aWcr1lctPcSM5qCnNY");
    }

    /**
     * 接收微信服务器发送请求时传递过来的4个参数
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String joinUp(HttpServletRequest request) {
        String sVerifyMsgSig = request.getParameter("msg_signature");
        String sVerifyTimeStamp = request.getParameter("timestamp");
        String sVerifyNonce = request.getParameter("nonce");
        String sVerifyEchoStr = request.getParameter("echostr");
        String sEchoStr = wechatHelper.corpJoinup(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
        return sEchoStr;
    }

    /**
     * 消息接受以及处理
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws DocumentException
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String doMsg(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        try {
            //获取信息
            String sReqMsgSig = request.getParameter("msg_signature");
            String sReqTimeStamp = request.getParameter("timestamp");
            String sReqNonce = request.getParameter("nonce");
            InputStream inputStream = request.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();// 自带缓存的输出流
            int len = -1;
            byte[] buffer = new byte[512];
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len); // 将读到的字节，写入baos
            }
            inputStream.close();
            String sReqData = new String(baos.toByteArray());
            Map<String, String> map = wechatHelper.getMapMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String createTime = map.get("CreateTime");
            String msgType = map.get("MsgType");
            String content = map.get("Content");
            String msgId = map.get("MsgId");
            String agentId = map.get("AgentID");
            String eventType = map.get("Event");
            String eventKey = map.get("EventKey");

            //处理
            String msg = "";
            Long returntime = Calendar.getInstance().getTimeInMillis() / 1000;
            switch (msgType) {
                case "text":
                    String info = "";
                    if (content.startsWith("cx")) {
                        info = "";
                    }
                    msg = wechatHelper.getCorpXmlMsg(fromUserName, toUserName, returntime.toString(), "text", info, msgId, agentId);
                    break;
                case "event":
                    if (eventType.equals("subscribe")) {
                        msg = wechatHelper.getCorpXmlMsg(fromUserName, toUserName, returntime.toString(), "text", "感谢订阅实验室实时监控服务公众号！", msgId, agentId);
                    } else if (eventType.equals("click")) {
                        if (eventKey.equals("sys")) {
                            String tip = "";
                            List<AlarmInfo> list = alarmInfoService.getAlarmInfos();
                            if (list.size() != 0){
                                for (AlarmInfo alarmInfo:list){
                                    alarmInfo.setHandled(1);
                                    alarmInfo.setHandler(fromUserName);
                                    alarmInfoService.handleAlarmIo(alarmInfo);
                                }
                                tip = "操作成功，请尽快处理！";
                            }else {
                                AlarmInfo alarmInfo = alarmInfoService.getRecentlyHandler();
                                tip = "您晚了一步哦~报警信息已经被处理啦，当前暂无待处理信息。最近一次处理报警信息的人是"+alarmInfo.getHandler()+"。";
                            }

                            /*String tip = "操作成功，请尽快处理！"+fromUserName;*/
                            msg = wechatHelper.getCorpXmlMsg(fromUserName, toUserName, returntime.toString(), "text", tip, msgId, agentId);
                        }
                        if (eventKey.equals("ck")) {
                            String tip = alarmInfoService.getAlarmInfoByHandler(fromUserName);
                            /*String tip = "操作成功，请尽快处理！"+fromUserName;*/
                            msg = wechatHelper.getCorpXmlMsg(fromUserName, toUserName, returntime.toString(), "text", tip, msgId, agentId);
                        }
                        if (eventKey.equals("more")) {
                            String moreInfo = "如您在使用过程中有任何的技术问题，请联系西瑞科技技术人员。\n" + "谢谢使用服务！";
                            msg = wechatHelper.getCorpXmlMsg(fromUserName, toUserName, returntime.toString(), "text", moreInfo, msgId, agentId);
                        }
                    }
                    break;
                default:
                    System.out.println("暂未处理该消息！");
                    break;
            }
            System.out.println(msg);
            //返回
            String replayMsg = wechatHelper.getReplyMsg(msg, Long.toString(new Date().getTime()), sReqNonce);

            return replayMsg;

        } catch (Exception e) {
            // 解密失败，失败原因请查看异常
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 测试接口是否可用
     * @param request
     * @return
     */
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request) {
        String name = "123456789GOODBYE";
        return name;
    }
}
