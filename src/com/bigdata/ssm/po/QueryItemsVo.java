package com.bigdata.ssm.po;

import java.util.List;

/**
 * @Title:QueryItemsVo
 * @Description:�Զ����װ���� ��pojo���� ��װ���ӵĲ�ѯ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��5�� ����10:18:22
 */
public class QueryItemsVo {

	private Items items;

	private ItemCustom itemCustom;

	private List<ItemCustom> itemList;

	public List<ItemCustom> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemCustom> itemList) {
		this.itemList = itemList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemCustom getItemCustom() {
		return itemCustom;
	}

	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}

}
