package br.com.avaty.gastodeviagens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    private lateinit var distancia: EditText
    private lateinit var preco: EditText
    private lateinit var autonomia: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        distancia = findViewById(R.id.edit_distancia)
        preco = findViewById(R.id.edit_preco)
        autonomia = findViewById(R.id.edit_autonomia)

        val buttonCalcular = findViewById<Button>(R.id.button_calcular)
        buttonCalcular.setOnClickListener { l -> calculaGasto(l) }
    }

    fun calculaGasto(view: View) {
        if (view.id == R.id.button_calcular) {

            if (distancia.text.toString().isNotEmpty() && preco.text.toString()
                    .isNotEmpty() && autonomia.text.toString().isNotEmpty()
            ) {
                val total =
                    BigDecimal(
                        (distancia.text.toString().toDouble() * preco.text.toString().toDouble()) /
                                autonomia.text.toString().toDouble()
                    ).setScale(2, RoundingMode.HALF_EVEN)
                findViewById<TextView>(R.id.text_total).text = "R$ $total"
            } else {
                if (distancia.text.toString().isEmpty())
                    distancia.error = "Este campo é obrigatório"

                if (preco.text.toString().isEmpty())
                    preco.error = "Este campo é obrigatório"

                if (autonomia.text.toString().isEmpty())
                    autonomia.error = "Este campo é obrigatório"
            }
        }
    }

}