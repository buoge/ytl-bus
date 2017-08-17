package com.lantaiyuan.ebus.common.util;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ObjectMappingCustomer extends ObjectMapper {

    /**
     * 
     */
    private static final long serialVersionUID = -6401263387943827254L;

    public ObjectMappingCustomer() {
	super();
	// 数字也加引号
        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
	//将返回的json对象中的null替换为“”
	this.getSerializerProvider().setNullValueSerializer(new com.fasterxml.jackson.databind.JsonSerializer<Object>() {
	    @Override
	    public void serialize(Object arg0, JsonGenerator jg, SerializerProvider arg2)
		    throws IOException, JsonProcessingException {
		 jg.writeString("");
	    }
	});

    }
}
