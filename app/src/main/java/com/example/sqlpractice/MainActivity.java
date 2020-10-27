package com.example.sqlpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.txtview);

        SinhVien qlsv = new SinhVien(this);
        qlsv.taosv("Tran Van","Dung", "K24PM1");
        qlsv.taosv("Trinh Minh","Trung", "K24PM1");
        qlsv.taosv("Luu Trung","Thanh", "K24PM1");
        qlsv.taosv("Huong Khon","Vu", "K24PM1");

        Cursor con_tro = qlsv.getAllsv();
        String chuoi = "";
        con_tro.moveToFirst();
        do {
            chuoi+=con_tro.getString(0)+"\t\t\t";
            chuoi+=con_tro.getString(1)+"\t\t\t";
            chuoi+=con_tro.getString(2)+"\t\t\t";
            chuoi+=con_tro.getString(3)+"\n";
        }while (con_tro.moveToNext());

        tv.setText(chuoi);

    }
}