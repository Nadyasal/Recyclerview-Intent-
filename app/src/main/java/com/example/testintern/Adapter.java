package com.example.testintern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context ct;
    String barang[],kode[],harga[],stok[],ket[];
    int pic[];

    public Adapter(Context ct,String barang[],String kode[],String harga[],String stok[],String ket[],int pic[]){
        this.ct = ct;
        this.barang =barang;
        this.kode = kode;
        this.pic = pic;
        this.harga = harga;
        this.stok = stok ;
        this.ket = ket;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.list_barang,parent,false);

        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.barang.setText(barang[position]);
        holder.kode.setText(kode[position]);
        holder.harga.setText(harga[position]);
        holder.pic.setImageResource(pic[position]);

        holder.mainLayout.setOnClickListener(view -> {
            Intent move = new Intent(ct, DetailActivity.class);
            move.putExtra("barang",barang[position]);
            move.putExtra("kode",kode[position]);
            move.putExtra("harga",harga[position]);
            move.putExtra("stok",stok[position]);
            move.putExtra("ket",ket[position]);
            move.putExtra("pic",pic[position]);
            ct.startActivity(move);
        });
    }

    @Override
    public int getItemCount() {
        return pic.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView barang,kode,harga;
        ImageView pic;
        ImageButton mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            barang = itemView.findViewById(R.id.barang);
            kode = itemView.findViewById(R.id.kode);
            pic = itemView.findViewById(R.id.pic);
            harga = itemView.findViewById(R.id.harga);
            mainLayout = itemView.findViewById(R.id.btn);
        }
    }
}
