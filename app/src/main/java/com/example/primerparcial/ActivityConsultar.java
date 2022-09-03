package com.example.primerparcial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primerparcial.AdminSQLHelper;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityConsultar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void consultarPersona(View v) {
        AdminSQLHelper admin = new AdminSQLHelper(this, "db_pacientes", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        EditText edCorreo = (EditText) findViewById(R.id.editTextTextPersonName7);
        EditText edMultiText = (EditText) findViewById(R.id.editTextTextMultiLine);
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

            String res =  "Correo: \t" + correo +
                    "\nNombre: \t" + nombre +
                    "\nApellido: \t" + apellido +
                    "\nNivel hemoglobina: \t" + nvlHem +
                    "\nEdad: \t" + edad +
                    "\nSexo: \t" + sexo + "\n\n";

            edMultiText.setText(res);

            if ((edad >= 0 && edad <= 0.08) && (nvlHem >= 0.13 && nvlHem <= 0.26)) {

            } else if ((edad > 0.08 && edad <= 0.5) && (nvlHem >= 0.1 && nvlHem <= 0.18)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else if ((edad > 0.5 && edad <= 1) && (nvlHem >= 0.11 && nvlHem <= 0.15)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else if ((edad > 1 && edad <= 5) && (nvlHem >= 0.115 && nvlHem <= 0.15)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else if ((edad > 5 && edad <= 10) && (nvlHem >= 0.126 && nvlHem <= 0.155)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else if (sexo.equalsIgnoreCase("mujer") && (edad > 15) && (nvlHem >= 0.12 && nvlHem <= 0.16)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else if (sexo.equalsIgnoreCase("hombre") && (edad > 15) && (nvlHem >= 0.14 && nvlHem <= 0.18)) {
                Toast.makeText(this, "La persona NO! sufre de anemia", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "La persona sufre de anemia.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No se ha encontrado una persona con el correo digitado.", Toast.LENGTH_LONG).show();
        }

        bd.close();
    }
}


