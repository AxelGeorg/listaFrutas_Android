package br.ifsc.edu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListagemFrutasListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_fruta_list_view);


        listView=findViewById(R.id.listView);


        FrutaController frutaController = new FrutaController();

        FrutaAdapterListView frutaAdapterListView =new FrutaAdapterListView(
                getApplicationContext(),
                R.layout.template_item_fruta,
                frutaController.FRUTAS
        );

        listView.setAdapter(frutaAdapterListView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//classe anonimo, nao tem noem comeca e acaba aqui, por isso n da pra colocar this
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ExibeFrutas.class);
                //como saber qual dos itens ele clicou??  pela posição -> int acima
                //quando clicar manda uma intent
                intent.putExtra("id",i);//coloca um dado adicional,

                startActivity(intent);
            }
        });


    }
}
