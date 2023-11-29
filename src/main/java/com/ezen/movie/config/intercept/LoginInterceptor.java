package com.ezen.movie.config.intercept;

import com.ezen.movie.comm.HttpUtil;
import com.ezen.movie.comm.MemberUtil;
import com.ezen.movie.service.member.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        MemberDTO member = MemberUtil.getMember();
        if(member != null){
            return true;
        }
        response.sendRedirect("/member/loginForm");

        return false;
    }
}
