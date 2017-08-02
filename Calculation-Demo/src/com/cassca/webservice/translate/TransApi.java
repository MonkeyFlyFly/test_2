package com.cassca.webservice.translate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private static String appid = "2015063000000001";
    public static  String securityKey ="";
    public static String salt ="1435660288";
    public static String src="f89f9594663708c1605f3d736d01d2d4";
    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    public static String getTransResult(String query, String from, String to) throws UnsupportedEncodingException {
        Map<String, String> params = buildParams(query, from, to);
        return HttpGet.get(TRANS_API_HOST, params);
    }

    public static Map<String, String> buildParams(String query, String from, String to) throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 闅忔満鏁�
//        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 绛惧悕
        //String src = appid + query + salt + securityKey; // 鍔犲瘑鍓嶇殑鍘熸枃
        
        params.put("sign", MD5.md5(src));

        return params;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
    	System.out.println(TransApi.getTransResult("", "", ""));;
	}

}
