package com.example.tecktrove.view.Synthesis;

public interface SynthesisContainerView {
    void showErrorMessage(String title, String msg);

    void completeSynthesis();

    void save();


    String getName();
}
