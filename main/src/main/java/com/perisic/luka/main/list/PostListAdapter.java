package com.perisic.luka.main.list;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.perisic.luka.main.R;
import com.perisic.luka.remote.data.response.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luka Perisic on 4.9.2019..
 */
public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostListViewHolder> {

    private List<Post> dataList = new ArrayList<>();
    private OnPostClickListener onPostClickListener;

    PostListAdapter(OnPostClickListener onPostClickListener) {
        this.onPostClickListener = onPostClickListener;
    }

    @NonNull
    @Override
    public PostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostListViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostListViewHolder holder, int position) {
        holder.onBind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    void addItems(List<Post> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    class PostListViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutPost;
        private TextView textViewTitle;
        private ImageView imageViewPost;

        PostListViewHolder(View itemView) {
            super(itemView);
            linearLayoutPost = itemView.findViewById(R.id.linear_layout_post);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            imageViewPost = itemView.findViewById(R.id.image_view_post);
        }

        void onBind(Post post) {
            linearLayoutPost.setOnClickListener(v -> onPostClickListener.onPostClick(post.getId()));
            try {
                linearLayoutPost.setBackgroundColor(Color.parseColor(post.getColor()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            textViewTitle.setText(post.getTitle());
            Glide.with(imageViewPost)
                    .load(post.getUrl())
                    .placeholder(new ColorDrawable(ContextCompat.getColor(itemView.getContext(), R.color.colorAccent)))
                    .into(imageViewPost);
        }
    }

    interface OnPostClickListener {
        void onPostClick(int postId);
    }
}