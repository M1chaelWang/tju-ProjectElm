package com.neusoft.elm.dao;

import java.util.List;
import com.neusoft.elm.po.Food;

public interface FoodDao {
	// 获取食品列表
	public List<Food> listFoodByBusinessId(Integer businessId);

	// 保存食品
	public int saveFood(Food food);

	// 获取食品Id
	public Food getFoodById(Integer foodId);

	// 更新食品
	public int updateFood(Food food);

	// 删除食品
	public int removeFood(Integer foodId);
}
