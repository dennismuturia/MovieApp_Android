package com.example.dennis.movieapp;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by dennis on 9/14/17.
 */

public class MovieService {
    private static final String TAG = MovieActivity.class.getSimpleName() ;

    public static void theMovies(String query, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();
        //Now this is interacting with the api to display data
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIE_API_KEY_HOLDER, Constants.MOVIE_API_KEY);
        urlBuilder.addQueryParameter(Constants.MOVIE_LOCATION_QUERY_PARAMETER,query);



        String url = urlBuilder.build().toString();
        Log.v(TAG,"RESULT"+url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);


    }
}
