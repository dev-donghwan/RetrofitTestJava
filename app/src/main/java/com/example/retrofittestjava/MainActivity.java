package com.example.retrofittestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofittestjava.Data.DA;
import com.example.retrofittestjava.Data.Entity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RecyclerView rec;

    public static final String apiUrl = "https://www.kobis.or.kr/";
    public static final String apiKey = "3556a74b41fbe77f6fb9360a792a5e58";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getApiService().getBoxOffice(apiKey, "20200620").enqueue(new Callback<DA>() {
                    @Override
                    public void onResponse(Call<DA> call, Response<DA> response) {
                        if (response != null) {
                            Log.d("동환", "Response : " + response);
                            ArrayList<Entity> data = new ArrayList<>();
                            for (Entity item : response.body().getDTO().getEntity()) {
                                data.add(item);
                            }

                            if (rec != null) {
                                ((RecyclerAdapter) rec.getAdapter()).changeData(data);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<DA> call, Throwable t) {
                        Log.d("동환", "Error : " + t);
                    }
                });
            }
        });

        rec = findViewById(R.id.rec);
        rec.setAdapter(new RecyclerAdapter());
        rec.setLayoutManager(new LinearLayoutManager(this));
    }
}
