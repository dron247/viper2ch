package com.dgse.viperapp.presentation.presenters;

import com.dgse.viperapp.domain.model.AbuBoardModel;
import com.dgse.viperapp.presentation.presenters.base.BasePresenter;
import com.dgse.viperapp.presentation.ui.BaseView;

import java.util.List;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void clearData();

        void addData(List<AbuBoardModel> data);
        // TODO: Add your view methods
    }

    // TODO: Add your presenter methods

}
