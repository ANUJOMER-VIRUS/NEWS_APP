package com.example.newsapp6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homefragment extends Fragment {
    String Api="6fc0efa037ac4369b32b336e4edfd4a4";
    ArrayList<Modalclass> modalclassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewhome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.homefragment,null);
        recyclerViewhome=view.findViewById(R.id.recyclerviewhome);
        modalclassArrayList=new ArrayList<>();
        recyclerViewhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modalclassArrayList);
        recyclerViewhome.setAdapter(adapter);
        findNews();
        return view;
    }

    private void findNews() {
    ApiUtilites.getApiInterface().getNews(country,100,Api).enqueue(new Callback<MainNews>() {
        @Override
        public void onResponse(Call<MainNews> call, Response<MainNews> response) {
            if(response.isSuccessful()){
                modalclassArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<MainNews> call, Throwable t) {

        }
    });

    }
}
