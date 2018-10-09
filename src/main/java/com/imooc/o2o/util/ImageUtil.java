package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import com.imooc.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;

import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片处理工具类
 * @author Administrator
 *
 */
public class ImageUtil {
	// 获取classpath的绝对值路径
	private static String basePath=Thread.currentThread()
			.getContextClassLoader().getResource("").getPath();
	// 时间格式化的格式
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	// 随机数
	private static final Random r=new Random();
	
	/**
	 * 处理商铺缩略图
	 * 
	 * @param thumbnail
	 *            Spring自带的文件处理对象
	 * @param targetAddr
	 *            图片存储路径
	 * @return
	 */
	public static String generateThumbnail(ImageHolder thumbnail,String targetAddr) {
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage())
			.size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"watermark.jpg")),0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e){
			throw new RuntimeException("创建缩略图失败"+e.toString());	
		}
		return relativeAddr;
	}
	
	/**
	 * 创建目标路径所涉及到的目录，即/home/work
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	
	
	/**
	 * 获取输入文件流的拓展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		
		return fileName.substring(fileName.lastIndexOf("."));
		
	}
	
	/**
	 * 生成随机文件名，当前年月日小时分秒+五位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		//获取随机的五位数
		int rannum=r.nextInt(89999)+10000;
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}
	/**
	 * storePath是文件的路径还是目录的路径
	 * 如果是文件路径则删除该文件
	 * 如果是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[]=fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
	
	public static String generateNormalImg(ImageHolder thumbnail,String targetAddr) {
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage())
			.size(337, 640)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"watermark.jpg")),0.25f)
			.outputQuality(0.9f).toFile(dest);
		}catch(IOException e){
			throw new RuntimeException("创建缩略图失败"+e.toString());	
		}
		return relativeAddr;
	}

}
