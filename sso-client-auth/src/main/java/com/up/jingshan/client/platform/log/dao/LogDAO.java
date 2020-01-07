package com.up.jingshan.client.platform.log.dao;

import com.up.jingshan.client.platform.log.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jingshan
 * @version 1.fontawesome
 * @description 日志DAO
 * @date 2019/5/22
 */
public interface LogDAO extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {


}
