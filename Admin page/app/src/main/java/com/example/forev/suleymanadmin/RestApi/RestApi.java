package com.example.forev.suleymanadmin.RestApi;


import com.example.forev.suleymanadmin.Models.AllWeekModel;
import com.example.forev.suleymanadmin.Models.NewWeekModel;
import com.example.forev.suleymanadmin.Models.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {

    @GET("/yoklamafolder/listallweek.php")
    Call<List<AllWeekModel>> getAllWeek();

    @FormUrlEncoded
    @POST("/yoklamafolder/liststudent.php")
    Call<List<StudentModel>> getStudent(@Field("hafta") String hafta);

    @FormUrlEncoded
    @POST("/yoklamafolder/done.php")
    Call<NewWeekModel> getNewWeek(@Field("eskihafta") String eskihafta, @Field("yenihafta") String yenihafta);
}
