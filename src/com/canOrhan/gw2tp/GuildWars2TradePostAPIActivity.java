package com.canOrhan.gw2tp;

import com.canOrhan.gw2api.R;
import com.canOrhan.tp_api.ConnectionManager;

import android.app.Activity;
import android.os.Bundle;

public class GuildWars2TradePostAPIActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ConnectionManager cm = new ConnectionManager("test@mail.com", "testPassword");
    }
}