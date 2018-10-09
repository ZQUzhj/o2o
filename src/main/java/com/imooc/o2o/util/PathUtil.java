package com.imooc.o2o.util;

public class PathUtil {
	
	/*获取不同操作系统的分隔符*/
	private static String separator=System.getProperty("file.separator");
	
	/**
	 * 获取存放图片路径
	 */
	public static String getImgBasePath() {
		// 获取操作系统的信息
		String os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")) {
			basePath="I:/o2o/projectdev/image/";// Windows系统

		}else {
			basePath="/home/o2o/image/"; // 除了Windows系统
		}
		basePath=basePath.replace("/", separator);
		return basePath;
	}
	public static String getShopImagePath(long shopId) {
	
		String imagePath="upload/item/shop/"+shopId+"/";
		return imagePath.replace("/", separator);
	}

}
