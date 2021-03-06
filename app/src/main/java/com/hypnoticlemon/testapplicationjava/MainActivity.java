package com.hypnoticlemon.testapplicationjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerLayout;
    private DemoAdapter demoAdapter;
    private List<DemoModel> demoAdapterList;
    private Context context;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        recyclerLayout = findViewById(R.id.recyclerLayout);
        demoAdapterList = new ArrayList<>();
        recyclerLayout.setHasFixedSize(true);
        recyclerLayout.setLayoutManager(new LinearLayoutManager(context));
        generateAES();

        for (int i = 0; i < 5; i++) {
            DemoModel demoModel = new DemoModel();
            demoModel.setImagePath("https://www.gizmochina.com/wp-content/uploads/2018/02/android.jpg");
            demoModel.setTitle("Text Title");
            demoAdapterList.add(demoModel);
        }

        demoAdapter = new DemoAdapter(context, demoAdapterList, listener);
        recyclerLayout.setAdapter(demoAdapter);
        demoAdapter.notifyDataSetChanged();
    }

    OnRecyclerItemClickListener listener = new OnRecyclerItemClickListener() {
        @Override
        public void ItemClick(int position, String data, View view, int id) {
            Toast.makeText(context, "Item Click", Toast.LENGTH_LONG).show();
        }
    };


    public void generateAES() {
        byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
        byte[] plainText = "Vikrant Shah".getBytes(StandardCharsets.UTF_8);
        AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(
                encryptionKey);
        byte[] cipherText = new byte[0];
        byte[] decryptedCipherText = new byte[0];
        try {
            cipherText = advancedEncryptionStandard.encrypt(plainText);
            decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e(TAG, "generateMD5: plainText = " + new String(plainText) );
        Log.e(TAG, "generateMD5: cipherText= " + new String(cipherText));
        Log.e(TAG, "generateMD5: decryptedCipherText= " + new String(decryptedCipherText));
    }
}
