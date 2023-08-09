package com.github.GrandeOnde.TempoUm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.GrandeOnde.TempoUm.databinding.TempoUmBinding
import java.lang.Math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: TempoUmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TempoUmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculaTudo() }
    }

    fun calculaTudo() {
        val stringInTextField = binding.ComponenteEssencia.text.toString()
        val custo = stringInTextField.toDouble()
        val idSelecionado = binding.ComponenteSelect.checkedRadioButtonId
        val gorjetaPorcent = when (idSelecionado) {
            R.id.VinteCento -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var gorjeta = gorjetaPorcent * custo
        val marcadoAcima = binding.Barra.isChecked
        if (marcadoAcima) {
            gorjeta = ceil(gorjeta)

        }
    }
}
