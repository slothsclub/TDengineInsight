package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class Result<T> {
    String code;
    String message;

    T payload;
    long ts;

    public Result() {
        this.ts = System.currentTimeMillis();
    }

    public Result(String code, String message, T payload) {
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

    public static <T> Result<T> fail(String code, String message) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
}
