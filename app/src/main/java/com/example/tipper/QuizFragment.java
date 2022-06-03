package com.example.tipper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tipper.databinding.FragmentQuizBinding;

public class QuizFragment extends Fragment {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentQuizBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}