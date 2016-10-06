package com.bigdata.ssm.servcie.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigdata.ssm.exceptions.CustomException;
import com.bigdata.ssm.mapper.ItemsMapper;
import com.bigdata.ssm.mapper.ItemsMapperCustom;
import com.bigdata.ssm.po.Items;
import com.bigdata.ssm.po.QueryItemsVo;

public class ItemsServiceImp implements ItemsService {
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> findItemsByName(QueryItemsVo queryItemsVo) {
		return itemsMapperCustom.findItemsByName(queryItemsVo);
	}

	@Override
	public Items selectByPrimaryKey(Integer id) throws Exception {

		Items items = itemsMapper.selectByPrimaryKey(id);
		if (items == null) {
			throw new CustomException("商品信息不存在!");
		}
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Items record) throws Exception {
		return itemsMapper.updateByPrimaryKeySelective(record);
	}

}
