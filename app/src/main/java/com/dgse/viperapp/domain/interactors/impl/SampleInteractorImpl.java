package com.dgse.viperapp.domain.interactors.impl;

import com.dgse.viperapp.domain.executor.Executor;
import com.dgse.viperapp.domain.executor.MainThread;
import com.dgse.viperapp.domain.interactors.SampleInteractor;
import com.dgse.viperapp.domain.interactors.base.AbstractInteractor;
import com.dgse.viperapp.domain.repository.Repository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class SampleInteractorImpl extends AbstractInteractor implements SampleInteractor {

    private SampleInteractor.Callback mCallback;
    private Repository mRepository;

    public SampleInteractorImpl(Executor threadExecutor,
                                MainThread mainThread,
                                Callback callback, Repository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
    }
}
