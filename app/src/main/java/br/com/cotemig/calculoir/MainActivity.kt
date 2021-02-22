package br.com.cotemig.calculoir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextSalario = findViewById<EditText>(R.id.editTextSalario)
        var buttonCalcula = findViewById<Button>(R.id.buttonCalcula)

        buttonCalcula.setOnClickListener {
            calculaImpostoRenda(editTextSalario.text.toString().toDouble())
        }

    }

    // Acima de 4.664,68        | 27,5 | 869,36
    // De 3.751,06 até 4.664,68 | 22,5 | 636,13
    // De 2.826,66 até 3.751,05 | 15   | 354,80
    // De 1.903,99 até 2.826,65 | 7.5  | 142,80

    fun calculaImpostoRenda(salario: Double) {

        var imposto = 0.0
        var liquido = salario

        if (salario > 4664.68) {
            imposto = salario * 0.27
            liquido = (salario - imposto) + 869.36
        } else if (salario >= 3751.06) {
            imposto = salario * 0.225
            liquido = (salario - imposto) + 636.13
        } else if (salario >= 2826.66) {
            imposto = salario * 0.15
            liquido = (salario - imposto) + 354.80
        } else if (salario >= 1903.99) {
            imposto = salario * 0.075
            liquido = (salario - imposto) + 142.80
        }

        var textViewSalarioLiquido = findViewById<TextView>(R.id.textViewSalarioLiquido)
        var textViewImposto = findViewById<TextView>(R.id.textViewImposto)

        textViewSalarioLiquido.text = String.format("Salário Líquido: R$ %.2f", liquido)
        textViewImposto.text = String.format("Imposto: R$ %.2f", imposto)

    }
}