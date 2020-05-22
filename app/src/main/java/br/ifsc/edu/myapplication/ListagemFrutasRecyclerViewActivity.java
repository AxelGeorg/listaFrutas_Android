package br.ifsc.edu.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListagemFrutasRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FrutaController frutaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_frutas_recycler_view);

        FrutaController frutaController = new FrutaController();


        recyclerView = findViewById(R.id.recylerView);
        //configuração recycle view
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //configuração do adapter para recycler view
        FrutaAdapterRecyclerView frutaAdapterListView =
                new FrutaAdapterRecyclerView(
                        getApplicationContext(),
                        R.layout.template_item_fruta,
                        frutaController.FRUTAS);

//        FrutaAdapterListView frutaAdapterListView =new FrutaAdapterListView(
//                getApplicationContext(),
//                R.layout.template_item_fruta,
//                frutaController.FRUTAS
//        );
//
       recyclerView.setAdapter(frutaAdapterListView);

    }
}
