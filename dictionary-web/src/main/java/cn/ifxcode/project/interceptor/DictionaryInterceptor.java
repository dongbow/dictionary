package cn.ifxcode.project.interceptor;

import cn.ifxcode.project.constants.CommonConstants;
import cn.ifxcode.project.util.IPUtil;
import cn.ifxcode.project.util.trace.TraceUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * interceptor
 *
 * @author dongbo
 * @date 2017/10/20
 */
public class DictionaryInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ip = IPUtil.getRemoteIp(httpServletRequest);
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        String refer = httpServletRequest.getHeader(HttpHeaders.REFERER);
        TraceUtil.log(uri.concat(CommonConstants.QUESTION_MARK).concat(query), refer, ip);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
