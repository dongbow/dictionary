package cn.ifxcode.project.util.http;

import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.Map;

/**
 * Http params convert method
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class NameValuePairUtil {

    public static List<NameValuePair> fromMap(Map<String, Object> param) {
        List<NameValuePair> list = Lists.newArrayList();
        for (Map.Entry entry : param.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            list.add(pair);
        }
        return list;
    }

}
