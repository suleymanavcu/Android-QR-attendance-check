package com.example.forev.suleymanadmin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forev.suleymanadmin.Adapters.YoklamaAdapter;
import com.example.forev.suleymanadmin.Models.AllWeekModel;
import com.example.forev.suleymanadmin.Models.NewWeekModel;
import com.example.forev.suleymanadmin.Models.StudentModel;
import com.example.forev.suleymanadmin.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner adminSpinner;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;

    RecyclerView adminRecyclerView;
    List<StudentModel> listStudent;
    YoklamaAdapter yoklamaAdapter;
    Button yoklamaButton;
    TextView countOgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        define();
        getWeekInfo();
    }

    public void define()
    {
        adminSpinner = (Spinner)findViewById(R.id.adminSpinner);
        adminRecyclerView = (RecyclerView)findViewById(R.id.adminRecyclerView);
        yoklamaButton = (Button)findViewById(R.id.yoklamaButton);
        countOgr = (TextView)findViewById(R.id.countOgr);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        adminRecyclerView.setLayoutManager(layoutManager);
        listStudent = new ArrayList<>();
    }

    public void getWeekInfo()
    {
        Call<List<AllWeekModel>> req = ManagerAll.getInstance().getAllWeek();
        req.enqueue(new Callback<List<AllWeekModel>>() {
            @Override
            public void onResponse(Call<List<AllWeekModel>> call, final Response<List<AllWeekModel>> response) {

                list = new ArrayList<>();
                for (int i =0; i<response.body().size();i++)
                {
                    list.add(response.body().get(i).getHaftaIsim());
                    adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
                    adminSpinner.setAdapter(adapter);

                    adminSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            getStudent(adminSpinner.getSelectedItem().toString());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }



            }

            @Override
            public void onFailure(Call<List<AllWeekModel>> call, Throwable t) {

            }
        });
    }

    public void getStudent(final String hafta)
    {
        Call<List<StudentModel>> req = ManagerAll.getInstance().getStudent(hafta);
        req.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                listStudent = response.body();
                if(response.body().size() != 0)
                {

                    countOgr.setText("Öğrenci sayısı: "+response.body().size() );

                    yoklamaAdapter = new YoklamaAdapter(listStudent,getApplicationContext());
                    adminRecyclerView.setAdapter(yoklamaAdapter);
                    adminRecyclerView.setVisibility(View.VISIBLE);
                    yoklamaButton.setVisibility(View.VISIBLE);

                    yoklamaButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            changeWeekName(hafta,"done"+hafta.substring(5, hafta.length()));
                        }
                    });
                }
                else
                {
                    adminRecyclerView.setVisibility(View.INVISIBLE);
                    yoklamaButton.setVisibility(View.INVISIBLE);
                    countOgr.setText("Öğrenci sayısı: "+response.body().size() );
                }
            }

            @Override
            public void onFailure(Call<List<StudentModel>> call, Throwable t) {

            }
        });
    }

    public void changeWeekName(String eskiHafta,String yeniHafta)
    {
        Call<NewWeekModel> req = ManagerAll.getInstance().getNewWeek(eskiHafta,yeniHafta);
        req.enqueue(new Callback<NewWeekModel>() {
            @Override
            public void onResponse(Call<NewWeekModel> call, Response<NewWeekModel> response) {
                listStudent.clear();
                getWeekInfo();
                Toast.makeText(getApplicationContext(),"Yoklama tablosu kaydedilmiştir.",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<NewWeekModel> call, Throwable t) {

            }
        });
    }
}
