package com.bigdata.ssm.mapper;

import java.util.List;

import com.bigdata.ssm.po.Items;
import com.bigdata.ssm.po.QueryItemsVo;

public interface ItemsMapperCustom {

	public List<Items> findItemsByName(QueryItemsVo queryItemsVo);

}