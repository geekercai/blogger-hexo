package space.vtility.blogger;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import java.util.ArrayList;
import java.util.List;


public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    private List<list1> mtestList;
    //private String[] mDataset = {"1"};

    static class ViewHolder extends RecyclerView.ViewHolder {
        View testview;
        TextView mTextView;

        public ViewHolder(View textView) {
            super(textView);
            testview = textView;
            mTextView = (TextView) textView.findViewById(R.id.textView);
        }
    }
    public listAdapter(List<list1> testList) {
        mtestList = testList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_text, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        return vh;

    }
    public void onBindViewHolder(ViewHolder holder, int position) {
        list1 list = mtestList.get(position);
        holder.mTextView.setText(list.getNum());
    }
    public int getItemCount() {
        return mtestList.size();
    }
}