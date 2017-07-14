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

}
