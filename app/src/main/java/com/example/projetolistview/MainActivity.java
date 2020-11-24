package com.example.projetolistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

/*
Nessa MainActivity vou cadastrar os atributos e salvar as informações digitadas e as "levar para a 2ä view
onde irei editar os dados.
 */

public class MainActivity extends AppCompatActivity {

    // Aqui são os atributos que criei no layout (activity_main.xml)

    EditText nome, sobrenome, curso;
    Button btAdicionar;
    ListView listViewPessoas;
    ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui são as associações trazida do Layout.

        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editSobrenome);
        curso = findViewById(R.id.editCurso);
        btAdicionar = findViewById(R.id.buttonAdicionar);
        listViewPessoas = findViewById(R.id.listViewPessoas);

        // Aqui é para configurar a ListView ou seja, colocar meu array "Pessoa dentro da listview.

        final ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listaPessoas);

        //Aqui vou conectar a ListView com o Adaptador("coloquei dentro da lista).
        listViewPessoas.setAdapter(adapter); // Todos os dados serão mostrados na listview.

        // Aqui é onde cria o evento click do botão nesse caso o (ADICIONAR)
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPessoas.add(
                        new Pessoa(
                                nome.getText().toString(),
                                sobrenome.getText().toString(),
                                curso.getText().toString())
                );

                // Aqui é para avisar ao adaptador que os dados da lista foi alterada.
                adapter.notifyDataSetChanged();

                //Aqui é para ordenar no caso (nomes) da listView.
                Collections.sort(listaPessoas, new OrdenaPorNome());

                // Aqui limpa os textview da tela.
                nome.setText("");
                sobrenome.setText("");
                curso.setText("");
                nome.requestFocus();
            }

        });

       /*
         Aqui é para quando eu clicar em um item da lista, ele pegue o dado e a posição dele
         (ex. 0,1,2) só pega o item que cliquei não a lista inteira.
        */

        listViewPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

              // Recupera o objeto (pessoa) que foi clicado na lista ( cliquei em Josi que estava na posição 2 por exemplo)

                Pessoa p = (Pessoa)listViewPessoas.getItemAtPosition(position);

              // A Intent é para conseguir mudar de view (Resultado.java por exemplo), ou seja, chamar outra tela(activity)

                Intent it = new Intent (getApplicationContext(),Resultado.class);

              // Aqui o putExtra passa o objeto "Pessoa" inteira para a Intent.

                it.putExtra("Pessoa",p);

              // Método para abrir uma nova activity recebendo a minha Intent(i).

                startActivity(it);


              /* Aqui mostra os dados no Toast (notificação, pop-up, feedback sobre uma atividade)
               Deixei o toast comentado para saber como usar.

                Toast.makeText(
                        MainActivity.this,
                            p.getDados(),
                                Toast.LENGTH_SHORT).show();
                 */

            }
        });

          /*
          Para excluir um elemento da lista e do ArrayList<Pessoa> (listaPessoas)
          quando clicamos e seguramos por 2/3 segundos...

          listViewPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
              public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Pessoa p = (Pessoa)listViewPessoas.getItemAtPosition(position);


                listaPessoas.remove(p);  - remover o objeto da lista


                return false;

           */


    }

}