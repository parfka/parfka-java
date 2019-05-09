package com.parfka.command;

import com.parfka.Parfka;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpRequestBase;

public class ParseDeleteCommand extends ParseCommand {

	private String endPoint;
	private String objectId;

	public ParseDeleteCommand(String endPoint, String objectId) {
		this.endPoint = endPoint;
		this.objectId = objectId;
	}

	public ParseDeleteCommand(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public HttpRequestBase getRequest() {
		String url = Parfka.getParseAPIUrl(endPoint)
				+ (objectId != null ? "/" + objectId : "");
		HttpDelete httpdelete = new HttpDelete(url);
		setupHeaders(httpdelete, false);
		return httpdelete;
	}

}
