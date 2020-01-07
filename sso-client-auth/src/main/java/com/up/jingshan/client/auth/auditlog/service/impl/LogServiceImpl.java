package com.up.jingshan.client.auth.auditlog.service.impl;

import com.up.jingshan.client.auth.auditlog.service.LogService;
import com.up.jingshan.client.auth.common.response.PageResult;
import com.up.jingshan.client.platform.log.dao.LogDAO;
import com.up.jingshan.client.platform.log.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jingshan
 * @version 1.fontawesome
 * @description 日志服务
 * @date 2019/5/22
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;

    @Override
    public PageResult<Log> queryByPage(int page, int limit, String url) {
        PageResult<Log> result = new PageResult<>();
        Sort sort = new Sort(Sort.Direction.DESC, new String[]{"reqTime"});
        Pageable startPage = PageRequest.of(page - 1, limit, sort);
        Page<Log> pages = logDAO.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(url)) {
                predicates.add(criteriaBuilder.like(root.get("uri"), "%" + url + "%"));
            }
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
            return criteriaQuery.getRestriction();
        }, startPage);
        result.setCount(pages.getTotalElements());
        result.setData(((Page) pages).getContent());
        return result;
    }

    @Override
    public void deleteByID(Long id) {
        logDAO.deleteById(id);
    }
}
