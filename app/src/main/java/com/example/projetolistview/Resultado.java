package com.example.projetolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
Nessa view vou trazer os atributos "pessoa" nome, sobrenome e curso que cliquei na view anterior,
pois aqui irei ter que editar o objeto(alguma informação).
OBS1: Eu tive que mudar o nome do componentTree para edit apenas pois estava conflitando com o EditText
da 1a view.
OBS2: Os campos da 2view são PlainText pois as informações já virão da 1a view.
 */

public class Resultado extends AppCompatActivity {

    // Atributos criados.

    EditText nome, sobrenome,curso;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Para conseguir editar os campos, tenho que fazer as associações no (findViewByid e colocar as variáveis)

        nome = findViewById(R.id.editNome);
        sobrenome = findViewById(R.id.editSobrenome);
        curso = findViewById(R.id.editCurso);
        btVoltar = findViewById(R.id.buttonVoltar);

        //Aqui é onde eu pego a Intent do Mainactivity (getIntent)

        Intent i = getIntent();

        // (Casting) Aqui não tem a opção putExtra porque só recebe um argumento do tipo string então usei o getSerializableExtra.

        Pessoa p = (Pessoa) i.getSerializableExtra("Pessoa");


        /* Aqui vou usar o setText para trazer o valor definido no campo "nome, sobrenome".(p)
        e associar ao getNome, sobrenome e curso.
         */
        nome.setText(p.getNome());
        sobrenome.setText(p.getSobrenome());
        curso.setText(p.getCurso());

        // Registrar o evento click do botão. (VOLTAR)

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }


        });


    }
}
