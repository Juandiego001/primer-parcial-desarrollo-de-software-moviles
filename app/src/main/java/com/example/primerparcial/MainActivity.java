package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import com.example.primerparcial.AdminSQLHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irConsultar(View v) {
        Intent intentConsultar = new Intent(this, ActivityConsultar.class);
        startActivity(intentConsultar);
    }

    public void irModificar(View v) {
        Intent intentModificar = new Intent(this, ActivityModificar.class);
        startActivity(intentModificar);
    }

    public void irEliminar(View v) {
        Intent intentEliminar = new Intent(this, ActivityEliminar.class);
        startActivity(intentEliminar);
    }

    public void irInsertar(View v) {
        Intent intentInsertar = new Intent(this, ActivityInsertar.class);
        startActivity(intentInsertar);
    }
}