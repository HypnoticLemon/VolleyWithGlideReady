package com.hypnoticlemon.testapplicationjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.Glide;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.SignleRowHolder> {
    private Context context;
    private List<DemoModel> demoModelList;
    OnRecyclerItemClickListener listener;

    public DemoAdapter(Context context, List<DemoModel> demoAdapterList, OnRecyclerItemClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.demoModelList = demoAdapterList;
    }

    @NonNull
    @Override
    public SignleRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SignleRowHolder(LayoutInflater.from(context).inflate(R.layout.single_row_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SignleRowHolder holder, final int position) {
        Glide.with(context)
                .load(demoModelList.get(position).getImagePath())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher))
                .into(holder.imgIcon);

        holder.txtTitle.setText(demoModelList.get(position).getTitle());

        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ItemClick(position, "", null, position);
            }
        });

        holder.imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ItemClick(position, "", null, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (demoModelList != null ? demoModelList.size() : 0);
    }

    public class SignleRowHolder extends RecyclerView.ViewHolder {
        private ImageView imgIcon;
        private TextView txtTitle;

        public SignleRowHolder(View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
