package mx.itson.appkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtValor1: EditText
    private lateinit var txtValor2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtValor1 = findViewById(R.id.txtPrimerValor)
        txtValor2 = findViewById(R.id.txtSegundoValor)

        val btnSumar = findViewById<Button>(R.id.btnSumar)
        btnSumar.setOnClickListener(this::onClick)

        val btnRestar = findViewById<Button>(R.id.btnRestar)
        btnRestar.setOnClickListener(this::onClick)

        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        btnMultiplicar.setOnClickListener(this::onClick)

        val btnDividir = findViewById<Button>(R.id.btnDividir)
        btnDividir.setOnClickListener(this::onClick)

    }

    fun sumar(a: Int, b: Int): Int {
        return a + b
    }

    fun restar(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplicar(a: Int, b: Int): Int {
        return a * b
    }

    fun dividir(a: Int, b: Int): Int {
        return a / b
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSumar -> {
                try {
                    if (txtValor1.text.toString().isEmpty() || txtValor2.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext, "No se puede dejar campos vacíos", Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    var resultado = sumar(
                        txtValor1.text.toString().toInt(), txtValor2.text.toString().toInt()
                    )
                    Toast.makeText(
                        applicationContext, "El resultado de la suma es: $resultado", Toast.LENGTH_LONG
                    ).show()

                } catch (e: Exception) {
                    e.message?.let { Log.e("Error", it) }
                    return
                }
            }

            R.id.btnRestar -> {
                try {
                    if (txtValor1.text.toString().isEmpty() || txtValor2.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext, "No se puede dejar campos vacíos", Toast.LENGTH_SHORT
                        ).show()
                        return
                    }

                    var resultado = restar(
                        txtValor1.text.toString().toInt(), txtValor2.text.toString().toInt()
                    )
                    Toast.makeText(
                        applicationContext, "El resultado de la resta es: $resultado", Toast.LENGTH_LONG
                    ).show()
                } catch (e: Exception) {
                    e.message?.let { Log.e("Error", it) }
                    return
                }
            }

            R.id.btnMultiplicar -> {
                try {
                    if (txtValor1.text.toString().isEmpty() || txtValor2.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext, "No se puede dejar campos vacíos", Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    var resultado = multiplicar(
                        txtValor1.text.toString().toInt(), txtValor2.text.toString().toInt()
                    )
                    Toast.makeText(
                        applicationContext, "El resultado de la multiplicación es: $resultado", Toast.LENGTH_LONG
                    ).show()
                } catch (e: Exception) {
                    e.message?.let { Log.e("Error", it) }
                    return
                }
            }

            R.id.btnDividir -> {
                try {
                    if (txtValor1.text.toString().isEmpty() || txtValor2.text.toString().isEmpty()) {
                        Toast.makeText(
                            applicationContext, "No se puede dejar campos vacíos", Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    if (txtValor2.text.toString().toInt() == 0 || txtValor2.text.toString().toInt() == 0) {
                        Toast.makeText(
                            applicationContext, "No se puede dividir entre 0", Toast.LENGTH_LONG
                        ).show()
                        return
                    }
                    var resultado = dividir(
                        txtValor1.text.toString().toInt(), txtValor2.text.toString().toInt()
                    )
                    Toast.makeText(
                        applicationContext, "El resultado de la división es: $resultado", Toast.LENGTH_LONG
                    ).show()
                } catch (e: Exception) {
                    e.message?.let { Log.e("Error", it) }
                    return
                }
            }
        }
    }
}
