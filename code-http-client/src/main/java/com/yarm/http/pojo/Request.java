package com.yarm.http.pojo;

/**
 * @program: base-parent
 * @description: 请求入参
 * @author: yarm
 * @create: 2019-11-18 11:02
 */
public class Request<T> {
    private String host;
    private String uri;
    private T data;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "host='" + host + '\'' +
                ", uri='" + uri + '\'' +
                ", data=" + data +
                '}';
    }
}