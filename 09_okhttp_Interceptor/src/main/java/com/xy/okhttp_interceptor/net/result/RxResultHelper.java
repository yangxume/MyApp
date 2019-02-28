package com.xy.okhttp_interceptor.net.result;


import com.xy.okhttp_interceptor.net.schedulers.RxSchedulersHelper;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;


/**
 * 预处理服务器返回数据
 *
 */
public class RxResultHelper {

    /**
     * 预处理结果
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<HttpResult<T>, T> handleResult() {
        return handleResult(RxSchedulersHelper.<T>io_main());
    }

    public static <T> ObservableTransformer<HttpResult<T>, T> handleResult(final ObservableTransformer<T, T> scheduler) {
        return new ObservableTransformer<HttpResult<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<HttpResult<T>> upstream) {
                return upstream.flatMap(new Function<HttpResult<T>, Observable<T>>() {
                    @Override
                    public Observable<T> apply(HttpResult<T> tHttpResult) throws Exception {

                            return createData(tHttpResult.data);

                    }
                })/*.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())*/
                        .compose(scheduler);
            }
        };
    }

    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                try {
                    e.onNext(data);
                    e.onComplete();
                }catch (Exception exception){
                    e.onError(exception);
                }
            }
        });
    }

}
