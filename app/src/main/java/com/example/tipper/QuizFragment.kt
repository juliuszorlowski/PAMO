package com.example.tipper;

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.ViewGroup
import com.example.tipper.databinding.FragmentQuizBinding;

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {

        binding = FragmentQuizBinding.inflate(layoutInflater)
        val root: View = binding.root

        return root;
    }
}