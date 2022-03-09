package com.demo.utils.wx;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/9 16:56
 * @description：小程序消息推送参数类
 * @version: 1.0
 */
public class WXMssVo {
    private String touser;//用户openid

    private String template_id;//模板id

    private String page = "";//模板点击跳转的页面

    private JSONObject data;//模板内容

    private String miniprogram_state;//跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版

    private String lang;//进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getMiniprogram_state() {
        return miniprogram_state;
    }

    public void setMiniprogram_state(String miniprogram_state) {
        this.miniprogram_state = miniprogram_state;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
