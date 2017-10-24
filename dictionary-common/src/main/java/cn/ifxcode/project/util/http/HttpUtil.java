package cn.ifxcode.project.util.http;

/**
 * Http method
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class HttpUtil {

    public static HttpGetUtils GET = HttpGetUtils.getInstance();

    public static HttpPostUtils POST = HttpPostUtils.getInstance();
}
