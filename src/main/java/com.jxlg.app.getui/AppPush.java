package com.jxlg.app.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouboxi
 * @create 2018-02-27 22:22
 **/
public class AppPush {

    //定义常量

    private static String appId="wSI0HAV2NH6dwklAUurhB8";
    private static String appKey="dlcgMwKAQV86zkKNlCg754";
    private static String masterSecret="iNO3qY0BNRAu1XXiF0VUK3";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) {
        //1.创建推送的实例
        IGtPush push = new IGtPush(url, appKey, masterSecret);
        //2.创建想要推送的模板
        //定义点击链接打开通知模板，并设置标题 内容。链接
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("个推测试");
        template.setText("第一条信息");
        template.setUrl("www.baidu.com");
        //3.对于多个推送目标进行写入
        List<String> appIds = new ArrayList<>();
        appIds.add(appId);

        //4.对推送进行消息整理
        //定义appmessage类型消息对象,设置消息内容模板,
        // 发送的目标app列表,是否支持离线发送,以及离线消息有效
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000*600);
        //5.进行消息推送
        IPushResult result = push.pushMessageToApp(message);
        System.out.println(result.getResponse().toString());
    }
}

