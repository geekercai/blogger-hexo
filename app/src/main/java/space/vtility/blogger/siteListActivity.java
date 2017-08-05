package space.vtility.blogger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class siteListActivity extends AppCompatActivity {
    String[] postTitle = new String[200];
    String[] path = new String[200];
    String siteDomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getSharedPreferences("swap", MODE_PRIVATE);
        siteDomain = pref.getString("swap", "https://www.imys.net/");//插件作者的blog

        sendRequestWithOkHttp();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                siteListActivity.this, android.R.layout.simple_list_item_1, postTitle);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private void sendRequestWithOkHttp() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuffer domain = new StringBuffer(siteDomain);
                    domain.append("/api/posts.json");
                    final String post = domain.toString();
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(post)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.d("siteListActivity", "output" + responseData);
                    parseJSONWithJSONObject(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    private void parseJSONWithJSONObject(String jsonData) {


        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                postTitle[i] = jsonObject.getString("title");
                path[i] = jsonObject.getString("path");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

