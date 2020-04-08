package com.example.lightjam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GroupRecyclerUtils {

    static class groupHolder extends RecyclerView.ViewHolder{
        public final TextView text;
        public final ImageView img;
        public groupHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_title);
            img = itemView.findViewById(R.id.item_image);
        }
    }

    static class GroupCallBack extends DiffUtil.ItemCallback<Group>{

        @Override
        public boolean areItemsTheSame(@NonNull Group group, @NonNull Group t1) {
            return group == t1;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Group group, @NonNull Group t1) {
            return group.equals(t1);
        }
    }



    interface GroupClickCallback {
        void onGroupClick(Group group);
    }


    static class GroupAddapter extends ListAdapter<Group, groupHolder>{

        public GroupAddapter(){
            super(new GroupCallBack());
        }

        public GroupClickCallback callback;
        @NonNull
        @Override
        public groupHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            View itemView = LayoutInflater.from(context).inflate(R.layout.card_layout,viewGroup,false);
            final groupHolder holder = new groupHolder(itemView);
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Group group = getItem(holder.getAdapterPosition());
                    if (callback != null)
                        callback.onGroupClick(group);
                    return true;
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull groupHolder holder, int i) {
            Group group = getItem(i);
            holder.text.setText(group.group_name);
            Picasso.get().setLoggingEnabled(true);
            Picasso.get().load(group.img_url).into(holder.img);



        }
    }







}