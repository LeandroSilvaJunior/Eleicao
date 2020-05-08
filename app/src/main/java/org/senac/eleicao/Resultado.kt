package org.senac.eleicao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Resultado : AppCompatActivity() {

    private lateinit var idadeComponent : EditText
    private lateinit var sexoComponent : RadioGroup
    private lateinit var escolaridadeComponent : Spinner
    private lateinit var casaPropriaComponent : RadioGroup
    private lateinit var confirmarComponent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        idadeComponent = findViewById<EditText>(R.id.et_idade)
        sexoComponent = findViewById<RadioGroup>(R.id.rg_sexo)
        escolaridadeComponent = findViewById<Spinner>(R.id.sp_escolaridade)
        casaPropriaComponent = findViewById<RadioGroup>(R.id.rg_possui_casa_propria)
        confirmarComponent = findViewById<Button>(R.id.bt_confirmar)

        ArrayAdapter.createFromResource(
            this,
            R.array.escolaridade_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            escolaridadeComponent.adapter = adapter
        }

    }

    fun confirmarVoto(view: View) {
        if (validate()) {
            val candidato = intent.getStringExtra("candidato")
            Toast.makeText(this, "Obrigado por participar da entrevista. Seu voto foi no candidato ${candidato}", Toast.LENGTH_LONG).show()
        }
    }

    fun validate() : Boolean {
        var validate = true

        if (idadeComponent.text.trim().length == 0 || idadeComponent.text.toString().toInt() < 16) {
            idadeComponent.setError("Você deve possuir pelo menos 16 anos")
            validate= false
        }

        return validate
    }
}
