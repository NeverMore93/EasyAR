package com.easyar.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;
import org.json.JSONException;
import org.json.JSONObject;

import com.easyar.constant.EasyARConstants;
import com.easyar.tool.Tools;



public class AsyncHttpClientUtil {
	public static final int ImageSize = 15;
	public static final String  ImageType = "ImageTarget";
	public static String generateSignature(JSONObject jso, String appSecret) {
        String paramStr = jso.keySet().stream().sorted().map(key -> key + jso.getString(key)).collect(Collectors.joining());
        return DigestUtils.sha1Hex(paramStr + appSecret);
    }

    public static JSONObject signParam(JSONObject param, String appKey, String appSecret) {
        param.put(EasyARConstants.KEY_DATE, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX").withZone(ZoneOffset.UTC).format(Instant.now()));
        param.put(EasyARConstants.KEY_APP_KEY, appKey);
        param.put(EasyARConstants.KEY_SIGNATURE, generateSignature(param, appSecret));
        return param;
    }
    public static List<Param> toParams(JSONObject jso) {
        return jso.keySet().stream().map(key -> new Param(key, jso.getString(key))).collect(Collectors.toList());
    }
	public static String AddImage(String name,String image) throws JSONException, IOException, InterruptedException, ExecutionException {
		AsyncHttpClient client = new DefaultAsyncHttpClient();
        JSONObject params = new JSONObject();
        params.put("image", image);
        params.put("size", ImageSize);
        params.put("meta", "");
        params.put("type", ImageType);
        params.put("name", name);
        signParam(params, EasyARConstants.APP_KEY, EasyARConstants.APP_SECRET);       
        String AddResultStr= client.preparePost(EasyARConstants.HOST+ "/targets/").setBody(params.toString().getBytes()).execute(new AsyncCompletionHandler<String>(){
			@Override
			public String onCompleted(Response response) throws Exception {
				return response.getResponseBody();
			}}).get();
        client.close();
        return AddResultStr;
	}
	
	public static String RemoveImage(String targetID) throws InterruptedException, ExecutionException, IOException{
		    AsyncHttpClient client = new DefaultAsyncHttpClient();
	        JSONObject params = new JSONObject();
	        signParam(params, EasyARConstants.APP_KEY, EasyARConstants.APP_SECRET);
	        String RemoveResultStr=client.prepareDelete(EasyARConstants.HOST + "/target/" + targetID).setQueryParams(toParams(params)).execute(new AsyncCompletionHandler<String>() {
	                    @Override
	                    public String onCompleted(Response response) throws Exception {
	                    	return response.getResponseBody();             
	                    }}).get();
	        client.close();
		    return RemoveResultStr;		
	}
	
	public static String SimilarImage(String image) throws InterruptedException, ExecutionException, IOException{
	    AsyncHttpClient client = new DefaultAsyncHttpClient();
        JSONObject params = new JSONObject();
        params.put("image", image);
        signParam(params, EasyARConstants.APP_KEY, EasyARConstants.APP_SECRET);
        String SimilarResultStr = client.preparePost(EasyARConstants.HOST + "/similar/").setBody(params.toString().getBytes()).execute(new AsyncCompletionHandler<String>() {
                    @Override
                    public String onCompleted(Response response) throws Exception {
                    	return response.getResponseBody();             
                    }}).get();
        client.close();
	    return SimilarResultStr;		
}
	
	public static String DetectImage(String image) throws JSONException, IOException, InterruptedException, ExecutionException {
		AsyncHttpClient client = new DefaultAsyncHttpClient();
        JSONObject params = new JSONObject();
        params.put("image", image);
        signParam(params, EasyARConstants.APP_KEY, EasyARConstants.APP_SECRET);       
        String DetectResultStr = client.preparePost(EasyARConstants.HOST+ "/grade/detection/").setBody(params.toString().getBytes()).execute(new AsyncCompletionHandler<String>(){
			@Override
			public String onCompleted(Response response) throws Exception {
				return response.getResponseBody();
			}}).get();
        client.close();
        return DetectResultStr;
	}
	
	public static String GetImage(String targetID) throws JSONException, IOException, InterruptedException, ExecutionException {
		AsyncHttpClient client = new DefaultAsyncHttpClient();
        JSONObject params = new JSONObject();
        signParam(params, EasyARConstants.APP_KEY, EasyARConstants.APP_SECRET);       
        String GetResultStr = client.prepareGet(EasyARConstants.HOST+ "/target/"+ targetID).setQueryParams(toParams(params)).execute(new AsyncCompletionHandler<String>(){
			@Override
			public String onCompleted(Response response) throws Exception {
				return response.getResponseBody();
			}}).get();
        client.close();
        return GetResultStr;
	}
	
	public static void main(String[] args) throws JSONException, IOException, InterruptedException, ExecutionException {
		System.out.println(GetImage("a10b0532-5aaa-496e-88ee-0e9afd106db8"));
	}
	


}
