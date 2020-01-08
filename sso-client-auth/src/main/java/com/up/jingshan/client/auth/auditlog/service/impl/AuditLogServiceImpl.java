package com.up.jingshan.client.auth.auditlog.service.impl;

import com.up.jingshan.client.auth.auditlog.mapper.AuditLogMapper;
import com.up.jingshan.client.auth.auditlog.model.AuditLog;
import com.up.jingshan.client.auth.auditlog.service.AuditLogService;
import com.up.jingshan.client.auth.common.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jingshan
 * @version 1.0
 * @description 日志服务
 * @date 2019/5/22
 */
@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    AuditLogMapper auditLogMapper;

    @Override
    public PageResult<AuditLog> queryByPage(int page, int limit, String url) {
        PageResult<AuditLog> result = new PageResult<>();
        result.setCount(auditLogMapper.selectCount());
        result.setData(auditLogMapper.selectByPage((page-1)*limit, limit, url));
        return result;
    }

    @Override
    public void deleteByID(int id) {

    }
    //    @Autowired
//    private LogDAO logDAO;
//
//    @Override
//    public PageResult<AuditLog> queryByPage(int page, int limit, String url) {
//        PageResult<AuditLog> result = new PageResult<>();
//        Sort sort = new Sort(Sort.Direction.DESC, new String[]{"reqTime"});
//        Pageable startPage = PageRequest.of(page - 1, limit, sort);
//        Page<AuditLog> pages = logDAO.findAll((root, criteriaQuery, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            if (!StringUtils.isEmpty(url)) {
//                predicates.add(criteriaBuilder.like(root.get("uri"), "%" + url + "%"));
//            }
//            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
//            return criteriaQuery.getRestriction();
//        }, startPage);
//        result.setCount(pages.getTotalElements());
//        result.setData(((Page) pages).getContent());
//        return result;
//    }
//
//    @Override
//    public void deleteByID(Long id) {
//        logDAO.deleteById(id);
//    }
}
