package com.example.dennis.movieapp;

/**
 * Created by dennis on 9/14/17.
 */

public class Movie {
    private String mName;
    private String mVoteCount;
    private String mMediaType;
    private String mImageUrl;
    private String mTotalCount;

    //Lets create a main constructor for this class and pass the variables here

    public Movie(String name, String voteCount, String mediaType, String imageUrl, String totalCount){
        //Here is where we pass our variables in
        this.mName = name;
        this.mVoteCount = voteCount;
        this.mMediaType = mediaType;
        this.mImageUrl = imageUrl;
        this.mTotalCount = totalCount;

    }
    //Here we set the getters

    public String getName(){ return mName; }

    public String getVoteCount(){ return mVoteCount; }

    public String getMediaType(){ return mMediaType; }

    public String getImageUrl(){ return mImageUrl; }

    public String getTotalCount(){ return mTotalCount; }
}
