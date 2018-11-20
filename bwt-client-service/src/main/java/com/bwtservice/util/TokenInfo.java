package com.bwtservice.util;

import lombok.Data;

@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType=1;

    /** App 信息 */
    private AppInfo appInfo=new AppInfo();

    /** 用户其他数据 */
//    private UserInfo userInfo;
}
