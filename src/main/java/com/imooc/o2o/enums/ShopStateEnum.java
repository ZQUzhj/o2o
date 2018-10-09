package com.imooc.o2o.enums;

public enum ShopStateEnum {
	
	CHECK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
	PASS(2,"通过审核"),INNER_ERROR(-1001,"内部系统错误"),
	NULL_SHOPID(-1002,"ShopId为空"),NULL_SHOP(-1003,"shop信息为空");
	
	private int state;
	private String stateInfo;
	
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	
	private ShopStateEnum(int state,String sateInfo) {
		this.state=state;
		this.stateInfo=sateInfo;
	}
	/**
	 * 根据传人的state返回相应的enum值
	 * @param state
	 * @return
	 */
    public static ShopStateEnum sateOf(int state) {
    	for(ShopStateEnum stateEnum:values()) {
    		if(stateEnum.getState()==state)
    		
    		return stateEnum;
    	}
    	return null;
    }
    
    
}