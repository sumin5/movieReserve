package com.ezen.movie.comm;

import com.ezen.movie.comm.HttpUtil;
import com.ezen.movie.service.member.MemberDTO;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component("memberUtil")
public class MemberUtil {

    public static MemberDTO getMember(){

        MemberDTO member = null;

        try{

            HttpSession session = HttpUtil.getSession();
            String user = (String) session.getAttribute("user");

            if(user != null && user.length() > 0 ) {
                member = new Gson().fromJson(user,MemberDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return member;

    }

    public static boolean isLogin(){
        HttpSession session = HttpUtil.getSession();

        String user = (String) session.getAttribute("user");


        return user != null && !"".equals(user) && user.trim().length() > 0;

    }
}
