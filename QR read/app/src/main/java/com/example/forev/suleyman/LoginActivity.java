package com.example.forev.suleyman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.forev.suleyman.Models.LoginModel;
import com.example.forev.suleyman.RestApi.ManagerAll;
import com.example.forev.suleyman.Utils.GetSharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        define();
        action();
    }

    public void define(){
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btLogin = (Button)findViewById(R.id.btLogin);
    }

    public void action()
    {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ogrno = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Toast.makeText(getApplicationContext(),"Giriş yapılıyor...",Toast.LENGTH_LONG).show();
                login(ogrno,password);
            }
        });
    }

    public void login(String ogrno,String password)
    {
        Call<LoginModel> req = ManagerAll.getInstance().getLogin(ogrno,password);

        req.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.body().isTf())
                {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    GetSharedPreferences getSharedPreferences = new GetSharedPreferences(LoginActivity.this);
                    getSharedPreferences.setSession(response.body().getId().toString(),response.body().getOgrNo().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),response.body().getText(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"internet bağlantınızı kontrol edin.",Toast.LENGTH_LONG).show();
            }
        });
    }


}
