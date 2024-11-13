package com.example.lab_2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lab_2.R
import com.example.lab_2.databinding.FragmentTabbedBinding
import android.widget.Button
import android.content.Intent
import com.example.lab_2.MainActivity

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private var sectionNumber: Int? = null

    companion object {
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putInt("section_number", sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Получите число вкладки из аргументов
        sectionNumber = arguments?.getInt("section_number")

        // В зависимости от вкладки, выберите разметку
        val layoutResId = if (sectionNumber == 3) {
            R.layout.fragment_btn // Используйте кастомную разметку для третьей вкладки
        } else {
            R.layout.fragment_tabbed // Стандартная разметка
        }


        // Інфлюємо розмітку
        val rootView = inflater.inflate(layoutResId, container, false)

// Якщо це третя вкладка, знаходимо кнопку та обробляємо натискання
        if (sectionNumber == 3) {
            // Отримуємо кнопку з розмітки
            val button = rootView.findViewById<Button>(R.id.tabButton)

            // Перевіряємо, чи кнопка не є null
            button?.setOnClickListener {
                // Створюємо Intent для переходу на MainActivity
                val intent = Intent(requireContext(), MainActivity::class.java)
                // Запускаємо MainActivity
                startActivity(intent)
            }
        }

        return rootView

    }
}

