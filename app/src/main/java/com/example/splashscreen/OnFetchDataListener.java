package com.example.splashscreen;

import com.example.splashscreen.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list , String message);
    void onError(String msg);
}
