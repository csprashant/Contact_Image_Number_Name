package com.example.readcontancts_number_name_image.adaptor;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readcontancts_number_name_image.R;
import com.example.readcontancts_number_name_image.model.PhoneContacts;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerPhoneAdapter extends RecyclerView.Adapter<RecyclerPhoneAdapter.ViewHolder> {
List<PhoneContacts> phoneContactsList;

    public RecyclerPhoneAdapter(List<PhoneContacts> phoneContactsList) {
        this.phoneContactsList = phoneContactsList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerPhoneAdapter.ViewHolder holder, int position) {
        PhoneContacts phoneContacts=phoneContactsList.get(holder.getAdapterPosition());
        holder.imageView.setImageURI(phoneContacts.getImageUrl());
        holder.name.setText(phoneContacts.getName());
        holder.number.setText(phoneContacts.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return phoneContactsList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,number;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            number=itemView.findViewById(R.id.number);
        }
    }
}
