package com.ihome.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101000649367";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCMFtHl8cjoobQcaIGDJtPOKFWE9haobfNmLXxHK4ZKAitpp6MsxVMH4SKB6T/niRmCQyJfadNKvxa6Omdl27TCFTKW1S1ObNyacrqcM0vXUrS+WRMcEssUGxXHjoThnBhwpXAJLpqEnNayKsKR+dr2fK9I3rIejNvoBEuCcB2YXtGoW5eJCcm5Eg1+oQ1v8oGVrxlUIDBgsQ1ds86sR3Pv1rlZ6jNAwNLaYdX8zIqOx/9XtJ8QvlbSQHa9WkDfILM1iWaYfwmpu8PVAw5HrXkfK8QIHThZB+4H0kGqnMAHF+dagi/YHwwbKsHL9/SH1k2zLNCVO3FHzhwqrM6A4MWBAgMBAAECggEAMXlJraSjKI0bF8FMo+3NdYxHD4r9W4RhJl+/+T6E0ZRMkqayePhDJ5A56JlgiTug96EP/ZRZG5e6xhAkPhPGlZh44k3tDzpg+ma0Qr/W8/dwf5zjo9F7SOF74psRkL/Y3cd/dq6vwU/GfuudBYKw8sX7/YcwbpueeiUyKaHAwfOMB1i5e6M/Fu9fhjCPOW/clUrUFvfBL9I4CfNrRYiyhwStG2HydEUHEzRAvE4u0Kg8/GcdlRigWateHUBa0scx0tgsET9e6q0nx/CjdQ3249pGFBNchEiI86kYjrqHPYI5keUnyzwoxpJ8NdXjZMg1+nOMmK2LYUo77Z21zAbNwQKBgQDUEFnX/e1DL+GUaUX9gF84k8/qKd7myv+Kl7BQxEzy8w8Yq8GJeP8rgWFrfi0FpFeum5Z6jlQAzE8t68jIrcaW5qhUIxCdcT6ohTbrkbLLFsBbCnfl+C1mEHfX58EUWr+fvHbgWn+qu7Mg93nkkq5Hcgdsx2fObj1G69KMz+F3qQKBgQCpHQDjKnofzVRIT4A7kgMK1VkRqEhMV/K0RKz+oZPWdOWUIwaQmo6dpRWnOQey2kdIuxlafpBebRNdaCS7G8tjPW++vyVl7TVwd45VxT0C79dDiQ+kTD85pKmuyv9w9myemO/qpV08u1WpySHKmYArejxOnsiySt1kjLZ+JvEmGQKBgBDoMNGInCb0JU74yay5VF4lYrkvl2bdHlyFVXhK/juMZ1K3Ntnn/KgSS5sPVzWQ8bCpFOk2eboKj/GAT+S3/hI/14HFvehfg/hZjpRfbFrGuJVJk1+RVsVBYNykzH778TUiCHRAotcQ2eox8NTpYN2vWKoyh7MslNQXrxSs6jPpAn9P7mV8+Za/cU1k4C67+Ud212BB+EgzzV3p1ovtznER7C6W1fdEYckGugCCCXKaFpGaztQs8aVK/EMq4w55YanAPkmS3sXOZ0/a2Kdt4svzl2kngqDiByfbFvkcpNYXjmHIlIDRZ1eqXOEgXvCZ0fPCmQPoJSS3IKuD2v5mogFZAoGBAKYwqUOqvGnISx7YbpCBXBPR12tYYc2mOzD2ouigBft9eQ+ZGo39Rfu3faS4tuTYEm2l6w4zj8cxPBeoav+QDhRvKu3XNPsgUUtVtZLnH5NMPuZRgwd978WuQLVrt06geY2gl7SY5wApjYQc0WSD5zQlaY3HRPY+yROLQQutAqNd";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjBbR5fHI6KG0HGiBgybTzihVhPYWqG3zZi18RyuGSgIraaejLMVTB+Eigek/54kZgkMiX2nTSr8WujpnZdu0whUyltUtTmzcmnK6nDNL11K0vlkTHBLLFBsVx46E4ZwYcKVwCS6ahJzWsirCkfna9nyvSN6yHozb6ARLgnAdmF7RqFuXiQnJuRINfqENb/KBla8ZVCAwYLENXbPOrEdz79a5WeozQMDS2mHV/MyKjsf/V7SfEL5W0kB2vVpA3yCzNYlmmH8JqbvD1QMOR615HyvECB04WQfuB9JBqpzABxfnWoIv2B8MGyrBy/f0h9ZNsyzQlTtxR84cKqzOgODFgQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/ihome/success";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

