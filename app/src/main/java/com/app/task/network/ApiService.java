package com.app.task.network;

import com.app.task.Data.Form;
import com.app.task.Data.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/task/signup")
    Call<ResponseBody> signup(@Body User user);
    @POST("/api/task/login")
    Call<ResponseBody> login(@Body User user);
    @POST("api/task/update")
    Call<ResponseBody> formsubmitting(@Body Form form);
}
