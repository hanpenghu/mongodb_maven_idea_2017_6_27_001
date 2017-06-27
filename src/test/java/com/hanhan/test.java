package com.hanhan;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public class test {
// when have no secret of db
    public void f(){
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("lianxi4");
        mongoDatabase.createCollection("lianxi004");
        System.out.println(mongoDatabase);
    }
//when have secret
    public void g(){
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

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("lianxi3");
        System.out.println("Connect to database successfully");
        //没有的话创建一个集合
//        mongoDatabase.createCollection("lianxi1");
        //获得现有的collection如下
        MongoCollection<Document> collection = mongoDatabase.getCollection("lianxi1");




        Document document =
                new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        System.out.println("文档插入成功");

    }



    //检索所有文档
    public void h(){
        try{
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

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("lianxi3");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("lianxi1");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }





    public static void main(String[]args){
//        new test().f();
//        new test().g();
        new test().h();
    }
}
