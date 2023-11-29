package com.ezen.movie.service.member;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.member.MemberMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService{

	@Value("${kakao.restApiKey}")
	private String restApiKey;
	@Value("${kakao.redirectUri}")
	private String redirectUri;

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean getDoubleChk(MemberDTO dto) {
		return memberMapper.getDoubleChk(dto) > 0; 
	}

	@Override
	public void join(MemberDTO dto) {
		memberMapper.join(dto);
		
	}

	@Override
	public MemberDTO login(MemberDTO dto) {
		return memberMapper.login(dto);
	}


	@Override
	public String getKakaoAccessToken(String code){
		String accessToken = "";
		//String refreshToken = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";

		try {

			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// setDoOutput()은 OutputStream으로 POST 데이터를 넘겨 주겠다는 옵션이다.
			// POST 요청을 수행하려면 setDoOutput()을 true로 설정한다.
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 요청에서 필요한 파라미터를 OutputStream을 통해 전송
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			String sb = "grant_type=authorization_code" +
					"&client_id="+  restApiKey +// REST_API_KEY
					"&redirect_uri=" + redirectUri +  // REDIRECT_URI
					"&code=" + code;
			bufferedWriter.write(sb);
			bufferedWriter.flush();

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 데이터를 InputStreamReader을 통해 읽어 오기
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			StringBuilder result = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {
				result.append(line);
			}
			System.out.println("response body : " + result);

			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {};

			Map<String,Object> jsonMap = objectMapper.readValue(String.valueOf(result),typeReference);

			accessToken = (String)jsonMap.get("access_token");


		} catch (IOException e){
			e.printStackTrace();
		}
		return accessToken;

	}

	/**
	 * 계정 정보가져오기
	 * @param memberId
	 * @return
	 */
	@Override
	public MemberDTO getOne(MemberDTO memberDTO) {
		return memberMapper.getOne(memberDTO);
	}

	/**
	 * 카카오에서 유저 정보 가져오기
	 * @param accessToken
	 * @return
	 */
	@Override
	public Map<String, Object> getKakaoUserInfo(String accessToken) {
		Map<String, Object> userInfo = new HashMap<>();
		String postURL = "https://kapi.kakao.com/v2/user/me";

		try{
			URL url = new URL(postURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			StringBuilder result = new StringBuilder();

			while ((line = br.readLine()) != null) {
				result.append(line);
			}

			System.out.println("response body : " + result);

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode responseData = objectMapper.readTree(String.valueOf(result));

			JsonNode kakaoAccount = responseData.get("kakao_account");
			JsonNode profile = kakaoAccount.get("profile");

		/*	Map<String, Object> responseData = objectMapper.readValue(String.valueOf(result), Map.class);
			System.out.println("responseData = " + responseData);
			System.out.println("responseData = " + responseData.get("properties"));
			Map<String,Object> propertiesMap = (Map<String, Object>) responseData.get("properties");
			Map<String,Object> profileMap = (Map<String, Object>) responseData.get("profile");*/

			userInfo.put("id",responseData.get("id"));
			userInfo.put("nickname",profile.get("nickname").asText());
			userInfo.put("email",kakaoAccount.get("email").asText());

			String gender = "F";
			if("male".equals(kakaoAccount.get("gender").asText())){
				gender = "M";
			}
			userInfo.put("gender",gender);

		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		return userInfo;
	}

	/**
	 * 카카오로 회원가입하기
	 * @param memberDTO
	 */
	@Override
	public void kakaoJoin(MemberDTO memberDTO) {
		memberMapper.kakaoJoin(memberDTO);
	}

}
