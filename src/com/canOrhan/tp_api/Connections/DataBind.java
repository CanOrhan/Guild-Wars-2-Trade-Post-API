package com.canOrhan.tp_api.Connections;

import org.apache.http.client.CookieStore;

public interface DataBind {
	void onUpdate(String newText, CookieStore cookies);
}
