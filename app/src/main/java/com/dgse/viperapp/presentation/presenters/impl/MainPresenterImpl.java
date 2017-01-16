package com.dgse.viperapp.presentation.presenters.impl;


import android.util.Log;

import com.dgse.viperapp.domain.dal.server.BoardsEndpoint;
import com.dgse.viperapp.domain.executor.Executor;
import com.dgse.viperapp.domain.executor.MainThread;
import com.dgse.viperapp.domain.interactors.SampleInteractor;
import com.dgse.viperapp.domain.model.AbuBoardModel;
import com.dgse.viperapp.presentation.presenters.MainPresenter;
import com.dgse.viperapp.presentation.presenters.base.AbstractPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        SampleInteractor.Callback {

    BoardsEndpoint boardsEndpoint;
    Observable<Map<String, List<AbuBoardModel>>> boardsStream;
    private MainPresenter.View mView;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view) {
        super(executor, mainThread);
        mView = view;
        boardsEndpoint = new BoardsEndpoint();
        boardsStream = boardsEndpoint.getBoards();

    }

    @Override
    public void resume() {
        mView.clearData();
        boardsStream
                .subscribeOn(Schedulers.newThread())
                .map(stringListMap -> {
                    List<AbuBoardModel> retval = new ArrayList<>();
                    for (Map.Entry<String, List<AbuBoardModel>> entry : stringListMap.entrySet()) {
                        retval.addAll(entry.getValue());
                    }
                    return retval;
                })
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(mView::addData,
                        throwable -> Log.e("RX", throwable.getMessage()),
                        () -> Log.e("RX", "COMPLETE")
                );
    }

    @Override
    public void pause() {
        //
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }
}
