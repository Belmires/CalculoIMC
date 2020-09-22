package br.com.pitagoras.aula1709

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_asware.*

class AnswerActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asware)

        val imc = intent.getStringExtra("IMC")
        valorIMC.text = "$imc kg/m2"

        val resulIMC = intent.getStringExtra("resulIMC")
        valorClassificacao.text = resulIMC

        val sintomas = intent.getStringExtra("sintomas")
        valorSintomas.text = sintomas

        Log.e("FGV", "$imc")

        btnVoltar.setOnClickListener {
            val intent = Intent(this@AnswerActivity, MainActivity::class.java).apply {
        }
            startActivity(intent)
        }
    }
}