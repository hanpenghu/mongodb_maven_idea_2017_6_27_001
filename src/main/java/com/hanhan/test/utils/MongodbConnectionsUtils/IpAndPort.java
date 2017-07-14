package com.hanhan.test.utils.MongodbConnectionsUtils;

/**
 * Created by Administrator on 2017-07-13.
 */
public class IpAndPort {
    private String ip;
    private Integer port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.hanhan.test.utils.MongodbConnectionsUtils.IpAndPort{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }
}
