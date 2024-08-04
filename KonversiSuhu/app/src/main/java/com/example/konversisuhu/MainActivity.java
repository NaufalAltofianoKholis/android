package com.example.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        load();
//        isiSpinner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public  void load(){
        spinner = findViewById(R.id.spinner);
        etNilai=findViewById(R.id.etNilai);
        tvHasil=findViewById(R.id.tvHasil);
    }

//    public void isiSpinner(){
//        String[] isi ={"Celcius to Reamur","Celcius to Farenheit","Celcius to Kelvin",};
//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
//        spinner.setAdapter(adapter);
//    }

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        if (etNilai.getText().toString().equals("")) {
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            if (pilihan.equals("Celcius to Reamur")) {
                cTor();
            }
            else if (pilihan.equals("Celcius to Farenheit")) {
                cTof();
            }
            else if (pilihan.equals("Celcius to Kelvin")) {
                cTok();
            }
            else if (pilihan.equals("Farenheit to Celcius")) {
                fToc();
            }
            else if (pilihan.equals("Farenheit to Farenheit")) {
                fTor();
            }
            else if (pilihan.equals("Farenheit to Kelvin")) {
                fTok();
            }
        }
    }
    public void cTor(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =((double) 4/5)*suhu;
        tvHasil.setText(hasil+"");
    }
    public void cTof(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =((double) 9/5)*suhu+32;
        tvHasil.setText(hasil+"");
    }
    public void cTok(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =suhu+273;
        tvHasil.setText(hasil+"");
    }
    public void fToc(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =((double) 5/9)*(suhu-32);
        tvHasil.setText(hasil+"");
    }
    public void fTor(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =((double) 4-9)*(suhu-32);
        tvHasil.setText(hasil+"");
    }
    public void fTok(){
        double suhu =Double.parseDouble(etNilai.getText().toString());
        double hasil =((double)5/9)*(suhu-32)+273;
        tvHasil.setText(hasil+"");
    }


}