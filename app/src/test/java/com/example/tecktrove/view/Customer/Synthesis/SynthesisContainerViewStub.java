package com.example.tecktrove.view.Customer.Synthesis;

import com.example.tecktrove.view.Synthesis.SynthesisContainerView;

public class SynthesisContainerViewStub implements SynthesisContainerView {

    private int messages=0;
    private int completedSynthesis=0;

    private int savedSynthesis=0;
    @Override
    public void showErrorMessage(String title, String msg) {
        messages++;
    }

    @Override
    public void completeSynthesis() {

    }

    @Override
    public void save() {
        savedSynthesis++;
    }

    @Override
    public String getName() {
        return null;
    }
}
