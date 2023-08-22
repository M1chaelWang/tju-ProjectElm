package com.neusoft.elm.dao;

import com.neusoft.elm.po.Admin;

public interface AdminDao // dao层接口
{
    public Admin getAdminByNameByPass(String adminName, String password);

}
