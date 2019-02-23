package com.example.shakil.androidrclgroupname.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.shakil.androidrclgroupname.AlphabetActivity;
import com.example.shakil.androidrclgroupname.Common.Common;
import com.example.shakil.androidrclgroupname.Model.Person;
import com.example.shakil.androidrclgroupname.R;

import java.security.acl.Group;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == Common.VIEWTYPE_GROUP) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_layout, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        } else if (viewType == Common.VIEWTYPE_PERSON) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.person_layout, viewGroup, false);
            PersonViewHolder personViewHolder = new PersonViewHolder(group);
            return personViewHolder;
        } else {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_layout, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return personList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof GroupViewHolder) {
            GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
            groupViewHolder.txt_group_title.setText(personList.get(i).getName());
            groupViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Start activity to display all alphabet character to choose
                    ((Activity) context).startActivityForResult(new Intent(context, AlphabetActivity.class), Common.REQUEST_CODE);

                }
            });
        } else if (viewHolder instanceof PersonViewHolder) {
            final PersonViewHolder personViewHolder = (PersonViewHolder) viewHolder;
            personViewHolder.txt_person_name.setText(personList.get(i).getName());
            personViewHolder.txt_person_position.setText(personList.get(i).getPosition());

            //Set Avatar
            ColorGenerator generator = ColorGenerator.MATERIAL;
            TextDrawable drawable = TextDrawable.builder().buildRound(String.valueOf(personList.get(i).getName()
                    .charAt(0)), generator.getRandomColor());

            personViewHolder.img_person_avatar.setImageDrawable(drawable);

            personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "" + personList.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    private class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView txt_group_title;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_group_title = itemView.findViewById(R.id.txt_group_title);
        }
    }

    private class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView txt_person_name, txt_person_position;
        ImageView img_person_avatar;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_person_name = itemView.findViewById(R.id.txt_person_name);
            txt_person_position = itemView.findViewById(R.id.txt_person_position);

            img_person_avatar = itemView.findViewById(R.id.person_avatar);
        }
    }
}
