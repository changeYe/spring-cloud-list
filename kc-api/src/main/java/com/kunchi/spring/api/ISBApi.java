package com.kunchi.spring.api;

import com.kunchi.spring.model.result.ISBResult;

/**
 * yuantongqin
 * 2019/3/4
 */
public interface ISBApi<R,P> {

    ISBResult<R> process(P params) throws Exception;

}
