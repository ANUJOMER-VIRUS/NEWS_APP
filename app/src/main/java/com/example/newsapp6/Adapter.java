package com.example.newsapp6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Modalclass> modalclassArrayList;

    public Adapter(Context context, ArrayList<Modalclass> modalclassArrayList) {
        this.context = context;
        this.modalclassArrayList = modalclassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Modalclass modalclass=modalclassArrayList.get(holder.getAdapterPosition());
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent=new Intent(context,webView.class);
            intent.putExtra("url",modalclass.getUrl());
            context.startActivity(intent);
        }
    });

    holder.mtime.setText("Published At :-"+modalclass.getPublishat());
    holder.mauthor.setText(modalclass.getAuthor());
        holder.mheading.setText(modalclass.getTitle());
        holder.mcontent.setText(modalclass.getDescription());
        Picasso.get().load(modalclass.getUrltoimage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return modalclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);

            mauthor=itemView.findViewById(R.id.author);

            mtime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}
