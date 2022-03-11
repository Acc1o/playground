package com.playground.utils.wx;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/9 16:58
 * @description：微信小程序 订阅消息通知
 * @version: 1.0
 */
@Component
public class APIWX {
    //APPID 小程序ID
    private final String APPID = "";
    //AppSecret
    private final String APPSECRET = "";
    //消息模板id
    private final String TEMPLATEID = "";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


    //获取AccessToken  唯一后台接口调用凭据
    private String getAccessToken() {
        //获取AccessToken 接口地址
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;

        if (StringUtils.isEmpty(restTemplate)) {
            restTemplate = new RestTemplate();
        }
        //发送请求 返回AccessToken
        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(json);
        return jsonObject.get("access_token").toString();
    }

    /**
     * 发送消息通知
     *
     * @param accessToken 唯一后台接口调用凭据
     * @param openid      用户openid
     * @param data        消息内容
     * @return
     */
    public JSONObject pushOneUser(String accessToken, String openid, JSONObject data) {
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = getAccessToken();
        }

        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken;
        logger.info("<-- 模板推送url地址："+url+"  -->");

        //拼接消息模板
        WXMssVo wxMssVo = new WXMssVo();
        wxMssVo.setTouser(openid);
        wxMssVo.setTemplate_id(TEMPLATEID);
        wxMssVo.setData(data);
        logger.info("<-- 拼接后的模板信息："+JSONObject.toJSONString(wxMssVo)+" -->");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, wxMssVo, String.class);
        logger.info("消息推送结果："+responseEntity.getBody());
        return JSONObject.parseObject(responseEntity.getBody().toString());
    }

    //微信登录凭证校验
    public JSONObject WXLoginVoucher(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        logger.info("<-- url地址为："+url+" -->");

        if (StringUtils.isEmpty(restTemplate)) {
            restTemplate = new RestTemplate();
        }

        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(json);
        logger.info("<-- 返回参数："+jsonObject+" -->");
        return jsonObject;
    }

    //消息通知模板内容 参数名和模板对应，参数值类型参考 https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html
    public JSONObject getJsonObject(String msg) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phrase2", new JSONObject() {{
            put("value", "消息推送");
        }});
        jsonObject.put("thing3", new JSONObject() {{
            put("value", msg);
        }});
        return jsonObject;
    }
}
