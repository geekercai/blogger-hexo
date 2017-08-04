package space.vtility.blogger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class siteListActivity extends AppCompatActivity {
    //String siteDomain = SiteView.mSiteDomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getSharedPreferences("swap",MODE_PRIVATE);
        String siteDomain = pref.getString("swap","https://www.imys.net/");//github 插件作者的blog

        StringBuffer domain = new StringBuffer(siteDomain);
        domain.append("/api/posts.json");
        String post = domain.toString();

        //get posts list
        try{
            OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(post)
                .build();
        Response response = client.newCall(request).execute();
        String responseData = response.body().string();
            parseJSONWithJSONObject(responseData);
        }catch (Exception e){
            e.printStackTrace();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private void parseJSONWithJSONObject(String jsonData){

        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String path = jsonObject.getString("path");
        }

    }catch (Exception e){
            e.printStackTrace();
         }
    }
}
