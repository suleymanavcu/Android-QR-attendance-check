package com.example.forev.suleyman.RestApi;

import com.example.forev.suleyman.Models.AllWeekModel;
import com.example.forev.suleyman.Models.LoginModel;
import com.example.forev.suleyman.Models.NewWeekModel;
import com.example.forev.suleyman.Models.StudentModel;
import com.example.forev.suleyman.Models.YoklamaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("/yoklamafolder/login.php")
    Call<LoginModel> getLogin(@Field("ogrNo") String ogrNo, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("/yoklamafolder/yoklamaekle.php")
    Call<YoklamaModel> getYoklama(@Field("ogrId") String ogrId,@Field("hafta") String hafta);

    @GET("/yoklamafolder/listallweek.php")
    Call<List<AllWeekModel>> getAllWeek();

    @FormUrlEncoded
    @POST("/yoklamafolder/liststudent.php")
    Call<List<StudentModel>> getStudent(@Field("hafta") String hafta);

    @FormUrlEncoded
    @POST("/yoklamafolder/done.php")
    Call<NewWeekModel> getNewWeek(@Field("eskihafta") String eskihafta, @Field("yenihafta") String yenihafta);
}
