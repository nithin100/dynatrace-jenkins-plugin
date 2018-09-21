package com.nithin.jenkins;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestConnection {

	OkHttpClient client = new OkHttpClient();

	boolean run(String environment, String apiToken) throws IOException {

		String url = "https://" + environment + ".live.dynatrace.com/api/v1/timeseries";
		String apiTokenHeader = "Api-Token " + apiToken;

		// String encodedHeader =
		// ByteString.encodeUtf8(apiTokenHeader).base64();

		Request request = new Request.Builder().url(url).header("Authorization", apiTokenHeader).build();

		Response response = client.newCall(request).execute();
		if (response.code() == 200) {
			return true;
		} else {
			return false;
		}

	}

}
