package com.canOrhan.tp_api.Connections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class ConnectionManager {
	public HttpResponse response;
	public CookieStore cs = new BasicCookieStore();
	
	public ConnectionManager(String email, String password, DataBind onStateChange)
	{
		    // Create a new HttpClient and Post Header
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost("https://account.guildwars2.com/login");
		    HttpContext localContext = new BasicHttpContext();
		    localContext.setAttribute(ClientContext.COOKIE_STORE, cs);
		    
		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("email", email));
		        nameValuePairs.add(new BasicNameValuePair("password", password));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        
		        //Add headers
		        httppost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		        httppost.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
		        httppost.addHeader("Accept-Encoding", "deflate");
		        httppost.addHeader("Accept-Language", "en-US,en;q=0.8");
		        httppost.addHeader("Cache-Control", "max-age=0");
		        httppost.addHeader("Connection","keep-alive");
		        httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
		        httppost.addHeader("Cookie", "__utma=159804514.329002168.1346334558.1347690665.1348333111.5; __utmz=159804514.1347690665.4.4.utmcsr=t.co|utmccn=(referral)|utmcmd=referral|utmcct=/nRRWuuxk");
		        httppost.addHeader("DNT", "1");
		        httppost.addHeader("Host", "account.guildwars2.com");
		        httppost.addHeader("Origin", "https://account.guildwars2.com");
		        httppost.addHeader("Referer","https://account.guildwars2.com/login?redirect_uri=http%3A%2F%2Ftradingpost-live.ncplatform.net%2Fauthenticate%3Fsource%3D%252F&game_code=gw2");
		        httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1");
		        
		        // Execute HTTP Post Request
		        response = httpclient.execute(httppost, localContext);
		        
		        onStateChange.onUpdate(response.getStatusLine().toString(), cs);
		    } catch (ClientProtocolException e) {
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }	
	}
}
