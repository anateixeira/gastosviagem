package br.com.avaty.gastodeviagens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    lateinit var distancia: EditText
    lateinit var preco: EditText
    lateinit var autonomia: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        distancia = findViewById(R.id.edit_distancia)
        preco = findViewById(R.id.edit_preco)
        autonomia = findViewById(R.id.edit_autonomia)

        distancia.addTextChangedListener(object : ValidacaoEditText(distancia) {
            override fun validate(edit: EditText?, text: String?) {
                /*if (text.equals("1")) {
                    edit?.error = "Este campo é obrigatório"
                }*/
            }
        })

        preco.addTextChangedListener(object : ValidacaoEditText(preco) {
            override fun validate(edit: EditText?, text: String?) {
                /*if (preco.toString().isEmpty()) {
                    preco.error = "Este campo é obrigatório"
                }*/
            }
        })
        autonomia.addTextChangedListener(object : ValidacaoEditText(autonomia) {
            override fun validate(edit: EditText?, text: String?) {
                /*if (autonomia.toString().isEmpty()) {
                    autonomia.error = "Este campo é obrigatório"
                }*/
            }
        })


        val buttonCalcular = findViewById<Button>(R.id.button_calcular)
        buttonCalcular.setOnClickListener { l -> calculaGasto(l) }
    }

    fun calculaGasto(view: View) {
        //distancia *preco / autonomia
        if (view.id == R.id.button_calcular) {

            if (distancia.text.toString().isNotEmpty() && preco.text.toString().isNotEmpty() &&
                autonomia.text.toString().isNotEmpty()
            ) {
                val total =
                    BigDecimal(
                        (distancia.text.toString().toDouble() * preco.text.toString().toDouble()) /
                                autonomia.text.toString().toDouble()
                    ).setScale(2)

                findViewById<TextView>(R.id.text_total).text = "R$ $total"
            } else {
                //findViewById<EditText>(R.id.edit_distancia).setError("Este campo é obrigatório")
            }
        }
    }

}