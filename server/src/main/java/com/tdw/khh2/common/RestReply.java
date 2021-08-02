package com.tdw.khh2.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestReply<T> implements Serializable {
    private int status;//状态
    private String message;//消息
    private String toolTips;//提示信息
    private LocalDateTime timestamp;//返回时间
    private T data;//返回数据

    public static RestReply ok() {
        return RestReply.ok(null, null);
    }

    public static <T> RestReply ok(T data) {
        return RestReply.ok(null, data);
    }

    public static <T> RestReply ok(String toolTips, T data) {
        return new RestReply(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), toolTips, LocalDateTime.now(), data);
    }

//    public static <T> RestReply failed(T data) {
//        return RestReply.failed(null, data);
//    }
//
//    public static <T> RestReply failed(String toolTips, T data) {
//        return new RestReply(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
//                toolTips, LocalDateTime.now(), data);
//    }


    public static RestReply custom(HttpStatus status) {
        return RestReply.custom(status.value(), status.getReasonPhrase(), null, null);
    }

    public static RestReply custom(int status, String message) {
        return RestReply.custom(status, message, null, null);
    }

    public static <T> RestReply custom(int status, String message, String toolTips, T data) {
        return new RestReply(status, message,
                toolTips, LocalDateTime.now(), data);
    }

}
