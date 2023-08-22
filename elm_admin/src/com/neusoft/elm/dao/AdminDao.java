package com.neusoft.elm.dao;

public interface AdminDao //dao层接口
{
    public Admin getAdminByNameByPass(String adminName,String password);

}
