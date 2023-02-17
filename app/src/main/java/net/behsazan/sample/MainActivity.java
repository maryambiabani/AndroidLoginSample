package net.behsazan.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.behsazan.sample.database.AccountDBAdapter;
import net.behsazan.sample.database.AccountDataBase;

public class MainActivity extends AppCompatActivity {
    AccountDataBase accountDataBase;
    AccountDBAdapter accountDBAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountDataBase=new AccountDataBase(getApplicationContext());
        accountDBAdapter=new AccountDBAdapter(getApplicationContext());

    }
}