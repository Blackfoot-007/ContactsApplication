package com.example.contactsapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapplication.R;
import com.example.contactsapplication.model.DetailsClass;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ContactsViewHolder> {
    Context context;
    List<DetailsClass> detailsClassList;

    public AdapterView(Context context, List<DetailsClass> detailsClassList) {
        this.context = context;
        this.detailsClassList = detailsClassList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewrecycledata,parent,false);

        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final DetailsClass detailsClass = detailsClassList.get(position);
        holder.imgview.setImageResource(detailsClass.getImagenumber());
        holder.rsname.setText(detailsClass.getName());
        holder.rsgenders.setText(detailsClass.getGender());
        holder.rsages.setText(detailsClass.getAge());

    }

    @Override
    public int getItemCount() {
        return detailsClassList.size();
    }


    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgview;
        TextView rsname, rsgenders, rsages;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imageView);
            rsname = itemView.findViewById(R.id.rsname);
            rsname = itemView.findViewById(R.id.rsage);
            rsgenders = itemView.findViewById(R.id.rsgender);
        }
    }
}

