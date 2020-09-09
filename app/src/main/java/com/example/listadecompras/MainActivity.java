package com.example.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView footer;
    private EditText editText;
    private CheckBox checkBox;
    private Spinner spinner;

    private ArrayList<Produto> produtos;
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        spinner = (Spinner)findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.edittext);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        footer = (TextView)findViewById(R.id.footer);

        produtos = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, R.layout.simple_list_item_1, produtos);
        listView.setAdapter(arrayAdapter);

        AdapterView.onItemLongClickListener itemClickListener = new AdapterView.onItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> listView, View view, int position, long id) {
                final int localPosition = position;
                new AlertDialog.Builder(MainActivity.this).setTitle("Remover Produto da Lista").setMessage("Voce realmente deseja excluir?").setIcon(R.drawable.ic_launcher_background).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        produtos.remove(localPosition);
                        arrayAdapter.notifyDataSetChanged();
                    }
                })
                        .setNegativeButton(R.string.no, null).show();
                return true;
            }
        };

        listView.setOnItemClickListener(itemClickListener);

    }
}
