package cn.hangzhou.fans.exception;

public class ResultException extends Exception {
    private Integer code;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
