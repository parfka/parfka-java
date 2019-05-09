package com.parfka.command;

import java.io.IOException;

import com.parfka.Parfka;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import com.parfka.ParseConstants;
import com.parfka.ParfkaUser;
import com.parfka.callback.ProgressCallback;
import com.parfka.http.CountingHttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseUploadCommand extends ParseCommand {

	private String endPoint;
	private String contentType;
	private byte[] data;
	private ProgressCallback progressCallback;

	private static Logger LOGGER = LoggerFactory.getLogger(ParfkaUser.class);
	
	public ParseUploadCommand(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public HttpRequestBase getRequest() throws IOException {
		String url = Parfka.getParseAPIUrl(endPoint);
		LOGGER.info(url);
		HttpPost httppost = new HttpPost(url);
		setupHeaders(httppost, false);
		
		if(contentType != null) {
			httppost.addHeader(ParseConstants.HEADER_CONTENT_TYPE, contentType);
		}

		LOGGER.info("data size: " + data.length);
		if (data != null) {
			if(progressCallback != null) {
				httppost.setEntity(new CountingHttpEntity(new ByteArrayEntity(data), progressCallback));
			}
			else {
				httppost.setEntity(new ByteArrayEntity(data));
			}
		}
		return httppost;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public void setProgressCallback(ProgressCallback progressCallback) {
		this.progressCallback = progressCallback;
	}
	
	/*
	@Override
	public ParseResponse perform() throws ParseException {
		
		try {
			HttpClient httpclient = createSingleClient();
			HttpResponse httpResponse = httpclient.execute(getRequest());
			ParseResponse response = new ParseResponse(httpResponse);
			
			return response;
		}
		catch (ClientProtocolException e) {
			throw ParseResponse.getConnectionFailedException(e.getMessage());
		} 
		catch (IOException e) {
			throw ParseResponse.getConnectionFailedException(e.getMessage());
		}
	}
	*/

}
