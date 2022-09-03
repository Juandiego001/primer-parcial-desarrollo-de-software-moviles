package com.example.primerparcial;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.primerparcial.AdminSQLHelper;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInsertar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
    }

    public void insertarPersona(View v) {
        EditText edNombre = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText edApellido = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText edNvlHem = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText edCorreo = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText edEdad = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText edSexo = (EditText) findViewById(R.id.editTextTextPersonName6);

        AdminSQLHelper admin = new AdminSQLHelper(this, "db_pacientes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Log.d("edNombre", edNombre.getText().toString());
        Log.d("edApellido", edApellido.getText().toString());
        Log.d("edNvlHem", edNvlHem.getText().toString());
        Log.d("edCorreo", edCorreo.getText().toString());
        Log.d("edEdad", edEdad.getText().toString());
        Log.d("edSexo", edSexo.getText().toString());

        String nombre = edNombre.getText().toString();
        String apellido = edApellido.getText().toString();
        double nvlHem = Double.parseDouble(edNvlHem.getText().toString());
        String correo = edCorreo.getText().toString();
        int edad = Integer.parseInt(edEdad.getText().toString());
        String sexo = edSexo.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("nvlHem", nvlHem);
        registro.put("correo", correo);
        registro.put("edad", edad);
        registro.put("sexo", sexo);

        bd.insert("paciente", null, registro);
        bd.close();

        edNombre.setText("");
        edNombre.setText("");
        edApellido.setText("");
        edNvlHem.setText("");
        edCorreo.setText("");
        edEdad.setText("");
        edSexo.setText("");
    }
}

