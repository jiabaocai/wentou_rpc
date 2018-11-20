package com.bwtservice.service;

import com.bwtservice.entity.AssetsidePropertyWithBLOBs;
import com.bwtservice.entity.AssetsideWithBLOBs;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface AssetsideService {

    int addAssetside(AssetsideWithBLOBs assetsideWithBLOBs);


    int addAssetsideProperty(AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs);


    PageInfo<AssetsideWithBLOBs> getAssetsideByPage(AssetsideWithBLOBs assetsideWithBLOBs,int pageNum,int pageSize);

    AssetsidePropertyWithBLOBs getAssProByAssId(int assetsideId);
    AssetsideWithBLOBs getAssByassId(Integer assId);

    int editAssetside(AssetsideWithBLOBs assetsideWithBLOBs);

    int editAssetsidePropety(AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs);
}
