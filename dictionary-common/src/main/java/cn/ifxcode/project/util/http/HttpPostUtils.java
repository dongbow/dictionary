package cn.ifxcode.project.util.http;

import cn.ifxcode.project.constants.CommonConstants;
import cn.ifxcode.project.util.trace.TraceUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Http Post method Utils
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
public class HttpPostUtils extends HttpClientUtil {

    public static HttpPostUtils httpPostUtils = null;

    public static HttpPostUtils getInstance() {
        synchronized (HttpPostUtils.class) {
            if (httpPostUtils == null) {
                httpPostUtils = new HttpPostUtils();
            }
            return httpPostUtils;
        }
    }

    private HttpPostUtils() {}

    public String doPost(String url) {
        return doPost(url, null);
    }

    public String doPost(String url, Map<String, Object> param) {
        HttpPost httpPost = new HttpPost(url);
        if (param != null) {
            List<NameValuePair> params = NameValuePairUtil.fromMap(param);
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(params, CommonConstants.CHARSET));
            } catch (UnsupportedEncodingException e) {
                log.error("param deal error", e);
                return null;
            }
        }
        TraceUtil.log(HttpMethod.POST, httpPost.getURI().toString(), param);
        return getHttpResult(httpPost);
    }

    public String doPostWithBody(String url, Map<String, Object> param) {
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity(JSON.toJSONString(JSON.toJSON(param)));
            stringEntity.setContentEncoding(CommonConstants.CHARSET);
            stringEntity.setContentType(CommonConstants.JSON_CONTENT_TYPE);
            httpPost.setEntity(stringEntity);
        } catch (UnsupportedEncodingException e) {
            log.error("param deal error", e);
            return null;
        }
        TraceUtil.log(HttpMethod.POST, httpPost.getURI().toString(), param);
        return getHttpResult(httpPost);
    }
}
