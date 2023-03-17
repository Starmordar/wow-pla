package io.github.sammers.pla;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.mongo.MongoClient;
import io.vertx.reactivex.ext.web.client.WebClient;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        WebClient webClient = WebClient.create(vertx);
        MongoClient mongoClient = MongoClient.createShared(vertx, new JsonObject()
                .put("db_name", "pvpq")
                .put("connection_string", String.format("mongodb://root:%s@161.35.72.39:27017", args[0]))
        );
        Ladder ladder = new Ladder(vertx, webClient, mongoClient);
        ladder.start();
        new Http(vertx, ladder).start();
    }
}
