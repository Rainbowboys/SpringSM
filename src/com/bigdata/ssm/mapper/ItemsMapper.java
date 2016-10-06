package com.bigdata.ssm.mapper;

import com.bigdata.ssm.po.Items;
import com.bigdata.ssm.po.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
	int countByExample(ItemsExample example) throws Exception;

	int deleteByExample(ItemsExample example) throws Exception;

	int deleteByPrimaryKey(Integer id) throws Exception;

	int insert(Items record) throws Exception;

	int insertSelective(Items record) throws Exception;

	List<Items> selectByExampleWithBLOBs(ItemsExample example) throws Exception;

	List<Items> selectByExample(ItemsExample example) throws Exception;

	Items selectByPrimaryKey(Integer id) throws Exception;

	int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example)
			throws Exception;

	int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example)
			throws Exception;

	int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example) throws Exception;

	int updateByPrimaryKeySelective(Items record) throws Exception;

	int updateByPrimaryKeyWithBLOBs(Items record) throws Exception;

	int updateByPrimaryKey(Items record) throws Exception;
}