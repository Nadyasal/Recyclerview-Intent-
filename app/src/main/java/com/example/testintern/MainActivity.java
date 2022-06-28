package com.example.testintern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    String barang[],kode[],harga[],stok[],ket[];
    int pic[] = {
            R.drawable.ayam,
            R.drawable.bubur,
            R.drawable.donat,
            R.drawable.mie,
            R.drawable.nasi
    };
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcvbarang);

        barang = getResources().getStringArray(R.array.barang);
        kode = getResources().getStringArray(R.array.kode);
        harga = getResources().getStringArray(R.array.harga);
        stok = getResources().getStringArray(R.array.stok);
        ket = getResources().getStringArray(R.array.ket);

        Adapter adapter = new Adapter(this,barang, kode, harga,stok,ket, pic);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }
}