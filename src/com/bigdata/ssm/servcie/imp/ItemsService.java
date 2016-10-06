package com.bigdata.ssm.servcie.imp;

import java.util.List;

import com.bigdata.ssm.po.Items;
import com.bigdata.ssm.po.QueryItemsVo;

public interface ItemsService {
	public List<Items> findItemsByName(QueryItemsVo queryItemsVo) throws Exception;

	public Items selectByPrimaryKey(Integer id) throws Exception;

	public int updateByPrimaryKeySelective(Items record) throws Exception;

}
