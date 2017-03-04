package demo.rxjavaretorfitdemo.network;

/**
 * @explain 服务器错误码
 * @author liuml.
 * @time 2017/3/4 17:28
 */
public class ServerException extends Exception {

    public static final int ERROR_NETWORK = -1;
    public static final int ERROR_OTHER = -2;

    private int errorCode = ERROR_OTHER;

    public int getErrorCode() {
        return errorCode;
    }

    public ServerException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
