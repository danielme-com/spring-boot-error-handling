package com.danielme.springboot.model;

public class CustomErrorJson {

    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final String trace;
    private final String jdk;

    public CustomErrorJson(int status, String error, String message, String path, String trace, String jdk) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.trace = trace;
        this.jdk = jdk;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getTrace() {
        return trace;
    }

    public String getJdk() {
        return jdk;
    }
}
