package io.github.sammers.pla;

import io.vertx.core.json.JsonObject;

public interface JsonConvertable {
    JsonObject toJson();
}
