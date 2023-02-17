package net.behsazan.sample.database;

import static net.behsazan.sample.database.AccountDataBase.TABLE_ACCOUNT;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import net.behsazan.sample.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDBAdapter extends AccountDataBase{
    public AccountDBAdapter(@Nullable Context context) {
        super(context);
    }
    // insert to the table
    public long insert(Account account) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AccountDataBase.KEY_USERNAME,account.getUsername());
        contentValues.put(AccountDataBase.KEY_PASSWORD,account.getPassword());
        return db.insert(TABLE_ACCOUNT, null, contentValues);
    }

    //get all userName and password
    @SuppressLint("Range")
    public Map<String,String> getAllAccount() {

        SQLiteDatabase db = getReadableDatabase();
        Map<String,String> accMap = new HashMap<>();

        Cursor cursor = db.rawQuery("select * from " + TABLE_ACCOUNT,null) ;
        while (cursor.moveToNext()) {
            accMap.put(cursor.getString(cursor.getColumnIndex(AccountDataBase.KEY_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(AccountDataBase.KEY_PASSWORD)));
        }

        return accMap;
    }

    //find pass by username
    @SuppressLint("Range")
    public String getPass(String user) {
        String pass = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + AccountDataBase.TABLE_ACCOUNT + " where " + AccountDataBase.KEY_USERNAME + " = ? " + "limit 1", new String[]{user});
        while (cursor.moveToNext()) {
            pass = cursor.getString(cursor.getColumnIndex(AccountDataBase.KEY_PASSWORD));
        }
        return pass;
    }


}