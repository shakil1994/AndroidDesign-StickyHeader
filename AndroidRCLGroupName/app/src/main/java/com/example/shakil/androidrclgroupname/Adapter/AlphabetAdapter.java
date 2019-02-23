package com.example.shakil.androidrclgroupname.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.shakil.androidrclgroupname.Common.Common;
import com.example.shakil.androidrclgroupname.Interface.IOnAlphabetClickListener;
import com.example.shakil.androidrclgroupname.R;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.MyViewHolder> {

    List<String> alphabetList;
    IOnAlphabetClickListener iOnAlphabetClickListener;

    public void setiOnAlphabetClickListener(IOnAlphabetClickListener iOnAlphabetClickListener) {
        this.iOnAlphabetClickListener = iOnAlphabetClickListener;
    }

    public AlphabetAdapter() {
        alphabetList = Common.getAlphabet();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alphabet_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        TextDrawable drawable;
        //Get available position of character
        final int available_position = Common.alphabet_available.indexOf(alphabetList.get(i));

        //If character is available in list
        if (available_position != -1) {
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i), Color.GREEN);
        } else {
            //If character is not in alphabet , just set GRAY
            drawable = TextDrawable.builder().buildRound(alphabetList.get(i), Color.GRAY);
        }

        myViewHolder.alphabet_avatar.setImageDrawable(drawable);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When user choose alphabet character, just go back MainActivity and scroll to position of first character
                iOnAlphabetClickListener.onAlphabetClickListener(alphabetList.get(i), i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alphabetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView alphabet_avatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            alphabet_avatar = itemView.findViewById(R.id.alphabet_avatar);
        }
    }
}
