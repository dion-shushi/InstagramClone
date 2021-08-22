package com.example.instagram_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context c, List<Post> p){
        this.context = c;
        this.posts = p;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_username, tv_description;
        private ImageView iv_image;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tv_username = itemView.findViewById(R.id.tv_username);
            tv_description = itemView.findViewById(R.id.tv_description);
            iv_image = itemView.findViewById(R.id.iv_image);
        }

        public void bind(Post post){
            tv_description.setText(post.getKeyDescription());
            tv_username.setText(post.getKeyUser().getUsername());
            ParseFile image = post.getKeyImage();
            if (image != null){
                Glide.with(context).load(image.getUrl()).into(iv_image);
            }
        }
    }
}
