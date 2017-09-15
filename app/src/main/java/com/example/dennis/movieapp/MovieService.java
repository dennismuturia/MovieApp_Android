package com.example.dennis.movieapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

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


//THis is where the url is built right from the httpurl builder above
        String url = urlBuilder.build().toString();
        Log.v(TAG,"RESULT"+url);
        //THis sends the request to the site and builds it
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);


    }
    //Now lets parse JSON and create Objects
    public ArrayList<Movie>processResults(Response response){
        ArrayList<Movie>movies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                Log.v(TAG, jsonData);
                JSONObject movieObjectJSON = new JSONObject(jsonData);
                JSONArray ResultsJSON = movieObjectJSON.getJSONArray("results");
                for (int i = 0; i < ResultsJSON.length(); i++){
                    JSONObject movieObject = ResultsJSON.getJSONObject(i);
                    //Now here get every data in the JSON
                    String name = movieObject.getString("original_title");
                    String voteCount = movieObject.getString("vote_count");
                    String movieType = movieObject.getString("media_type");
                    String image = movieObject.getString("poster_path");
                    String totalCount = movieObject.getString("vote_average");

                    //Now lets bind all the data together
                    Movie movie = new Movie(name, voteCount, movieType, image, totalCount);

                    //add all this data in that class movie
                    movies.add(movie);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
        return movies;
    }
}
