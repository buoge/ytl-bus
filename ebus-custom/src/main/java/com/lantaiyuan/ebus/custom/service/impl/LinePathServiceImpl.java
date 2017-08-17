package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.LinePathMapper;
import com.lantaiyuan.ebus.custom.model.mytrail.LinePath;
import com.lantaiyuan.ebus.custom.service.LinePathServiceI;
@Service
public class LinePathServiceImpl implements LinePathServiceI {

	@Resource
	private LinePathMapper linePathMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return linePathMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(LinePath record) {
		return linePathMapper.insert(record);
	}

	@Override
	public int insertSelective(LinePath record) {
		return linePathMapper.insertSelective(record);
	}

	@Override
	public LinePath selectByPrimaryKey(String id) {
		return linePathMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(LinePath record) {
		return linePathMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LinePath record) {
		return linePathMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<LinePath> getLinePathsByMyTrailId(Integer mytrailid) {
		return linePathMapper.getLinePathsByMyTrailId(mytrailid);
	}

}
