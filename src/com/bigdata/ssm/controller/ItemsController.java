package com.bigdata.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bigdata.ssm.controller.validivate.ValidatedGroup1;
import com.bigdata.ssm.exceptions.CustomException;
import com.bigdata.ssm.po.ItemCustom;
import com.bigdata.ssm.po.Items;
import com.bigdata.ssm.po.QueryItemsVo;
import com.bigdata.ssm.servcie.imp.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	/**
	 * 这个 注解会将方法的返回值内容返回到页面的request域中
	 * 
	 * @return
	 */
	@ModelAttribute("itemTypes")
	public Map<String, String> getItemTypes() {
		Map<String, String> itemTypes = new HashMap<String, String>();
		// 模拟静态数据
		itemTypes.put("101", "母婴");
		itemTypes.put("102", "教育");
		return itemTypes;
	}

	// 测试json解析
	
	/**
	 * @RequestBody 将json对象转成java pojo对象
	 * @ResponseBody 将 Java 对象 返回 json对象
	 * @param itemCustom
	 * @return
	 */
	@RequestMapping("/testJson")
	public @ResponseBody ItemCustom testJson(@RequestBody ItemCustom itemCustom) {
		return itemCustom;
	}

	// 包装类型传递查询条件
	@RequestMapping("/queryItems")
	public String findItems(Model model, QueryItemsVo queryItemsVo) throws Exception {
		List<Items> itemsList = itemsService.findItemsByName(queryItemsVo);
		model.addAttribute("itemsList", itemsList);
		return "itemsList";
	}

	@RequestMapping("/editItems")
	public String editItems(Model model, Integer id) throws Exception {
		// 根据id查找 items
		Items items = itemsService.selectByPrimaryKey(id);
		model.addAttribute("item", items);
		return "editItem";
	}

	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,
			@Validated(value = ValidatedGroup1.class) @ModelAttribute("item") ItemCustom itemCustom,
			BindingResult result, MultipartFile item_pic) throws Exception {
		if (itemCustom != null) {
			if (itemCustom.getCreatetime() == null) {
				throw new CustomException("日期不为空!");
			}
		}
		// 服务端验证 controller验证
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			return "editItem";
		}

		// 上传图片
		if (item_pic != null) {
			// 文件原始名字
			String fileName = item_pic.getOriginalFilename();
			// 文件后缀名
			String lastName = fileName.substring(fileName.lastIndexOf("."));

			String new_fileName = UUID.randomUUID().toString() + lastName;

			String pic_path = "D:\\update\\temp\\2016\\" + new_fileName;

			File up_picfile = new File(pic_path);
			if (!up_picfile.exists()) {
				up_picfile.mkdirs();
			}
			// 将文件写入磁盘
			item_pic.transferTo(up_picfile);
			itemCustom.setPic(new_fileName);
		}

		int a = itemsService.updateByPrimaryKeySelective(itemCustom);
		return "redirect:queryItems.action";
	}
	// 接收数组类型的参数

	@RequestMapping("/deleteItems")
	public String deleteItems(int[] item_id) {
		return "redirect:queryItems.action";
	}
	// 批量删除 信息的传递集合list 类型的参数

	@RequestMapping("/editAllitems")
	public String editAllitems(Model model) throws Exception {
		List<Items> itemsList = itemsService.findItemsByName(null);
		model.addAttribute("itemsList", itemsList);
		return "itemseditAll";
	}

	@RequestMapping("/editAllitemsSubmit")
	public String editAllitemsSubmit(Model model, QueryItemsVo queryItemsVo) throws Exception {

		return "redirect:queryItems.action";
	}

	@RequestMapping("/throws")
	public void tr() throws CustomException {
		throw new CustomException("商品信息不存在!");
	}

}
