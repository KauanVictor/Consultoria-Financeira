package com.example.consultoriaruiz.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.consultoriaruiz.R;

public class MainLivroFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainLivroFragment newInstance() {
        return new MainLivroFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.livrodigital, container, false);
        VideoView videoView = root.findViewById(R.id.videoView);
       videoView.setVideoPath("android.resource://"+ getActivity().getPackageName()+ "/" + R.raw.manu);
       MediaController mediaController = new MediaController(getActivity());
       mediaController.setAnchorView(videoView);
       videoView.setMediaController(mediaController);
       videoView.start();
        // inflater.inflate(R.layout.livrodigital, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}