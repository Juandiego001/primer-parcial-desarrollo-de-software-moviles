package com.example.primerparcial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
    }

    public void eliminarPersona(View v) {
        AdminSQLHelper admin = new AdminSQLHelper(this, "db_pacientes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        EditText edCorreo = (EditText) findViewById(R.id.editTextTextPersonName14);
        String correoPersona = edCorreo.getText().toString();

        int cantidad = bd.delete("paciente", "correo = ?", new String[] {correoPersona});

        if (cantidad == 1) {
            Toast.makeText(this, "Se ha eliminado la persona con éxito.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No se ha eliminado la persona. Probablemente ocurrió un error. Verifique el correo.", Toast.LENGTH_LONG).show();
        }

    }
}
