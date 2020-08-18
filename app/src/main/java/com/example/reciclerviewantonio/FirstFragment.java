package com.example.reciclerviewantonio;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reciclerviewantonio.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding bind;
    private RecyclerView mRecyclerView;
    private WordAdapter mWordAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        bind = FragmentFirstBinding.inflate(inflater, container, false);

        mRecyclerView = bind.rvContenedor1;  //Se refiere al elemento RV
        mWordAdapter = new WordAdapter(getWordData());  //debe tener el listado de string en este caso es el metodo.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mWordAdapter);

        Log.d("TAG", String.valueOf(getWordData()));
        return bind.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private List<String> getWordData(){
        List<String> wordData= new ArrayList<>();
        for (int i=0;i<=49;i++) {
        wordData.add("word"+i);
        }
    return wordData;
    }

}