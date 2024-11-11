package com.example.a23ewqa

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

// Внутрішній клас MainViewModel всередині MainActivity
class MainActivity : AppCompatActivity() {

    // Визначаємо ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Зв'язуємо елементи розмітки
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        // Встановлюємо обробник натискання кнопки
        button.setOnClickListener {
            // Оновлюємо текст у TextView з даних ViewModel
            textView.text = viewModel.buttonText
        }
    }

    // Внутрішній клас ViewModel
    class MainViewModel : ViewModel() {
        // Поле з текстом
        var buttonText: String = "Текст після натискання кнопки"
    }
}
