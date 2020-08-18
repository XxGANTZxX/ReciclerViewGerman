package com.example.reciclerviewantonio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reciclerviewantonio.databinding.WordItemLayoutBinding;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> { //es WordViewHolder porque es el nombre en la linea 21, luego se implementan los 3 metodos

    private List<String> wordList;

    public WordAdapter(List<String> wordList) {  //constructor de la clase
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //metodo 1 constructor del holding
        WordItemLayoutBinding mBinding = WordItemLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new WordViewHolder(mBinding); //objeto Binding
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) { //metodo 2 amarra los datos con el holder
        //holder.tv1.setText(wordList.get(position)); y en dos lineas queda asi
        String word = wordList.get(position);
        holder.tv1.setText(word);

    }

    @Override
    public int getItemCount() {   //metodo 3
        return wordList.size();  // numero total de elementos de la lista
    }


    public class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1; // porque usamos textos

        public WordViewHolder(@NonNull WordItemLayoutBinding mBinding) { //mBinding porque es "mi"(m) variable  y es rdItemLayoutBinding  por el xml
            super(mBinding.getRoot());
            tv1 = mBinding.tvTxt1;
        }
    }

}
