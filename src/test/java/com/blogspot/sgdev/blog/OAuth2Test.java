package com.blogspot.sgdev.blog;

import org.jose4j.json.JsonUtil;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author thomas.tesche
 */
public class OAuth2Test {

    protected static final Logger logger = LoggerFactory.getLogger(OAuth2Test.class);
    protected JwtConsumer jwtConsumer;

    @Before
    public void setup() {
        jwtConsumer = new JwtConsumerBuilder().setSkipAllValidators().setDisableRequireSignature()
                                              .setSkipSignatureVerification()
                                              .build();
    }

    protected void logJWTClaims(JwtContext jwtContext) {
        try {
            logger.info(prettyPrintJson(JsonUtil.toJson(jwtContext.getJwtClaims().getClaimsMap())));
        } catch (JSONException e) {
            logger.warn("JSON Object not parsable");
        }
    }

    protected void logJson(String json) {

        try {
            logger.info(prettyPrintJson(json));
        } catch (JSONException e) {
            logger.warn("JSON Object not parsable");
        }
    }

    protected String prettyPrintJson(String flatJson) throws JSONException {
        return (new JSONObject(flatJson).toString(3));
    }

}
