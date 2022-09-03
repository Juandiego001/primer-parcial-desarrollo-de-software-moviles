package com.example.primerparcial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLHelper extends SQLiteOpenHelper {

    public AdminSQLHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE paciente" +
                "(" +
                    "correo TEXT PRIMARY KEY, " +
                    "nombre TEXT," +
                    "apellido TEXT," +
                    "nvlHem REAL," +
                    "edad INTEGER," +
                    "sexo TEXT" +
                ")"
            );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("DROP TABLE IF EXISTS paciente");
        db.execSQL(
                "CREATE TABLE paciente" +
                        "(" +
                        "correo TEXT PRIMARY KEY, " +
                        "nombre TEXT," +
                        "apellido TEXT," +
                        "nvlHem REAL," +
                        "edad INTEGER," +
                        "sexo TEXT" +
                        ")"
        );
    }
}
