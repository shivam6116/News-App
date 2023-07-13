package com.example.splashscreen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashscreen.R;
import com.example.splashscreen.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txtTitle, txtAuthor,txtTime,txtDetail,txtContent;
    ImageView imgNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtTitle=findViewById(R.id.textDetailTitle);
        txtAuthor=findViewById(R.id.textDetailAuthor);
        txtTime=findViewById(R.id.textDetailTime);
        txtDetail=findViewById(R.id.textDetailDetail);
        txtContent=findViewById(R.id.textDetailContent);
        imgNews=findViewById(R.id.imgDetailNews);

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        txtTitle.setText(headlines.getTitle());
        txtAuthor.setText(headlines.getAuthor());
        txtTime.setText(headlines.getPublishedAt());
        txtDetail.setText(headlines.getDesc());
        txtContent.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(imgNews);

    }
}