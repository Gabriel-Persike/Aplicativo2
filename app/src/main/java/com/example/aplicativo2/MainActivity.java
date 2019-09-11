package com.example.aplicativo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private EditText nmProduto = null;
    private EditText EditQuantidade = null;
    private Spinner spinnerTpProduto = null;
    private CheckBox CheckPrioridade = null;
    private List<Produto> produtos;
    private ArrayAdapter adapter;
    private ListView listprodutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nmProduto= findViewById(R.id.nmProduto);
        EditQuantidade = findViewById(R.id.EditQuantidade);
        spinnerTpProduto = findViewById(R.id.spinnerTpProduto);
        CheckPrioridade = findViewById(R.id.CheckPrioridade);
        listprodutos = findViewById(R.id.listview);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerTpProduto);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tpUnidade, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    @Override
    protected void onStart(){
        super.onStart();

        produtos = new ArrayList<>();
        adapter = new ProdutoAdapter(getApplicationContext(),R.layout.listproduto,produtos);
        listprodutos.setAdapter(adapter);
    }

    public void cadastrar(View view){
        String nome = nmProduto.getText().toString();
        String quantidade = (EditQuantidade.getText().toString() + spinnerTpProduto.getSelectedItem().toString());

        boolean prioridade;
        if (CheckPrioridade.isChecked())
            prioridade = true;
        else
            prioridade = false;

        Produto produto = new Produto(nome,quantidade, prioridade);

        produtos.add(produto);

        adapter.notifyDataSetChanged();
    }
}
