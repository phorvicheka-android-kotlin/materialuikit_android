package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle1Adapter extends RecyclerView.Adapter<ProfileStyle1Adapter.ItemViewHolder> {
    private static ArrayList<ProfileStyle1Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ProfileStyle1ClickListener clicklistener = null;

    public ProfileStyle1Adapter(Context ctx, ArrayList<ProfileStyle1Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title;
        private TextView loveCount;
        private TextView viewCount;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            title = (TextView) itemView.findViewById(R.id.title);
            loveCount = (TextView) itemView.findViewById(R.id.loveCount);
            viewCount = (TextView) itemView.findViewById(R.id.viewCount);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ProfileStyle1ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_profile1, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.loveCount.setText(dataList.get(position).getLoveCount());
        holder.viewCount.setText(dataList.get(position).getViewCount());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
