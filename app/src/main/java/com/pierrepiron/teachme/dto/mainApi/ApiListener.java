package com.pierrepiron.teachme.dto.mainApi;

public interface ApiListener<T> {

    void onSuccess(T response);

    void onError(Throwable throwable);
}
