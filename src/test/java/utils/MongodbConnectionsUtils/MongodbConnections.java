package utils.MongodbConnectionsUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-13.
 */
public class MongodbConnections {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static MongoClient getMongoClient(List<IpAndPort>IpAndPorts, List<UserNameRolesPwd>userNameRolesPwds){
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        for(IpAndPort iap:IpAndPorts){
            addrs.add(new ServerAddress(iap.getIp(),iap.getPort()));
        }
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        for(UserNameRolesPwd unrp:userNameRolesPwds){
            credentials.add(MongoCredential.createScramSha1Credential(unrp.getUserName(), unrp.getRoles(), unrp.getPwd().toCharArray()));
        }

        //这里面有个默认的连接池,最大连接数是100,不能改
        MongoClientOptions.Builder mcob=MongoClientOptions.builder();
        MongoClientOptions mco = mcob.build();
        //通过连接认证获取MongoDB连接//默认使用了连接池,最大连接数100,并且是final的,我看了源码了
        MongoClient mongoClient = new MongoClient(addrs,credentials,mco);
        return mongoClient;

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void f(){
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        //由于数据库admin是超级管理员root,rootroot注册的,所以登录admin之后可以操作所有数据库
        MongoCredential credential = MongoCredential.createScramSha1Credential("root", "admin", "rootroot".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);


        //这里面有个默认的连接池,最大连接数是100,不能改
        MongoClientOptions.Builder mcob=MongoClientOptions.builder();
        MongoClientOptions mco = mcob.build();


        //通过连接认证获取MongoDB连接//默认使用了连接池,最大连接数100,并且是final的,我看了源码了
        MongoClient mongoClient = new MongoClient(addrs,credentials,mco);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
