package org.kayura.mybatis.type;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertiesTypeHandler extends BaseTypeHandler<Properties> {
    
    ObjectMapper objectMapper = new ObjectMapper();
    
    public PropertiesTypeHandler() {
    }
    
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Properties parameter,
	    JdbcType jdbcType) throws SQLException {
	String s;
	try {
	    s = objectMapper.writeValueAsString(parameter);
	    ps.setString(i, s);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}
    }
    
    private Properties getJsonObject(String json) {
	Properties o = null;
	try {
	    if (json != null && json != "") {
		o = (Properties) objectMapper.readValue(json, Properties.class);
	    }
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return o;
    }
    
    @Override
    public Properties getNullableResult(ResultSet rs, String columnName) throws SQLException {
	String json = rs.getString(columnName);
	return getJsonObject(json);
    }
    
    @Override
    public Properties getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	String json = rs.getString(columnIndex);
	return getJsonObject(json);
    }
    
    @Override
    public Properties getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	String json = cs.getString(columnIndex);
	return getJsonObject(json);
    }
}
