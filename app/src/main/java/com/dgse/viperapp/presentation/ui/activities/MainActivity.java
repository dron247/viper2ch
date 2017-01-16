package com.dgse.viperapp.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dgse.viperapp.R;
import com.dgse.viperapp.domain.executor.impl.ThreadExecutor;
import com.dgse.viperapp.domain.model.AbuBoardModel;
import com.dgse.viperapp.presentation.presenters.MainPresenter.View;
import com.dgse.viperapp.presentation.presenters.impl.MainPresenterImpl;
import com.dgse.viperapp.presentation.ui.adapters.BoardsAdapter;
import com.dgse.viperapp.threading.MainThreadImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.boards)
    RecyclerView boards;
    MainPresenterImpl presenter;
    BoardsAdapter boardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
        boardsAdapter = new BoardsAdapter();
        boards.setAdapter(boardsAdapter);
        boards.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        presenter.resume();
        super.onResume();
    }

    @Override
    public void clearData() {
        boardsAdapter.clear();
    }

    @Override
    public void addData(List<AbuBoardModel> data) {
        boardsAdapter.appendItems(data);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
