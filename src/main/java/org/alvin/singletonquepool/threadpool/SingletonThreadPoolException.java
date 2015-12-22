/**
 * 线程池执行异常
 */
package org.alvin.singletonquepool.threadpool;

/**
 * @author zhangshuang
 */
@SuppressWarnings({"serial", "UnusedDeclaration"})
public class SingletonThreadPoolException extends Exception {

    /**
     *
     */
    public SingletonThreadPoolException() {
    }

    /**
     * @param message 异常信息
     */
    public SingletonThreadPoolException(String message) {
        super(message);
    }

    /**
     * @param cause 异常原因
     */
    public SingletonThreadPoolException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message 异常信息
     * @param cause   异常原因
     */
    public SingletonThreadPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message            异常信息
     * @param cause              异常原因
     * @param enableSuppression  父类有效
     * @param writableStackTrace 回调
     */
    public SingletonThreadPoolException(String message, Throwable cause,
                                        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
