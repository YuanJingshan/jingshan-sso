package com.up.jingshan.client.auth.user.service.impl;

import com.up.jingshan.client.auth.user.mapper.UserMapper;
import com.up.jingshan.client.auth.user.model.User;
import com.up.jingshan.client.auth.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 用户信息服务-实现
 * @date Create in 2018/11/28 17:46
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
//    @Cacheable(value = "user", key = "#userName")
    public User findByUserName(String userName) {
        return userMapper.selectByUsername(userName);
    }
//
//    @Override
//    public User findByID(String id) {
//        return userDAO.findById(id).orElse(null);
//    }
//
//    @Override
//    public boolean changePwd(User user) {
//        Optional<User> byId = userDAO.findById(user.getId());
//        User oldUser = byId.get();
//        String pwd = user.getNewPassword() + oldUser.getSalt();
//        String encrypt = SM3Util.encrypt(pwd);
//        if (1 == userDAO.updatePassword(encrypt, user.getId())) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        user.setCreateDate(new Date());
//        user.setUpdateDate(new Date());
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        user.setSalt(uuid);
//        String pwd = "123456" + uuid;
//        String encrypt = SM3Util.encrypt(pwd);
//        user.setPassword(encrypt);
//        return userDAO.save(user);
//    }
//
//    @Override
//    public boolean updateUser(User user) {
//        if (StringUtils.isEmpty(user.getId())) {
//            return false;
//        }
//        User tempUser = userDAO.findById(user.getId()).orElse(null);
//        user.setPassword(tempUser.getPassword());
//        user.setSalt(tempUser.getSalt());
//        user.setRole(tempUser.getRole());
//        user.setCreateDate(tempUser.getCreateDate());
//        user.setUpdateDate(new Date());
//        userDAO.save(user);
//        return true;
//    }
//
//    @Override
//    public boolean checkUserName(String userName) {
//        User user = userDAO.findByUserName(userName);
//        if (user != null) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int getTotal() {
//        return userDAO.findAll().size();
//    }
//
//    @Override
//    public PageResult<User> queryByPage(int page, int limit, User loginUser) {
//        PageResult<User> result = new PageResult<>();
//        Sort sort = new Sort(Sort.Direction.DESC, new String[]{"createDate"});
//        Pageable startPage = PageRequest.of(page - 1, limit, sort);
//        Page<User> pages = userDAO.findAll((root, criteriaQuery, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<Predicate>();
//            if (!"1".equals(loginUser.getRole().getId())) {
//                predicates.add(criteriaBuilder.equal(root.get("role").get("id"), loginUser.getRole().getId()));
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
//    public void deleteByID(String id) {
//        userDAO.deleteById(id);
//    }
//
//    @Override
//    public void pwdResetByID(String id) {
//        User user = findByID(id);
//        String salt = user.getSalt();
//        String pwd = "123456" + salt;
//        String encrypt = SM3Util.encrypt(pwd);
//        userDAO.updatePassword(encrypt, id);
//    }
}