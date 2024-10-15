package com.tedu.teamserver.pojo.ServerResult;

public class ServerResult {
    Integer state;//状态码0：success
    String msg;//对状态码的描述
    Object data;//返回的数据

    //有参数的构造方法
    public ServerResult(Integer state, String msg, Object data){
        this.data = data;
        this.state = state;
        this.msg = msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
