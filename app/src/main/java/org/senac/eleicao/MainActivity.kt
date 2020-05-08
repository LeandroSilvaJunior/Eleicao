package org.senac.eleicao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    private lateinit var candidatosComponent : RadioGroup
    private lateinit var confirmarComponent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        candidatosComponent = findViewById<RadioGroup>(R.id.rg_candidatos)
        confirmarComponent = findViewById<Button>(R.id.bt_confirmar_voto)
    }

    fun confirmarVoto(view: View) {
        val candidato = findViewById<RadioButton>(candidatosComponent.checkedRadioButtonId)
        val intent = Intent(this, Resultado::class.java).apply {
            putExtra("candidato", candidato.text.toString())
        }
        startActivity(intent)
    }
}
