package com.example.forev.suleyman.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.forev.suleyman.Models.StudentModel;
import com.example.forev.suleyman.R;

import java.util.List;

public class YoklamaAdapter extends RecyclerView.Adapter<YoklamaAdapter.ViewHolder> {

    List<StudentModel> list;
    Context context;

    public YoklamaAdapter(List<StudentModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView item_ogrNo,item_ogrAdSoyad;

        public ViewHolder(View itemView) {
            super(itemView);

            item_ogrNo = (TextView)itemView.findViewById(R.id.item_ogrNo);
            item_ogrAdSoyad = (TextView)itemView.findViewById(R.id.item_ogrAdSoyad);
        }
    }

    @NonNull
    @Override
    public YoklamaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.yoklama_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoklamaAdapter.ViewHolder viewHolder, int i) {
        viewHolder.item_ogrNo.setText("Öğrenci Numarası: "+ list.get(i).getOgrNo());
        viewHolder.item_ogrAdSoyad.setText("Öğrenci Adı: "+ list.get(i).getOgrAd() + " "+ list.get(i).getOgrSoyad());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
