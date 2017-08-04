package space.vtility.blogger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class siteAdapter extends RecyclerView.Adapter<space.vtility.blogger.siteAdapter.ViewHolder>{

    private List<Site> mSiteList;
    private Activity mActivity;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View SiteView;
        TextView SiteName;

        public ViewHolder(View view) {
            super(view);
            SiteView = view;
            SiteName = (TextView) view.findViewById(R.id.sitetextView);
        }
    }

    public siteAdapter(Activity activity,List<Site> siteList) {
        mSiteList = siteList;
        mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_text, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.SiteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();

                Site msite = mSiteList.get(position);

                String mSiteDomain = msite.getName();

                SharedPreferences.Editor editor = mActivity.getSharedPreferences("swap",MODE_PRIVATE).edit();
                editor.putString("swap",mSiteDomain);
                editor.apply();

                Intent intent = new Intent(mActivity, siteListActivity.class);

                mActivity.startActivity(intent);

            }



        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Site site = mSiteList.get(position);
        holder.SiteName.setText(site.getName());

    }

    @Override
    public int getItemCount() {
        return mSiteList.size();
    }

}