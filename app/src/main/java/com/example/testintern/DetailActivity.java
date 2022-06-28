package com.example.testintern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ImageView detPic;
    TextView detbarang,detKode,detHarga,detStok,detDesk;

    String sbarang,skode,sharga,sstok,sdesk;
    int spic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detPic          = findViewById(R.id.detPic);
        detbarang       = findViewById(R.id.detBarang);

        detKode         = findViewById(R.id.detKode);
        detHarga        = findViewById(R.id.detHarga);
        detStok         = findViewById(R.id.detStok);
        detDesk         = findViewById(R.id.detDesk);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("pic")
            && getIntent().hasExtra("barang")
            && getIntent().hasExtra("kode")
            && getIntent().hasExtra("harga")){

            spic = getIntent().getIntExtra("pic",1);
            sbarang = getIntent().getStringExtra("barang");

            skode = getIntent().getStringExtra("kode");
            sharga = getIntent().getStringExtra("harga");
            sstok = getIntent().getStringExtra("stok");
            sdesk = getIntent().getStringExtra("ket");

        }else{
            Toast.makeText(this, "Data tidak ditemukan.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        detPic.setImageResource(spic);
        detbarang.setText(sbarang);

        detKode.setText(skode);
        detHarga.setText(sharga);
        detStok.setText(sstok);
        detDesk.setText(sdesk);
    }
}