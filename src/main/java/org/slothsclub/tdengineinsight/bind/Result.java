package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class Result<T> {
    ResponseCode code;
    String message;

    T payload;
    long ts;

    public Result() {
        this.ts = System.currentTimeMillis();
    }

    public Result(ResponseCode code, String message, T payload) {
        this.code = code;
        this.message = message;
        this.payload = payload;
    }

    public static <T> Result<T> success(T data) {
        Result<T> resultData = new Result<>();
        resultData.setCode(ResponseCode.SUCCESS);
        resultData.setMessage("OK");
        resultData.setPayload(data);
        return resultData;
    }

    public static <T> Result<T> fail(ResponseCode code, String message) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> Result<T> fail(ResponseCode code, String message, T data) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setPayload(data);
        return resultData;
    }
}
