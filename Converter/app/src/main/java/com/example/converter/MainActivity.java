package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Цельсие
    TextView tvInchIn;
    EditText edInch;
    Button   btnInch;
    TextView tvInchOut;

    // Радианы
    TextView tvRadIn;
    EditText edGrad;
    Button   btnRad;
    TextView tvRadOut;

    // Градусы
    TextView tvRad;
    EditText edRadIn;
    TextView tvGradOut;

    // Рубли
    TextView tvDollIn;
    EditText edDoll;
    Button   btnDoll;
    TextView tvDollOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Цельсие
        tvInchIn  = (TextView) findViewById(R.id.tvInchIn);
        edInch    = (EditText) findViewById(R.id.edInch);
        btnInch   = (Button) findViewById(R.id.btnInch);
        tvInchOut = (TextView) findViewById(R.id.tvInchOut);

        // Радианы
        tvRadIn  = (TextView) findViewById(R.id.tvGradIn);
        edGrad   = (EditText) findViewById(R.id.edGrad);
        btnRad   = (Button) findViewById(R.id.btnRadCalc);
        tvRadOut = (TextView) findViewById(R.id.tvRadOut);

        // Градусы, кнопку не извлекаем - обработчик назначен ей в разметке
        tvRad     = (TextView) findViewById(R.id.tvRadIn);
        edRadIn   = (EditText) findViewById(R.id.edRadIn);
        tvGradOut = (TextView) findViewById(R.id.tvGradOut);

        // Рубли
        tvDollIn  = (TextView) findViewById(R.id.tvDollIn);
        edDoll    = (EditText) findViewById(R.id.edDoll);
        btnDoll   = (Button) findViewById(R.id.btnDoll);
        tvDollOut = (TextView) findViewById(R.id.tvDollOut);

        View.OnClickListener btnInchClicker = new View.OnClickListener() {
            // Цельсие ананим класс
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnInch) {
                    String strInch = edInch.getText().toString();
                    // проверка на пустоту
                    if(TextUtils.isEmpty(strInch) == true)
                        return;
                    float inch = Float.parseFloat(strInch);
                    float cm = inch * 2.54f;
                    String strCm = String.valueOf(cm);
                    tvInchOut.setText((strCm));
                }
                if (view.getId() == R.id.btnDoll)
                {
                    // доллары
                    String strDoll = edDoll.getText().toString();
                    // проверка на пустоту
                    if(TextUtils.isEmpty(strDoll) == true)
                        return;
                    double doll = Double.parseDouble(strDoll);
                    double rub = doll * 89.2;
                    String strRub = String.valueOf(rub);
                    tvDollOut.setText(strRub);
                }
            }
        };

        btnInch.setOnClickListener(btnInchClicker);
        btnDoll.setOnClickListener(btnInchClicker);
        btnRad.setOnClickListener(this); // this =обращение к этому классу-окну
    }


    @Override
    public void onClick(View view) {
        // Радианы, тут технология - интерфейс, обработчик от интерфейса
        if (view.getId() == R.id.btnRadCalc) {
            String strGrad = edGrad.getText().toString();
            // проверка на пустоту
            if(TextUtils.isEmpty(strGrad) == true)
                return;
            double grad = Double.parseDouble(strGrad);
            double radian = grad * Math.PI / 180.0;
            String strRad = String.valueOf(radian);
            tvRadOut.setText((strRad));
        }
        // Градусы, тут технология - обработчик в самой кнопке
        else
        {
            String radian = edRadIn.getText().toString();
            // проверка на пустоту
            if(TextUtils.isEmpty(radian) == true)
                return;
            double rad = Double.parseDouble(radian);
            double grad = rad * 180.0 / Math.PI;
            String gradStr = String.valueOf(grad);
            tvGradOut.setText(gradStr);
        }
    }
}