package com.dgse.viperapp.domain.dal.server;


import com.dgse.viperapp.domain.model.AbuBoardModel;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Андрей on 16.01.2017.
 */

public class BoardsEndpoint extends BaseEndpoint {
    Service service;

    public BoardsEndpoint() {
        super();
        service = retrofit.create(Service.class);
    }

    public Observable<Map<String, List<AbuBoardModel>>> getBoards() {
        return service.getBoards();
    }

    public interface Service {
        @GET("makaba/mobile.fcgi?task=get_boards")
        Observable<Map<String, List<AbuBoardModel>>> getBoards();
    }
}
