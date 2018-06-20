package com.cnadmart.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnadmart.dao.SysGeneratorDao;
import com.cnadmart.utils.GenUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午10:06:50
 */
@Service
public class SysGeneratorService {
	@Autowired
	private SysGeneratorDao sysGeneratorDao;

	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return sysGeneratorDao.queryList(map);
	}

	public int queryTotal(Map<String, Object> map) {
		return sysGeneratorDao.queryTotal(map);
	}

	public Map<String, String> queryTable(String tableName) {
		return sysGeneratorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return sysGeneratorDao.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			// 生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	public void generatorAllCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			// 生成代码
			GenUtils.generatorAllCode(table, columns);
		}
	}

	public void generatorApiCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			// 生成代码
			GenUtils.generatorApiCode(table, columns);
		}
	}

	public void updateCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			// 生成代码
			GenUtils.updateCode(table, columns);
		}

	}
}
