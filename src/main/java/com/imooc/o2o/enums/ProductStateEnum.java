package com.imooc.o2o.enums;

public enum ProductStateEnum {
	
	SUCCESS(1,"创建成功"),INNER_ERROR(-1001,"操作失败"),
	EMPTY(-1002,"添加数小于1");
	
	private int state;
	private String stateInfo;
	
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	
	private ProductStateEnum(int state,String sateInfo) {
		this.state=state;
		this.stateInfo=sateInfo;
	}
	/**
	 * 根据传人的state返回相应的enum值
	 * @param state
	 * @return
	 */
    public static ProductStateEnum sateOf(int state) {
    	for(ProductStateEnum stateEnum:values()) {
    		if(stateEnum.getState()==state)
    		
    		return stateEnum;
    	}
    	return null;
    }
    
    
}
