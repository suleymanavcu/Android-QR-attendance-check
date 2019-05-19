package com.example.forev.suleyman.RestApi;

import com.example.forev.suleyman.Models.AllWeekModel;
import com.example.forev.suleyman.Models.LoginModel;
import com.example.forev.suleyman.Models.NewWeekModel;
import com.example.forev.suleyman.Models.StudentModel;
import com.example.forev.suleyman.Models.YoklamaModel;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private  static ManagerAll ourInstance = new ManagerAll();

    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
    }

    public Call<LoginModel> getLogin(String ogrNo, String pass)
    {
        Call<LoginModel> x = getRestApi().getLogin(ogrNo,pass);
        return  x ;
    }

    public Call<YoklamaModel> getYoklama(String ogrId, String hafta)
    {
        Call<YoklamaModel> x = getRestApi().getYoklama(ogrId,hafta);
        return  x ;
    }

    public Call<List<AllWeekModel>> getAllWeek()
    {
        Call<List<AllWeekModel>> x = getRestApi().getAllWeek();
        return  x ;
    }

    public Call<List<StudentModel>> getStudent(String hafta)
    {
        Call<List<StudentModel>> x = getRestApi().getStudent(hafta);
        return  x ;
    }

    public Call<NewWeekModel> getNewWeek(String eskihafta, String yenihafta)
    {
        Call<NewWeekModel> x = getRestApi().getNewWeek(eskihafta,yenihafta);
        return  x ;
    }
}
