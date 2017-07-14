package com.hanhan;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import utils.MongodbConnectionsUtils.IpAndPort;
import utils.MongodbConnectionsUtils.MongodbConnections;
import utils.MongodbConnectionsUtils.UserNameRolesPwd;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-07-14.
 */
public class Test1 {
    public void f(){
        List<IpAndPort> ipAndPorts=new ArrayList();
        List<UserNameRolesPwd>userNameRolesPwd=new ArrayList();
        IpAndPort iap=new IpAndPort();
        UserNameRolesPwd unrp=new UserNameRolesPwd();
        iap.setIp("127.0.0.1");
        iap.setPort(27017);
        unrp.setUserName("root");
        unrp.setRoles("admin");
        unrp.setPwd("rootroot");
        ipAndPorts.add(iap);
        userNameRolesPwd.add(unrp);
        MongoClient mongoClient = MongodbConnections.getMongoClient(ipAndPorts, userNameRolesPwd);
        MongoDatabase lianxi3 = mongoClient.getDatabase("lianxi3");
        MongoCollection<Document> lianxi003 = lianxi3.getCollection("lianxi003");
        FindIterable<Document> findIterable = lianxi003.find();
        for(MongoCursor<Document> mongoCursor = findIterable.iterator(); mongoCursor.hasNext();){
            System.out.println(mongoCursor.next().get("age"));
        }

    }
    public static void main(String[]args){
        new Test1().f();
    }
}
