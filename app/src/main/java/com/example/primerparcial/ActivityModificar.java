package com.example.primerparcial;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
    }

    public void consultarModificar(View v) {
        AdminSQLHelper admin = new AdminSQLHelper(this, "db_pacientes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        EditText edCorreo = (EditText) findViewById(R.id.editTextTextPersonName8);
        EditText edNombre = (EditText) findViewById(R.id.editTextTextPersonName9);
        EditText edApellido = (EditText) findViewById(R.id.editTextTextPersonName10);
        EditText edNvlHem = (EditText) findViewById(R.id.editTextTextPersonName11);
        EditText edEdad = (EditText) findViewById(R.id.editTextTextPersonName12);
        EditText edSexo = (EditText) findViewById(R.id.editTextTextPersonName13);
        String correoPersona = edCorreo.getText().toString();

        Cursor cursorConsulta = bd.rawQuery("SELECT * FROM paciente WHERE correo = ?", new String[] {correoPersona});

        if (cursorConsulta.moveToFirst()) {
            String correo = cursorConsulta.getString(0);
            String nombre = cursorConsulta.getString(1);
            String apellido = cursorConsulta.getString(2);
            double nvlHem = cursorConsulta.getDouble(3);
            int edad = cursorConsulta.getInt(4);
            String sexo = cursorConsulta.getString(5);

            Log.d("correo", correo);
            Log.d("nombre", nombre);
            Log.d("apellido", apellido);
            Log.d("nvlHem", String.valueOf(nvlHem));
            Log.d("edad", String.valueOf(edad));
            Log.d("sexo", sexo);

            edCorreo.setText(correo);
            edNombre.setText(nombre);
            edApellido.setText(apellido);
            edNvlHem.setText(String.valueOf(nvlHem));
            edEdad.setText(String.valueOf(edad));
            edSexo.setText(sexo);
        } else {
            Toast.makeText(this, "No se ha encontrado una persona con el correo digitado.", Toast.LENGTH_LONG).show();
        }

        bd.close();
    }

    public void modificarPersona(View v) {
        AdminSQLHelper admin = new AdminSQLHelper(this, "db_pacientes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        EditText edCorreo = (EditText) findViewById(R.id.editTextTextPersonName8);
        EditText edNombre = (EditText) findViewById(R.id.editTextTextPersonName9);
        EditText edApellido = (EditText) findViewById(R.id.editTextTextPersonName10);
        EditText edNvlHem = (EditText) findViewById(R.id.editTextTextPersonName11);
        EditText edEdad = (EditText) findViewById(R.id.editTextTextPersonName12);
        EditText edSexo = (EditText) findViewById(R.id.editTextTextPersonName13);
        String correoPersona = edCorreo.getText().toString();

        Cursor cursorConsulta = bd.rawQuery("SELECT * FROM paciente WHERE correo = ?", new String[] {correoPersona});

        if (cursorConsulta.moveToFirst()) {
            String correo = cursorConsulta.getString(0);
            String nombre = edNombre.getText().toString();
            String apellido = edApellido.getText().toString();
            double nvlHem = Double.parseDouble(edNvlHem.getText().toString());
            int edad = Integer.parseInt(edEdad.getText().toString());
            String sexo = edSexo.getText().toString();

            Log.d("correo", correo);
            Log.d("nombre", nombre);
            Log.d("apellido", apellido);
            Log.d("nvlHem", String.valueOf(nvlHem));
            Log.d("edad", String.valueOf(edad));
            Log.d("sexo", sexo);

            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("nvlHem", nvlHem);
            registro.put("correo", correo);
            registro.put("edad", edad);
            registro.put("sexo", sexo);

            int cantidad = bd.update("paciente", registro, "correo = ?", new String[] {correoPersona}  );
            bd.close();

            if (cantidad == 1) {
                Toast.makeText(this, "Se han modificado los datos con éxito.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se han logrado modificar los datos.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No se ha encontrado una persona con el correo digitado.", Toast.LENGTH_LONG).show();
        }

        bd.close();
    }

}
