package com.example.splashscreen;

import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView text_title, text_source;
    ImageView img;
    CardView cardView;


    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        text_title= itemView.findViewById(R.id.text_title);
        text_source= itemView.findViewById(R.id.textSource);
        img= itemView.findViewById(R.id.imgHeadline);
        cardView = itemView.findViewById(R.id.mainContainer);
    }
}
