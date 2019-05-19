package com.example.forev.suleymanadmin.RestApi;


import com.example.forev.suleymanadmin.Models.AllWeekModel;
import com.example.forev.suleymanadmin.Models.NewWeekModel;
import com.example.forev.suleymanadmin.Models.StudentModel;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private  static ManagerAll ourInstance = new ManagerAll();

    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
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
