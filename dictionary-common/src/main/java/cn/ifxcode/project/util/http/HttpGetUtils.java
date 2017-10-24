package cn.ifxcode.project.util.http;

import cn.ifxcode.project.constants.CommonConstants;
import cn.ifxcode.project.util.trace.TraceUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Http Get method Utils
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
public class HttpGetUtils extends HttpClientUtil {

    public static HttpGetUtils httpGetUtils = null;

    public static HttpGetUtils getInstance() {
        synchronized (HttpGetUtils.class) {
            if (httpGetUtils == null) {
                httpGetUtils = new HttpGetUtils();
            }
            return httpGetUtils;
        }
    }

    private HttpGetUtils() {}

    public String doGet(String url) {
        return doGet(url, null);
    }

    public String doGet(String url, Map<String, Object> param) {
        HttpGet httpGet = new HttpGet(url);
        if (param != null) {
            List<NameValuePair> params = NameValuePairUtil.fromMap(param);
            try {
                String str = EntityUtils.toString(new UrlEncodedFormEntity(params, CommonConstants.CHARSET));
                httpGet.setURI(new URI(httpGet.getURI().toString().concat(CommonConstants.QUESTION_MARK).concat(str)));
            } catch (IOException e) {
                log.error("param cast error", e);
                return null;
            } catch (URISyntaxException e) {
                log.error("uri concat error", e);
                return null;
            }
        }
        TraceUtil.log(HttpMethod.GET, httpGet.getURI().toString());
        return getHttpResult(httpGet);
    }

    public static void main(String[] args) {
        System.out.println(HttpGetUtils.getInstance().doGet("https://api.shanbay.com/bdc/search/?word=word"));
    }

}
