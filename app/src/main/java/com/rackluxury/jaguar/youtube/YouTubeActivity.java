package com.rackluxury.jaguar.youtube;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.rackluxury.jaguar.R;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class YouTubeActivity extends AppCompatActivity {
    private static final String[] YOUTUBE_PLAYLISTS = {


            "PLzbdvw99SKOc3SU2SOa2RPem4c5K65cA-",
            "PLzbdvw99SKOfT2OsAOh7XCUbGZK6HBf9I",
            "PLzbdvw99SKOcjhFFVQRR5gBcfcFDOydJf",
            "PLzbdvw99SKOfYPo4PWHp0UFm_-egpG_Og",
            "PLzbdvw99SKOfdIdiuoIqBu_XFiQknFqC2",
            "PLzbdvw99SKOdlHGDEit4UVeZwECS5yArg",
            "PLzbdvw99SKOftuYTVWupROY5a4Yd8Q-7c",
            "PLzbdvw99SKOdxBVj3KunYmqloQrKiI51y"

    };
    private final GsonFactory mJsonFactory = new GsonFactory();
    private final HttpTransport mTransport = AndroidHttp.newCompatibleTransport();
    private YouTube mYoutubeDataApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_activity);


        if (!isConnected()) {
            Toast.makeText(YouTubeActivity.this, "No Internet Connection Detected", Toast.LENGTH_LONG).show();
        }

        if (com.rackluxury.jaguar.youtube.ApiKey.YOUTUBE_API_KEY.startsWith("YOUR_API_KEY")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setMessage("Edit ApiKey.java and replace \"YOUR_API_KEY\" with your Applications Browser API Key")
                    .setTitle("Missing API Key")
                    .setNeutralButton("Ok, I got it!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else if (savedInstanceState == null) {
            mYoutubeDataApi = new YouTube.Builder(mTransport, mJsonFactory, null)
                    .setApplicationName(getResources().getString(R.string.app_name))
                    .build();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, com.rackluxury.jaguar.youtube.YouTubeRecyclerViewFragment.newInstance(mYoutubeDataApi, YOUTUBE_PLAYLISTS))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.you_tube, menu);
        return true;
    }

    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_recyclerview) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, com.rackluxury.jaguar.youtube.YouTubeRecyclerViewFragment.newInstance(mYoutubeDataApi, YOUTUBE_PLAYLISTS))
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
