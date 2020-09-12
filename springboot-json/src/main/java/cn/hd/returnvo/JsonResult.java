package cn.hd.returnvo;

import lombok.Data;

@Data
public class JsonResult<T> {
    private T date;
    private String code;
    private String msg;

    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T date) {
        this.date = date;
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResult(T date, String msg) {
        this.date = date;
        this.code = "200";
        this.msg = msg;
    }

    public JsonResult(T date, String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }
}
