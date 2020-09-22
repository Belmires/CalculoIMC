package br.com.pitagoras.aula1709

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_calculate_main.setOnClickListener {
            calculoIMC()
        }
        button_clear_main.setOnClickListener {
            editText_weight_main.text.clear()
            editText_height_main.text.clear()
        }



    }

    private fun calculoIMC(){
            val altura= editText_weight_main.text.toString().toDouble()
            val peso  = editText_height_main.text.toString().toDouble()
            var resulIMC = ""
            var sintomas = ""

        val imc = peso / (altura*altura)


        if ( imc>=16 && imc<=16.9 ) {
             resulIMC = "Muito abaixo do peso"
             sintomas = "Queda de cabelo, infertilidade, ausência menstrual"
        } else if ( imc>=17 && imc<=18.4 ) {
             resulIMC = "Abaixo do peso"
             sintomas = "Fadiga, stress, ansiedade"
        } else if ( imc>=18.5 && imc<=24.9 ) {
             resulIMC = "Peso normal"
             sintomas = "Menor risco de doenças cardíacas e vasculares"
        } else if ( imc>=25 && imc<=29.9 ) {
             resulIMC = "Acima do peso"
             sintomas = "Fadiga, má circulação, varizes"
        } else if ( imc>=30 && imc<=34.9 ) {
             resulIMC = "Obesidade Grau I"
             sintomas = "Diabetes, angina, infarto, aterosclerose"
        } else if ( imc>=35 && imc<=40 ) {
             resulIMC = "Obesidade Grau II"
             sintomas = "Apneia do sono, falta de ar"
        } else if ( imc>40 ) {
             resulIMC = "Obesidade Grau III"
             sintomas = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC"
        }

        if(resulIMC.isNotEmpty() && sintomas.isNotEmpty()) {
            val formatador = DecimalFormat(".##")

            val intent = Intent(this@MainActivity, AnswerActivity::class.java).apply {
                putExtra("IMC", formatador.format(imc))
                putExtra("resulIMC", resulIMC)
                putExtra("sintomas", sintomas)

            }
            startActivity(intent)
        } else{
            Toast.makeText(
                this,
                "Favor preencher os caomps",
                Toast.LENGTH_LONG
            ).show()
        }
}



}