package com.canOrhan.gw2tp;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.canOrhan.gw2api.R;
import com.canOrhan.tp_api.Connections.ConnectionManager;
import com.canOrhan.tp_api.Connections.DataBind;

public class GuildWars2TradePostAPIActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView tv = (TextView) findViewById(R.id.textView);
        final ConnectionManager cm = new ConnectionManager("test@gmail.com", "password", new DataBind() {

			public void onUpdate(String newText, CookieStore cookies) {
				tv.setText(newText);
				for(Cookie c : cookies.getCookies())
				{
					tv.setText(tv.getText() + "\n" + c.getName() + " - " + c.getValue());
				}
			}
		});
    }
}