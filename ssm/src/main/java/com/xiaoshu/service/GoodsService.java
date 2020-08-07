package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.GoodsMapper;
import com.xiaoshu.dao.GoodstypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsVo;
import com.xiaoshu.entity.Goodstype;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
		
	@Autowired
	GoodstypeMapper goodstypeMapper;
	public List<Goodstype>findGoodstype(){
		return goodstypeMapper.selectAll();//selectAll查询所有 //List里面的条件为附表        
																//这个方法只用于查询附表所有信息
		
	}
	
	
	
	
	
	
				public PageInfo<GoodsVo> findPage(GoodsVo goodsVo,Integer pageNum,Integer pageSize){
					PageHelper.startPage(pageNum, pageSize);
					List<GoodsVo>list = goodsMapper.findList(goodsVo);
					return new PageInfo<>(list);
				}
				
				
				
		//去除重复
	public Goods findName(String name){
		Goods param=new Goods();
		param.setName(name);
		return goodsMapper.selectOne(param);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateByPrimaryKeySelective(goods);
	}
	public void addGoods(Goods goods){
		goods.setCreatetime(new Date());
		goodsMapper.insert(goods);
	}
}
