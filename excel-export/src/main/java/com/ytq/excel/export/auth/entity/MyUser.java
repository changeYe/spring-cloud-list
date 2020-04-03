package com.ytq.excel.export.auth.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
public class MyUser implements UserDetails {

    private UserPO userPO;
    private List<UserPermissionPO> userPermissionList;

    public MyUser(UserPO userPO, List<UserPermissionPO> userPermissionList) {
        this.userPO = userPO;
        this.userPermissionList = userPermissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userPermissionList.stream()
                .filter(info-> !StringUtils.isEmpty(info.getUrl()))
                .map(info->new SimpleGrantedAuthority(info.getUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userPO.getPassword();
    }

    @Override
    public String getUsername() {
        return userPO.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
