package pp.net;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

// url
// http://www.culture.go.kr/openapi/rest/publicperformancedisplays/period?ServiceKey=%2BZC19jvghXXkVLp75PlbDeCGXjibTwH8donm1xEmU4SBOBdHclI7Y6EipZ%2BXSrvS0DBLWPQpBd8EKyBBwOn1iw%3D%3D&keyword=&sortStdr=1&ComMsgHeader=&RequestTime=20100810%3A23003422&CallBackURI=&MsgBody=&from=20100101&to=20101201&cPage=1&rows=10&place=1&gpsxfrom=124.101&gpsyfrom=33.142&gpsxto=132.101&gpsyto=43.141

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://www.culture.go.kr/openapi/rest/publicperformancedisplays/period"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=%2BZC19jvghXXkVLp75PlbDeCGXjibTwH8donm1xEmU4SBOBdHclI7Y6EipZ%2BXSrvS0DBLWPQpBd8EKyBBwOn1iw%3D%3D"); /*Service Key*/
        //urlBuilder.append("?%2BZC19jvghXXkVLp75PlbDeCGXjibTwH8donm1xEmU4SBOBdHclI7Y6EipZ%2BXSrvS0DBLWPQpBd8EKyBBwOn1iw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("sortStdr","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*1:등록일, 2:공연명, 3:지역*/
        urlBuilder.append("&" + URLEncoder.encode("ComMsgHeader","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("RequestTime","UTF-8") + "=" + URLEncoder.encode("20100810:23003422", "UTF-8")); /*Optional 필드*/
        urlBuilder.append("&" + URLEncoder.encode("CallBackURI","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*Optional 필드*/
        urlBuilder.append("&" + URLEncoder.encode("MsgBody","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("from","UTF-8") + "=" + URLEncoder.encode("20100101", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("to","UTF-8") + "=" + URLEncoder.encode("20101201", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("cPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("rows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*3~100*/
        urlBuilder.append("&" + URLEncoder.encode("place","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("gpsxfrom","UTF-8") + "=" + URLEncoder.encode("124.101", "UTF-8")); /*경도 범위검색 중 하한*/
        urlBuilder.append("&" + URLEncoder.encode("gpsyfrom","UTF-8") + "=" + URLEncoder.encode("33.142", "UTF-8")); /*위도 범위검색 중 하한*/
        urlBuilder.append("&" + URLEncoder.encode("gpsxto","UTF-8") + "=" + URLEncoder.encode("132.101", "UTF-8")); /*경도 범위검색 중 상한*/
        urlBuilder.append("&" + URLEncoder.encode("gpsyto","UTF-8") + "=" + URLEncoder.encode("43.141", "UTF-8")); /*위도 범위검색 중 상한*/
        
        System.out.println(urlBuilder.toString());
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}