package com.hanhan.test.utils.MongodbConnectionsUtils;

/**
 * Created by Administrator on 2017-07-13.
 */
public class UserNameRolesPwd {
    private String userName;
    private String roles;
    private String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("com.hanhan.test.utils.MongodbConnectionsUtils.UserNameRolesPwd{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", roles='").append(roles).append('\'');
        sb.append(", pwd='").append(pwd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
