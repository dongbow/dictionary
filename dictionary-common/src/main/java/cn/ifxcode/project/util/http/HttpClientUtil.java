package cn.ifxcode.project.util.http;

import cn.ifxcode.project.constants.CommonConstants;
import com.google.common.base.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Slf4j
public class HttpClientUtil {

    public static HttpClient getHttpClient() {
        return HttpClientHolder.httpClient;
    }

    protected String getHttpResult(HttpUriRequest method) {
        return parseEntity(getHttpEntity(returnResponse(method)));
    }

    protected HttpResponse returnResponse(HttpUriRequest method) {
        try {
            HttpResponse httpResponse = getHttpClient().execute(method);
            return httpResponse;
        } catch (IOException e) {
            log.error("return response error", e);
        }
        return null;
    }

    protected HttpEntity getHttpEntity(HttpResponse httpResponse) {
        if (Objects.equal(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK)) {
            return httpResponse.getEntity();
        }
        return null;
    }

    protected String parseEntity(HttpEntity httpEntity) {
        try {
            if (httpEntity == null) {
                return null;
            }
            return EntityUtils.toString(httpEntity, CommonConstants.CHARSET);
        } catch (IOException e) {
            log.error("parse httpEntity error", e);
        }
        return null;
    }

    private static class HttpClientHolder {
        /**
         * 全局最大连接数为500
         */
        private static Integer MAX_CONN = 500;

        /**
         * 单host最大连接数为50
         */
        private static Integer MAX_CONN_PER_ROUTE = 50;
        /**
         * 默认连接超时时间为 5秒
         */
        private static Integer MAX_CONNECTION_TIME_OUT = 5000;

        /**
         * 默认线程池获取连接超时时间为 10秒
         */
        private static Integer MAX_CONNECTION_POOL_TIME_OUT = 10000;
        /**
         * 默认数据读取超时时间为 10秒
         */
        private static Integer MAX_SOCKET_TIME_OUT = 10000;

        /**
         * user agent
         */
        private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36";

        public static HttpClient httpClient = null;

        private static void init(){
            RequestConfig config = RequestConfig.custom().setConnectTimeout(MAX_CONNECTION_TIME_OUT)
                    .setConnectionRequestTimeout(MAX_CONNECTION_POOL_TIME_OUT)
                    .setMaxRedirects(4)
                    .setSocketTimeout(MAX_SOCKET_TIME_OUT)
                    .build();

            HttpClientBuilder builder = HttpClientBuilder.create();
            builder.setMaxConnPerRoute(MAX_CONN_PER_ROUTE);
            builder.setMaxConnTotal(MAX_CONN);
            builder.setUserAgent(USER_AGENT);
            builder.setDefaultRequestConfig(config);

            httpClient = builder.build();
        }

        static {
            init();
        }
    }
}
