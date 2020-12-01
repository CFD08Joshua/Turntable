package com.example.turntable.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.turntable.R;

public class LearningOutcomeFragment extends Fragment {

    private static LearningOutcomeFragment newInstance(){
        LearningOutcomeFragment fragment = new LearningOutcomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_outcome,container,false);
        return view;
    }
}
