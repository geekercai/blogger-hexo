package space.vtility.blogger;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class siteAdapter extends RecyclerView.Adapter<space.vtility.blogger.siteAdapter.ViewHolder>{

    private List<Site> mSiteList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View SiteView;
       //ImageView fruitImage;
        TextView SiteName;

        public ViewHolder(View view) {
            super(view);
            SiteView = view;
            //fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            SiteName = (TextView) view.findViewById(R.id.sitetextView);
        }
    }

    public siteAdapter(List<Site> siteList) {
        mSiteList = siteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_text, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.SiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Site fruit = mSiteList.get(position);
                //Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        /*holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Site fruit = mSiteList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Site site = mSiteList.get(position);
        //holder.fruitImage.setImageResource(fruit.getImageId());
        holder.SiteName.setText(site.getName());
    }

    @Override
    public int getItemCount() {
        return mSiteList.size();
    }

}