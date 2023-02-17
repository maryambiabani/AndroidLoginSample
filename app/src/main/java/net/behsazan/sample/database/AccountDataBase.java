package net.behsazan.sample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountDataBase extends SQLiteOpenHelper {

    private static  final String DB_NAME="Accounts.db";
    public static  final String TABLE_ACCOUNT="tbl_account";
    private static  final int VERSION=1;
    public static  final String KEY_ID="id";
    public static  final String KEY_USERNAME="username";
    public static  final String KEY_PASSWORD="password";



    public AccountDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLE_ACCOUNT+"("+KEY_ID+" Integer PRIMARY KEY AUTOINCREMENT,"+KEY_USERNAME+" varchar(100) ," +
                " "+KEY_PASSWORD+" Text )";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
